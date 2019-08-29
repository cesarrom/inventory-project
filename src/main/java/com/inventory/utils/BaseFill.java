package com.inventory.utils;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.hibernate.collection.internal.PersistentBag;
import org.springframework.util.ClassUtils;

import com.inventory.models.CommonModel;
import com.inventory.models.dto.CommonModelDto;

class IncludeMapping {
	private String desiredMap;
	private Object source;
	private Object target;
	private Boolean executed = false;

	public IncludeMapping(String desiredMap, Object source, Object target) {
		this.desiredMap = desiredMap;
		this.source = source;
		this.target = target;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void secureExecute(final Object source, final Object target, final String desiredMap) {
		if (ObjectUtils.isFalsey(target))
			throw new RuntimeException("Target is NULL!");
		Class<?> sourceClass = source.getClass();
		Class<?> targetClass = target.getClass();
		Class<?> sourceFieldClass = ObjectUtils.getFieldClass(sourceClass, desiredMap);
		Class<?> targetFieldClass = ObjectUtils.getFieldClass(targetClass, desiredMap);
		Object sourceFieldValue = ObjectUtils.getValueBykey(source, desiredMap);
		Object targetFieldValue = ObjectUtils.getValueBykey(target, desiredMap);
		Boolean isSourceCollection = PersistentBag.class.isAssignableFrom(sourceFieldValue.getClass()) || PersistentBag.class.isAssignableFrom(sourceFieldClass) || Collection.class.isAssignableFrom(sourceFieldClass);
		Boolean isTargetCollection = Collection.class.isAssignableFrom(targetFieldClass);
		Boolean areBothCollections = isSourceCollection && isTargetCollection;
		Boolean areDirectlyCompatible = sourceFieldClass.equals(targetFieldClass);
		Boolean isSourceObject = !ClassUtils.isPrimitiveOrWrapper(sourceFieldClass);
		Boolean isTargetFieldNull  = ObjectUtils.isFalsey(targetFieldValue);
		Boolean isTargetObject = !ClassUtils.isPrimitiveOrWrapper(targetFieldClass);
		Boolean areBothObjects = isSourceObject && isTargetObject;
		Boolean isSourceFiledNull = ObjectUtils.isFalsey(sourceFieldValue);
		if (isSourceFiledNull) {
			ObjectUtils.setValueByKey(target, desiredMap, sourceFieldValue);
			return;
		} else if (areDirectlyCompatible && !areBothCollections) {
			targetFieldValue = sourceFieldValue;
		} else if (isSourceCollection && isTargetCollection) {
			Field innerSourceFiled = ObjectUtils.getFieldByName(sourceClass, desiredMap);
			Field innerTargetField = ObjectUtils.getFieldByName(targetClass, desiredMap);
			Class<?> innerSourceFieldClass = ObjectUtils
					.getWrappedGenericType(innerSourceFiled);
			Class<?> innerTargetFieldClass = ObjectUtils
					.getWrappedGenericType(innerTargetField);
			if (innerSourceFieldClass.equals(innerTargetFieldClass)) {
				targetFieldValue = sourceFieldValue;
			} else {
				List targetList = new ArrayList<>();
				Collection sourceList = (Collection) sourceFieldValue;
				if(sourceList.size() >= 0)
					sourceList.forEach(crrItem -> {
						Object desiredObject = ObjectUtils.createNewInstanceForType(innerTargetFieldClass);
						if (ObjectUtils.isThruthy(desiredObject)) {
							ObjectUtils.copyPropertiesIgnoringNulls(crrItem, desiredObject);
							targetList.add(desiredObject);
						}
					});
				targetFieldValue = targetList;
			}
		} else if (isTargetFieldNull && areBothObjects && !areDirectlyCompatible) {
			targetFieldValue = ObjectUtils.createNewInstanceForType(targetFieldClass);
			ObjectUtils.copyPropertiesIgnoringNulls(sourceFieldValue, targetFieldValue);
		} else if (areBothObjects && !areDirectlyCompatible) {
			ObjectUtils.copyPropertiesIgnoringNulls(sourceFieldValue, targetFieldValue);
		}
		ObjectUtils.setValueByKey(target, desiredMap, targetFieldValue);
	}

	public Object secureExecuteAndGetTargetProp() {
		if (!this.executed) {
			secureExecute(source, target, desiredMap);
			this.executed = true;
		}
		return ObjectUtils.getValueBykey(this.target, this.desiredMap);
	}

	public Object secureExecuteAndGetSourceProp() {
		if (!this.executed) {
			secureExecute(source, target, desiredMap);
			this.executed = true;
		}
		return ObjectUtils.getValueBykey(this.source, this.desiredMap);
	}

	public String getDesiredMap() {
		return desiredMap;
	}

	public void setDesiredMap(String desiredMap) {
		this.desiredMap = desiredMap;
	}

	public Object getSource() {
		return source;
	}

	public void setSource(Object source) {
		this.source = source;
	}

	public Object getTarget() {
		return target;
	}

	public void setTarget(Object target) {
		this.target = target;
	}

}

public class BaseFill {
	private static Boolean hasPreffix(String include) {
		if (ObjectUtils.isThruthy(include))
			return include.indexOf(".") >= 0;
		return false;
	}

	private static String getPreffix(String include) {
		if (hasPreffix(include))
			return include.split("\\.")[0];
		return null;
	}

	public static void mapIncludes(final String[] includes, Object source, Object target) {
		if (ObjectUtils.isFalsey(source) || ObjectUtils.isFalsey(target)
				|| ClassUtils.isPrimitiveOrWrapper(source.getClass())
				|| ClassUtils.isPrimitiveOrWrapper(target.getClass())) {
			return;
		}
		ObjectUtils.copyPropertiesIgnoringNulls(source, target);
		if (ObjectUtils.isThruthy(includes)) {
			Arrays.stream(includes).forEach(include -> {
				String actualInclude = include;
				if (hasPreffix(include)) {
					actualInclude = getPreffix(include);
					IncludeMapping includeMap = null;
					if (ObjectUtils.isAllThruthy(actualInclude, source))
						includeMap = new IncludeMapping(actualInclude, source, target);
					else
						return;
					String[] includesForCurrentScope = collectIncludesForPreffix(actualInclude, includes);
					if (ObjectUtils.isAllThruthy(includesForCurrentScope, includeMap.secureExecuteAndGetSourceProp()))
						mapIncludes(includesForCurrentScope, includeMap.secureExecuteAndGetSourceProp(),
								includeMap.secureExecuteAndGetTargetProp());
				} else {
					IncludeMapping includeMap = new IncludeMapping(actualInclude, source, target);
					includeMap.secureExecuteAndGetTargetProp();
				}
			});
		}
		return;

	}

	private static String[] collectIncludesForPreffix(String preffix, String[] includes) {
		if (ObjectUtils.isAllThruthy(preffix, includes))
			return Arrays.stream(includes).filter(include -> include.indexOf(preffix) == 0)
					.map(include -> include.replaceFirst(preffix + "\\.", ""))
					.filter(include -> include.indexOf(preffix) != 0).filter(include -> ObjectUtils.isThruthy(include))
					.collect(Collectors.toList()).toArray(new String[] {});
		return null;
	}

	public static <T extends CommonModelDto, K extends CommonModel> K actualFillToBaseModel(T source, K target,
			String[] includes) {
		if (ObjectUtils.isAllFalsey(source, target)) {
			throw new Error("The source and target should not be null");
		}
		ObjectUtils.copyPropertiesIgnoringNulls(source, target);
		if (ObjectUtils.isAllThruthy(includes, source))
			mapIncludes(includes, source, target);
		return target;
	}

	public static <T extends CommonModel, K extends CommonModelDto> K actualFillToDtoModel(T source, K target,
			String[] includes) {
		if (ObjectUtils.isAllFalsey(source, target)) {
			throw new Error("The source and target should not be null");
		}
		ObjectUtils.copyPropertiesIgnoringNulls(source, target);
		if (ObjectUtils.isAllThruthy(includes, source))
			mapIncludes(includes, source, target);
		return target;
	}
}
