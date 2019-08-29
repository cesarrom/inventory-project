# InventoryManagementSystem.RepositoryControllerApi

All URIs are relative to *https://localhost:9091*

Method | HTTP request | Description
------------- | ------------- | -------------
[**createRepositoryUsingPOST**](RepositoryControllerApi.md#createRepositoryUsingPOST) | **POST** /repositories/ | createRepository
[**findRepositoryUsingGET**](RepositoryControllerApi.md#findRepositoryUsingGET) | **GET** /repositories/{id} | findRepository
[**listRepositoriesUsingGET**](RepositoryControllerApi.md#listRepositoriesUsingGET) | **GET** /repositories/ | listRepositories
[**updateRepositoryUsingPUT**](RepositoryControllerApi.md#updateRepositoryUsingPUT) | **PUT** /repositories/{id} | updateRepository


<a name="createRepositoryUsingPOST"></a>
# **createRepositoryUsingPOST**
> ResponseCanonicalRepositoryDto createRepositoryUsingPOST(entityParam)

createRepository

### Example
```javascript
var InventoryManagementSystem = require('inventory_management_system');

var apiInstance = new InventoryManagementSystem.RepositoryControllerApi();

var entityParam = new InventoryManagementSystem.RepositoryDto(); // RepositoryDto | entityParam


var callback = function(error, data, response) {
  if (error) {
    console.error(error);
  } else {
    console.log('API called successfully. Returned data: ' + data);
  }
};
apiInstance.createRepositoryUsingPOST(entityParam, callback);
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **entityParam** | [**RepositoryDto**](RepositoryDto.md)| entityParam | 

### Return type

[**ResponseCanonicalRepositoryDto**](ResponseCanonicalRepositoryDto.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: */*

<a name="findRepositoryUsingGET"></a>
# **findRepositoryUsingGET**
> ResponseCanonicalRepositoryDto findRepositoryUsingGET(id)

findRepository

### Example
```javascript
var InventoryManagementSystem = require('inventory_management_system');

var apiInstance = new InventoryManagementSystem.RepositoryControllerApi();

var id = 789; // Number | id


var callback = function(error, data, response) {
  if (error) {
    console.error(error);
  } else {
    console.log('API called successfully. Returned data: ' + data);
  }
};
apiInstance.findRepositoryUsingGET(id, callback);
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **Number**| id | 

### Return type

[**ResponseCanonicalRepositoryDto**](ResponseCanonicalRepositoryDto.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: */*

<a name="listRepositoriesUsingGET"></a>
# **listRepositoriesUsingGET**
> ResponseCanonicalListRepositoryDto listRepositoriesUsingGET(opts)

listRepositories

### Example
```javascript
var InventoryManagementSystem = require('inventory_management_system');

var apiInstance = new InventoryManagementSystem.RepositoryControllerApi();

var opts = { 
  'customerIds': [3.4], // [Number] | 
  'supplierIds': [3.4], // [Number] | 
  'categoryIds': [3.4], // [Number] | 
  'productIds': [3.4], // [Number] | 
  'skip': 56, // Number | 
  'limit': 56, // Number | 
  'from': new Date("2013-10-20T19:20:30+01:00"), // Date | 
  'to': new Date("2013-10-20T19:20:30+01:00"), // Date | 
  'name': "name_example", // String | 
  'description': "description_example" // String | 
};

var callback = function(error, data, response) {
  if (error) {
    console.error(error);
  } else {
    console.log('API called successfully. Returned data: ' + data);
  }
};
apiInstance.listRepositoriesUsingGET(opts, callback);
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **customerIds** | [**[Number]**](Number.md)|  | [optional] 
 **supplierIds** | [**[Number]**](Number.md)|  | [optional] 
 **categoryIds** | [**[Number]**](Number.md)|  | [optional] 
 **productIds** | [**[Number]**](Number.md)|  | [optional] 
 **skip** | **Number**|  | [optional] 
 **limit** | **Number**|  | [optional] 
 **from** | **Date**|  | [optional] 
 **to** | **Date**|  | [optional] 
 **name** | **String**|  | [optional] 
 **description** | **String**|  | [optional] 

### Return type

[**ResponseCanonicalListRepositoryDto**](ResponseCanonicalListRepositoryDto.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: */*

<a name="updateRepositoryUsingPUT"></a>
# **updateRepositoryUsingPUT**
> ResponseCanonicalRepositoryDto updateRepositoryUsingPUT(id, entityParam)

updateRepository

### Example
```javascript
var InventoryManagementSystem = require('inventory_management_system');

var apiInstance = new InventoryManagementSystem.RepositoryControllerApi();

var id = 789; // Number | id

var entityParam = new InventoryManagementSystem.RepositoryDto(); // RepositoryDto | entityParam


var callback = function(error, data, response) {
  if (error) {
    console.error(error);
  } else {
    console.log('API called successfully. Returned data: ' + data);
  }
};
apiInstance.updateRepositoryUsingPUT(id, entityParam, callback);
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **Number**| id | 
 **entityParam** | [**RepositoryDto**](RepositoryDto.md)| entityParam | 

### Return type

[**ResponseCanonicalRepositoryDto**](ResponseCanonicalRepositoryDto.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: */*

