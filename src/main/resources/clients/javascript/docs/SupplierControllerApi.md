# InventoryManagementSystem.SupplierControllerApi

All URIs are relative to *https://localhost:9091*

Method | HTTP request | Description
------------- | ------------- | -------------
[**createSupplierUsingPOST**](SupplierControllerApi.md#createSupplierUsingPOST) | **POST** /suppliers/ | createSupplier
[**findSupplierUsingGET**](SupplierControllerApi.md#findSupplierUsingGET) | **GET** /suppliers/{id} | findSupplier
[**listSuppliersUsingGET**](SupplierControllerApi.md#listSuppliersUsingGET) | **GET** /suppliers/ | listSuppliers
[**updateSupplierUsingPUT**](SupplierControllerApi.md#updateSupplierUsingPUT) | **PUT** /suppliers/{id} | updateSupplier


<a name="createSupplierUsingPOST"></a>
# **createSupplierUsingPOST**
> ResponseCanonicalSupplierDto createSupplierUsingPOST(entityParam)

createSupplier

### Example
```javascript
var InventoryManagementSystem = require('inventory_management_system');

var apiInstance = new InventoryManagementSystem.SupplierControllerApi();

var entityParam = new InventoryManagementSystem.SupplierDto(); // SupplierDto | entityParam


var callback = function(error, data, response) {
  if (error) {
    console.error(error);
  } else {
    console.log('API called successfully. Returned data: ' + data);
  }
};
apiInstance.createSupplierUsingPOST(entityParam, callback);
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **entityParam** | [**SupplierDto**](SupplierDto.md)| entityParam | 

### Return type

[**ResponseCanonicalSupplierDto**](ResponseCanonicalSupplierDto.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: */*

<a name="findSupplierUsingGET"></a>
# **findSupplierUsingGET**
> ResponseCanonicalSupplierDto findSupplierUsingGET(id)

findSupplier

### Example
```javascript
var InventoryManagementSystem = require('inventory_management_system');

var apiInstance = new InventoryManagementSystem.SupplierControllerApi();

var id = 789; // Number | id


var callback = function(error, data, response) {
  if (error) {
    console.error(error);
  } else {
    console.log('API called successfully. Returned data: ' + data);
  }
};
apiInstance.findSupplierUsingGET(id, callback);
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **Number**| id | 

### Return type

[**ResponseCanonicalSupplierDto**](ResponseCanonicalSupplierDto.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: */*

<a name="listSuppliersUsingGET"></a>
# **listSuppliersUsingGET**
> ResponseCanonicalListSupplierDto listSuppliersUsingGET(opts)

listSuppliers

### Example
```javascript
var InventoryManagementSystem = require('inventory_management_system');

var apiInstance = new InventoryManagementSystem.SupplierControllerApi();

var opts = { 
  'skip': 56, // Number | 
  'limit': 56, // Number | 
  'from': new Date("2013-10-20T19:20:30+01:00"), // Date | 
  'to': new Date("2013-10-20T19:20:30+01:00"), // Date | 
  'name': "name_example", // String | 
  'movementId': 789, // Number | 
  'productId': 789 // Number | 
};

var callback = function(error, data, response) {
  if (error) {
    console.error(error);
  } else {
    console.log('API called successfully. Returned data: ' + data);
  }
};
apiInstance.listSuppliersUsingGET(opts, callback);
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **skip** | **Number**|  | [optional] 
 **limit** | **Number**|  | [optional] 
 **from** | **Date**|  | [optional] 
 **to** | **Date**|  | [optional] 
 **name** | **String**|  | [optional] 
 **movementId** | **Number**|  | [optional] 
 **productId** | **Number**|  | [optional] 

### Return type

[**ResponseCanonicalListSupplierDto**](ResponseCanonicalListSupplierDto.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: */*

<a name="updateSupplierUsingPUT"></a>
# **updateSupplierUsingPUT**
> ResponseCanonicalSupplierDto updateSupplierUsingPUT(id, entityParam)

updateSupplier

### Example
```javascript
var InventoryManagementSystem = require('inventory_management_system');

var apiInstance = new InventoryManagementSystem.SupplierControllerApi();

var id = 789; // Number | id

var entityParam = new InventoryManagementSystem.SupplierDto(); // SupplierDto | entityParam


var callback = function(error, data, response) {
  if (error) {
    console.error(error);
  } else {
    console.log('API called successfully. Returned data: ' + data);
  }
};
apiInstance.updateSupplierUsingPUT(id, entityParam, callback);
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **Number**| id | 
 **entityParam** | [**SupplierDto**](SupplierDto.md)| entityParam | 

### Return type

[**ResponseCanonicalSupplierDto**](ResponseCanonicalSupplierDto.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: */*

