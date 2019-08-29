# InventoryManagementSystem.ProductControllerApi

All URIs are relative to *https://localhost:9091*

Method | HTTP request | Description
------------- | ------------- | -------------
[**createProductUsingPOST**](ProductControllerApi.md#createProductUsingPOST) | **POST** /products/ | createProduct
[**findProductUsingGET**](ProductControllerApi.md#findProductUsingGET) | **GET** /products/{id} | findProduct
[**listProductsUsingGET**](ProductControllerApi.md#listProductsUsingGET) | **GET** /products/ | listProducts
[**updateProductUsingPUT**](ProductControllerApi.md#updateProductUsingPUT) | **PUT** /products/{id} | updateProduct


<a name="createProductUsingPOST"></a>
# **createProductUsingPOST**
> ResponseCanonicalProductDto createProductUsingPOST(entityParam)

createProduct

### Example
```javascript
var InventoryManagementSystem = require('inventory_management_system');

var apiInstance = new InventoryManagementSystem.ProductControllerApi();

var entityParam = new InventoryManagementSystem.ProductDto(); // ProductDto | entityParam


var callback = function(error, data, response) {
  if (error) {
    console.error(error);
  } else {
    console.log('API called successfully. Returned data: ' + data);
  }
};
apiInstance.createProductUsingPOST(entityParam, callback);
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **entityParam** | [**ProductDto**](ProductDto.md)| entityParam | 

### Return type

[**ResponseCanonicalProductDto**](ResponseCanonicalProductDto.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: */*

<a name="findProductUsingGET"></a>
# **findProductUsingGET**
> ResponseCanonicalProductDto findProductUsingGET(id)

findProduct

### Example
```javascript
var InventoryManagementSystem = require('inventory_management_system');

var apiInstance = new InventoryManagementSystem.ProductControllerApi();

var id = 789; // Number | id


var callback = function(error, data, response) {
  if (error) {
    console.error(error);
  } else {
    console.log('API called successfully. Returned data: ' + data);
  }
};
apiInstance.findProductUsingGET(id, callback);
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **Number**| id | 

### Return type

[**ResponseCanonicalProductDto**](ResponseCanonicalProductDto.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: */*

<a name="listProductsUsingGET"></a>
# **listProductsUsingGET**
> ResponseCanonicalListProductDto listProductsUsingGET(opts)

listProducts

### Example
```javascript
var InventoryManagementSystem = require('inventory_management_system');

var apiInstance = new InventoryManagementSystem.ProductControllerApi();

var opts = { 
  'sourceSupplierIds': [3.4], // [Number] | 
  'customerIds': [3.4], // [Number] | 
  'supplierIds': [3.4], // [Number] | 
  'categoryIds': [3.4], // [Number] | 
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
apiInstance.listProductsUsingGET(opts, callback);
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **sourceSupplierIds** | [**[Number]**](Number.md)|  | [optional] 
 **customerIds** | [**[Number]**](Number.md)|  | [optional] 
 **supplierIds** | [**[Number]**](Number.md)|  | [optional] 
 **categoryIds** | [**[Number]**](Number.md)|  | [optional] 
 **skip** | **Number**|  | [optional] 
 **limit** | **Number**|  | [optional] 
 **from** | **Date**|  | [optional] 
 **to** | **Date**|  | [optional] 
 **name** | **String**|  | [optional] 
 **description** | **String**|  | [optional] 

### Return type

[**ResponseCanonicalListProductDto**](ResponseCanonicalListProductDto.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: */*

<a name="updateProductUsingPUT"></a>
# **updateProductUsingPUT**
> ResponseCanonicalProductDto updateProductUsingPUT(id, entityParam)

updateProduct

### Example
```javascript
var InventoryManagementSystem = require('inventory_management_system');

var apiInstance = new InventoryManagementSystem.ProductControllerApi();

var id = 789; // Number | id

var entityParam = new InventoryManagementSystem.ProductDto(); // ProductDto | entityParam


var callback = function(error, data, response) {
  if (error) {
    console.error(error);
  } else {
    console.log('API called successfully. Returned data: ' + data);
  }
};
apiInstance.updateProductUsingPUT(id, entityParam, callback);
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **Number**| id | 
 **entityParam** | [**ProductDto**](ProductDto.md)| entityParam | 

### Return type

[**ResponseCanonicalProductDto**](ResponseCanonicalProductDto.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: */*

