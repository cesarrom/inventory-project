# InventoryManagementSystem.ProductRepositoryControllerApi

All URIs are relative to *https://localhost:9091*

Method | HTTP request | Description
------------- | ------------- | -------------
[**createProductRepositoryUsingPOST**](ProductRepositoryControllerApi.md#createProductRepositoryUsingPOST) | **POST** /product-repositories/ | createProductRepository
[**findProductRepositoryUsingGET**](ProductRepositoryControllerApi.md#findProductRepositoryUsingGET) | **GET** /product-repositories/{id} | findProductRepository
[**listProductRepositoriesUsingGET**](ProductRepositoryControllerApi.md#listProductRepositoriesUsingGET) | **GET** /product-repositories/ | listProductRepositories
[**updateProductRepositoryUsingPUT**](ProductRepositoryControllerApi.md#updateProductRepositoryUsingPUT) | **PUT** /product-repositories/{id} | updateProductRepository


<a name="createProductRepositoryUsingPOST"></a>
# **createProductRepositoryUsingPOST**
> ResponseCanonicalProductRepositoryDto createProductRepositoryUsingPOST(entityParam)

createProductRepository

### Example
```javascript
var InventoryManagementSystem = require('inventory_management_system');

var apiInstance = new InventoryManagementSystem.ProductRepositoryControllerApi();

var entityParam = new InventoryManagementSystem.ProductRepositoryDto(); // ProductRepositoryDto | entityParam


var callback = function(error, data, response) {
  if (error) {
    console.error(error);
  } else {
    console.log('API called successfully. Returned data: ' + data);
  }
};
apiInstance.createProductRepositoryUsingPOST(entityParam, callback);
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **entityParam** | [**ProductRepositoryDto**](ProductRepositoryDto.md)| entityParam | 

### Return type

[**ResponseCanonicalProductRepositoryDto**](ResponseCanonicalProductRepositoryDto.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: */*

<a name="findProductRepositoryUsingGET"></a>
# **findProductRepositoryUsingGET**
> ResponseCanonicalProductRepositoryDto findProductRepositoryUsingGET(id)

findProductRepository

### Example
```javascript
var InventoryManagementSystem = require('inventory_management_system');

var apiInstance = new InventoryManagementSystem.ProductRepositoryControllerApi();

var id = 789; // Number | id


var callback = function(error, data, response) {
  if (error) {
    console.error(error);
  } else {
    console.log('API called successfully. Returned data: ' + data);
  }
};
apiInstance.findProductRepositoryUsingGET(id, callback);
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **Number**| id | 

### Return type

[**ResponseCanonicalProductRepositoryDto**](ResponseCanonicalProductRepositoryDto.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: */*

<a name="listProductRepositoriesUsingGET"></a>
# **listProductRepositoriesUsingGET**
> ResponseCanonicalListProductRepositoryDto listProductRepositoriesUsingGET(opts)

listProductRepositories

### Example
```javascript
var InventoryManagementSystem = require('inventory_management_system');

var apiInstance = new InventoryManagementSystem.ProductRepositoryControllerApi();

var opts = { 
  'customerIds': [3.4], // [Number] | 
  'supplierIds': [3.4], // [Number] | 
  'sourceSupplierIds': [3.4], // [Number] | 
  'categoryIds': [3.4], // [Number] | 
  'repositoryIds': [3.4], // [Number] | 
  'productIds': [3.4], // [Number] | 
  'skip': 56, // Number | 
  'limit': 56, // Number | 
  'from': new Date("2013-10-20T19:20:30+01:00"), // Date | 
  'to': new Date("2013-10-20T19:20:30+01:00") // Date | 
};

var callback = function(error, data, response) {
  if (error) {
    console.error(error);
  } else {
    console.log('API called successfully. Returned data: ' + data);
  }
};
apiInstance.listProductRepositoriesUsingGET(opts, callback);
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **customerIds** | [**[Number]**](Number.md)|  | [optional] 
 **supplierIds** | [**[Number]**](Number.md)|  | [optional] 
 **sourceSupplierIds** | [**[Number]**](Number.md)|  | [optional] 
 **categoryIds** | [**[Number]**](Number.md)|  | [optional] 
 **repositoryIds** | [**[Number]**](Number.md)|  | [optional] 
 **productIds** | [**[Number]**](Number.md)|  | [optional] 
 **skip** | **Number**|  | [optional] 
 **limit** | **Number**|  | [optional] 
 **from** | **Date**|  | [optional] 
 **to** | **Date**|  | [optional] 

### Return type

[**ResponseCanonicalListProductRepositoryDto**](ResponseCanonicalListProductRepositoryDto.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: */*

<a name="updateProductRepositoryUsingPUT"></a>
# **updateProductRepositoryUsingPUT**
> ResponseCanonicalProductRepositoryDto updateProductRepositoryUsingPUT(id, entityParam)

updateProductRepository

### Example
```javascript
var InventoryManagementSystem = require('inventory_management_system');

var apiInstance = new InventoryManagementSystem.ProductRepositoryControllerApi();

var id = 789; // Number | id

var entityParam = new InventoryManagementSystem.ProductRepositoryDto(); // ProductRepositoryDto | entityParam


var callback = function(error, data, response) {
  if (error) {
    console.error(error);
  } else {
    console.log('API called successfully. Returned data: ' + data);
  }
};
apiInstance.updateProductRepositoryUsingPUT(id, entityParam, callback);
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **Number**| id | 
 **entityParam** | [**ProductRepositoryDto**](ProductRepositoryDto.md)| entityParam | 

### Return type

[**ResponseCanonicalProductRepositoryDto**](ResponseCanonicalProductRepositoryDto.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: */*

