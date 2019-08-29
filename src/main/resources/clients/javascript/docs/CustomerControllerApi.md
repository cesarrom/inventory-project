# InventoryManagementSystem.CustomerControllerApi

All URIs are relative to *https://localhost:9091*

Method | HTTP request | Description
------------- | ------------- | -------------
[**createCustomerUsingPOST**](CustomerControllerApi.md#createCustomerUsingPOST) | **POST** /customers/ | createCustomer
[**findCustomerUsingGET**](CustomerControllerApi.md#findCustomerUsingGET) | **GET** /customers/{id} | findCustomer
[**listCustomersUsingGET**](CustomerControllerApi.md#listCustomersUsingGET) | **GET** /customers/ | listCustomers
[**updateCustomerUsingPUT**](CustomerControllerApi.md#updateCustomerUsingPUT) | **PUT** /customers/{id} | updateCustomer


<a name="createCustomerUsingPOST"></a>
# **createCustomerUsingPOST**
> ResponseCanonicalCustomerDto createCustomerUsingPOST(entityParam)

createCustomer

### Example
```javascript
var InventoryManagementSystem = require('inventory_management_system');

var apiInstance = new InventoryManagementSystem.CustomerControllerApi();

var entityParam = new InventoryManagementSystem.CustomerDto(); // CustomerDto | entityParam


var callback = function(error, data, response) {
  if (error) {
    console.error(error);
  } else {
    console.log('API called successfully. Returned data: ' + data);
  }
};
apiInstance.createCustomerUsingPOST(entityParam, callback);
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **entityParam** | [**CustomerDto**](CustomerDto.md)| entityParam | 

### Return type

[**ResponseCanonicalCustomerDto**](ResponseCanonicalCustomerDto.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: */*

<a name="findCustomerUsingGET"></a>
# **findCustomerUsingGET**
> ResponseCanonicalCustomerDto findCustomerUsingGET(id)

findCustomer

### Example
```javascript
var InventoryManagementSystem = require('inventory_management_system');

var apiInstance = new InventoryManagementSystem.CustomerControllerApi();

var id = 789; // Number | id


var callback = function(error, data, response) {
  if (error) {
    console.error(error);
  } else {
    console.log('API called successfully. Returned data: ' + data);
  }
};
apiInstance.findCustomerUsingGET(id, callback);
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **Number**| id | 

### Return type

[**ResponseCanonicalCustomerDto**](ResponseCanonicalCustomerDto.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: */*

<a name="listCustomersUsingGET"></a>
# **listCustomersUsingGET**
> ResponseCanonicalListCustomerDto listCustomersUsingGET(opts)

listCustomers

### Example
```javascript
var InventoryManagementSystem = require('inventory_management_system');

var apiInstance = new InventoryManagementSystem.CustomerControllerApi();

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
apiInstance.listCustomersUsingGET(opts, callback);
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

[**ResponseCanonicalListCustomerDto**](ResponseCanonicalListCustomerDto.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: */*

<a name="updateCustomerUsingPUT"></a>
# **updateCustomerUsingPUT**
> ResponseCanonicalCustomerDto updateCustomerUsingPUT(id, entityParam)

updateCustomer

### Example
```javascript
var InventoryManagementSystem = require('inventory_management_system');

var apiInstance = new InventoryManagementSystem.CustomerControllerApi();

var id = 789; // Number | id

var entityParam = new InventoryManagementSystem.CustomerDto(); // CustomerDto | entityParam


var callback = function(error, data, response) {
  if (error) {
    console.error(error);
  } else {
    console.log('API called successfully. Returned data: ' + data);
  }
};
apiInstance.updateCustomerUsingPUT(id, entityParam, callback);
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **Number**| id | 
 **entityParam** | [**CustomerDto**](CustomerDto.md)| entityParam | 

### Return type

[**ResponseCanonicalCustomerDto**](ResponseCanonicalCustomerDto.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: */*

