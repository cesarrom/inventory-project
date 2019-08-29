# InventoryManagementSystem.CategoryControllerApi

All URIs are relative to *https://localhost:9091*

Method | HTTP request | Description
------------- | ------------- | -------------
[**createCategoryUsingPOST**](CategoryControllerApi.md#createCategoryUsingPOST) | **POST** /categories/ | createCategory
[**findCategoryUsingGET**](CategoryControllerApi.md#findCategoryUsingGET) | **GET** /categories/{id} | findCategory
[**listCategoriesUsingGET**](CategoryControllerApi.md#listCategoriesUsingGET) | **GET** /categories/ | listCategories
[**updateCategoryUsingPUT**](CategoryControllerApi.md#updateCategoryUsingPUT) | **PUT** /categories/{id} | updateCategory


<a name="createCategoryUsingPOST"></a>
# **createCategoryUsingPOST**
> ResponseCanonicalCategoryDto createCategoryUsingPOST(entityParam)

createCategory

### Example
```javascript
var InventoryManagementSystem = require('inventory_management_system');

var apiInstance = new InventoryManagementSystem.CategoryControllerApi();

var entityParam = new InventoryManagementSystem.CategoryDto(); // CategoryDto | entityParam


var callback = function(error, data, response) {
  if (error) {
    console.error(error);
  } else {
    console.log('API called successfully. Returned data: ' + data);
  }
};
apiInstance.createCategoryUsingPOST(entityParam, callback);
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **entityParam** | [**CategoryDto**](CategoryDto.md)| entityParam | 

### Return type

[**ResponseCanonicalCategoryDto**](ResponseCanonicalCategoryDto.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: */*

<a name="findCategoryUsingGET"></a>
# **findCategoryUsingGET**
> ResponseCanonicalCategoryDto findCategoryUsingGET(id)

findCategory

### Example
```javascript
var InventoryManagementSystem = require('inventory_management_system');

var apiInstance = new InventoryManagementSystem.CategoryControllerApi();

var id = 789; // Number | id


var callback = function(error, data, response) {
  if (error) {
    console.error(error);
  } else {
    console.log('API called successfully. Returned data: ' + data);
  }
};
apiInstance.findCategoryUsingGET(id, callback);
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **Number**| id | 

### Return type

[**ResponseCanonicalCategoryDto**](ResponseCanonicalCategoryDto.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: */*

<a name="listCategoriesUsingGET"></a>
# **listCategoriesUsingGET**
> ResponseCanonicalListCategoryDto listCategoriesUsingGET(opts)

listCategories

### Example
```javascript
var InventoryManagementSystem = require('inventory_management_system');

var apiInstance = new InventoryManagementSystem.CategoryControllerApi();

var opts = { 
  'skip': 56, // Number | 
  'limit': 56, // Number | 
  'from': new Date("2013-10-20T19:20:30+01:00"), // Date | 
  'to': new Date("2013-10-20T19:20:30+01:00"), // Date | 
  'name': "name_example", // String | 
  'description': "description_example", // String | 
  'parentCategoryId': 789 // Number | 
};

var callback = function(error, data, response) {
  if (error) {
    console.error(error);
  } else {
    console.log('API called successfully. Returned data: ' + data);
  }
};
apiInstance.listCategoriesUsingGET(opts, callback);
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **skip** | **Number**|  | [optional] 
 **limit** | **Number**|  | [optional] 
 **from** | **Date**|  | [optional] 
 **to** | **Date**|  | [optional] 
 **name** | **String**|  | [optional] 
 **description** | **String**|  | [optional] 
 **parentCategoryId** | **Number**|  | [optional] 

### Return type

[**ResponseCanonicalListCategoryDto**](ResponseCanonicalListCategoryDto.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: */*

<a name="updateCategoryUsingPUT"></a>
# **updateCategoryUsingPUT**
> ResponseCanonicalCategoryDto updateCategoryUsingPUT(id, entityParam)

updateCategory

### Example
```javascript
var InventoryManagementSystem = require('inventory_management_system');

var apiInstance = new InventoryManagementSystem.CategoryControllerApi();

var id = 789; // Number | id

var entityParam = new InventoryManagementSystem.CategoryDto(); // CategoryDto | entityParam


var callback = function(error, data, response) {
  if (error) {
    console.error(error);
  } else {
    console.log('API called successfully. Returned data: ' + data);
  }
};
apiInstance.updateCategoryUsingPUT(id, entityParam, callback);
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **Number**| id | 
 **entityParam** | [**CategoryDto**](CategoryDto.md)| entityParam | 

### Return type

[**ResponseCanonicalCategoryDto**](ResponseCanonicalCategoryDto.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: */*

