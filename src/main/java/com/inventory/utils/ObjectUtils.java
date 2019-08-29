package com.inventory.utils;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.util.ClassUtils;
import org.springframework.util.ReflectionUtils;

public class ObjectUtils extends org.springframework.util.ObjectUtils {

	@SuppressWarnings("rawtypes")
	public static Boolean isThruthy(Object object) {
		Boolean response = true;
		if (object != null) {
			if (object instanceof Collection) {
				Collection collection = (Collection) object;
				response &= !collection.isEmpty();
			} else if (object instanceof Map) {
				Map map = (Map) object;
				response &= !map.isEmpty();
			} else if (object instanceof String) {
				String string = (String) object;
				response &= !string.isEmpty();
			} else if (object instanceof Boolean) {
				response = (Boolean) object;
			} else if (object instanceof Number) {
				response &= Double.parseDouble(object.toString()) != 0;
			} else if (object instanceof Iterable) {
				response &= ((Iterable) object).iterator().hasNext();
			}
		} else {
			response = false;
		}

		return response;
	}

	public static Boolean isAllThruthy(Object... args) {
		Boolean response = true;
		response &= ObjectUtils.isThruthy(args);
		for (Object arg : args) {
			response &= ObjectUtils.isThruthy(arg);
		}
		return response;
	}

	public static Boolean isAllFalsey(Object... args) {
		return !ObjectUtils.isAllThruthy(args);
	}

	public static Boolean isFalsey(Object object) {
		return !ObjectUtils.isThruthy(object);
	}

	public static Field getFieldByName(Class<?> clazz, String key) {
		return ReflectionUtils.findField(clazz, key);
	}

	public static Method getMethodByName(Class<?> clazz, String methodName) {
		return ReflectionUtils.findMethod(clazz, methodName);
	}

	public static String[] getNullPropertyNames(Object source, Boolean allowNotPrimitivesToBeCopied) {
		final BeanWrapper src = new BeanWrapperImpl(source);
		java.beans.PropertyDescriptor[] pds = src.getPropertyDescriptors();
		List<String> emptyNames = new ArrayList<>();
		for (java.beans.PropertyDescriptor pd : pds) {
			Object srcValue = src.getPropertyValue(pd.getName());
			if (srcValue == null)
				emptyNames.add(pd.getName());
			if (!allowNotPrimitivesToBeCopied && !ClassUtils.isPrimitiveOrWrapper(pd.getPropertyType())
					&& !String.class.isAssignableFrom(pd.getPropertyType())
					&& !Date.class.isAssignableFrom(pd.getPropertyType()))
				emptyNames.add(pd.getName());
		}
		String[] result = new String[emptyNames.size()];
		return emptyNames.toArray(result);
	}

	// then use Spring BeanUtils to copy and ignore null
	public static void copyPropertiesIgnoringNulls(Object src, Object target) {
		copyPropertiesIgnoringNulls(src, target, false);
	}

	public static void copyPropertiesIgnoringNulls(Object src, Object target, Boolean notJustPrimitives) {
		BeanUtils.copyProperties(src, target, getNullPropertyNames(src, notJustPrimitives));
	}

	public static Object getValueBykey(Object object, String key) {
		final BeanWrapper src = new BeanWrapperImpl(object);
		return src.getPropertyValue(key);
	}

	@SuppressWarnings("unchecked")
	public static <T> T createNewInstanceForType(T clazzInstance) {
		return (T) createNewInstanceForType(clazzInstance.getClass());
	}

	public static <T> T createNewInstanceForType(Class<T> clazz) {
		try {
			return clazz.newInstance();
		} catch (InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
			return null;
		}
	}

	public static Object createNewInstanceForGenericCollectionType(Field desiredFieldType) {
		try {
			return getWrappedGenericType(desiredFieldType).newInstance();
		} catch (InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
			return null;
		}
	}

	public static Object createNewInstanceForGenericCollectionType(Method desiredFieldType) {
		try {
			return getWrappedGenericType(desiredFieldType).newInstance();
		} catch (InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
			return null;
		}
	}

	public static Class<?> getWrappedGenericType(Field desiredFieldType) {
		ParameterizedType stringListType = (ParameterizedType) desiredFieldType.getGenericType();
		Class<?> actualClazz = (Class<?>) stringListType.getActualTypeArguments()[0];
		return actualClazz;
	}

	public static Class<?> getWrappedGenericType(Method desiredFieldType) {
		ParameterizedType stringListType = (ParameterizedType) desiredFieldType.getGenericReturnType();
		Class<?> actualClazz = (Class<?>) stringListType.getActualTypeArguments()[0];
		return actualClazz;

	}

	public static void setValueByKey(Object object, String key, Object value) {
		final BeanWrapper src = new BeanWrapperImpl(object);
		if (value != null && src.getPropertyType(key).isAssignableFrom(value.getClass()))
			src.setPropertyValue(key, value);
		else if (value == null)
			src.setPropertyValue(key, value);
		return;
	}

	public static Class<?> getFieldClass(Class<?> baseClass, String fieldName) {
		return ReflectionUtils.findField(baseClass, fieldName).getType();
	}

}
