# InventoryManagementSystem.MovementDetailControllerApi

All URIs are relative to *https://localhost:9091*

Method | HTTP request | Description
------------- | ------------- | -------------
[**createMovementDetailUsingPOST**](MovementDetailControllerApi.md#createMovementDetailUsingPOST) | **POST** /movement-details/ | createMovementDetail
[**findMovementDetailUsingGET**](MovementDetailControllerApi.md#findMovementDetailUsingGET) | **GET** /movement-details/{id} | findMovementDetail
[**listMovementDetailsUsingGET**](MovementDetailControllerApi.md#listMovementDetailsUsingGET) | **GET** /movement-details/ | listMovementDetails
[**updateMovementDetailUsingPUT**](MovementDetailControllerApi.md#updateMovementDetailUsingPUT) | **PUT** /movement-details/{id} | updateMovementDetail


<a name="createMovementDetailUsingPOST"></a>
# **createMovementDetailUsingPOST**
> ResponseCanonicalMovementDetailDto createMovementDetailUsingPOST(entityParam)

createMovementDetail

### Example
```javascript
var InventoryManagementSystem = require('inventory_management_system');

var apiInstance = new InventoryManagementSystem.MovementDetailControllerApi();

var entityParam = new InventoryManagementSystem.MovementDetailDto(); // MovementDetailDto | entityParam


var callback = function(error, data, response) {
  if (error) {
    console.error(error);
  } else {
    console.log('API called successfully. Returned data: ' + data);
  }
};
apiInstance.createMovementDetailUsingPOST(entityParam, callback);
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **entityParam** | [**MovementDetailDto**](MovementDetailDto.md)| entityParam | 

### Return type

[**ResponseCanonicalMovementDetailDto**](ResponseCanonicalMovementDetailDto.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: */*

<a name="findMovementDetailUsingGET"></a>
# **findMovementDetailUsingGET**
> ResponseCanonicalMovementDetailDto findMovementDetailUsingGET(id)

findMovementDetail

### Example
```javascript
var InventoryManagementSystem = require('inventory_management_system');

var apiInstance = new InventoryManagementSystem.MovementDetailControllerApi();

var id = 789; // Number | id


var callback = function(error, data, response) {
  if (error) {
    console.error(error);
  } else {
    console.log('API called successfully. Returned data: ' + data);
  }
};
apiInstance.findMovementDetailUsingGET(id, callback);
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **Number**| id | 

### Return type

[**ResponseCanonicalMovementDetailDto**](ResponseCanonicalMovementDetailDto.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: */*

<a name="listMovementDetailsUsingGET"></a>
# **listMovementDetailsUsingGET**
> ResponseCanonicalListMovementDetailDto listMovementDetailsUsingGET(opts)

listMovementDetails

### Example
```javascript
var InventoryManagementSystem = require('inventory_management_system');

var apiInstance = new InventoryManagementSystem.MovementDetailControllerApi();

var opts = { 
  'productIds': [3.4], // [Number] | 
  'skip': 56, // Number | 
  'limit': 56, // Number | 
  'from': new Date("2013-10-20T19:20:30+01:00"), // Date | 
  'to': new Date("2013-10-20T19:20:30+01:00"), // Date | 
  'movementId': 789, // Number | 
  'omitPositive': true, // Boolean | 
  'omitNegative': true, // Boolean | 
  'sourceRepositoryId': 789, // Number | 
  'targetRepositoryId': 789 // Number | 
};

var callback = function(error, data, response) {
  if (error) {
    console.error(error);
  } else {
    console.log('API called successfully. Returned data: ' + data);
  }
};
apiInstance.listMovementDetailsUsingGET(opts, callback);
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **productIds** | [**[Number]**](Number.md)|  | [optional] 
 **skip** | **Number**|  | [optional] 
 **limit** | **Number**|  | [optional] 
 **from** | **Date**|  | [optional] 
 **to** | **Date**|  | [optional] 
 **movementId** | **Number**|  | [optional] 
 **omitPositive** | **Boolean**|  | [optional] 
 **omitNegative** | **Boolean**|  | [optional] 
 **sourceRepositoryId** | **Number**|  | [optional] 
 **targetRepositoryId** | **Number**|  | [optional] 

### Return type

[**ResponseCanonicalListMovementDetailDto**](ResponseCanonicalListMovementDetailDto.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: */*

<a name="updateMovementDetailUsingPUT"></a>
# **updateMovementDetailUsingPUT**
> ResponseCanonicalMovementDetailDto updateMovementDetailUsingPUT(id, entityParam)

updateMovementDetail

### Example
```javascript
var InventoryManagementSystem = require('inventory_management_system');

var apiInstance = new InventoryManagementSystem.MovementDetailControllerApi();

var id = 789; // Number | id

var entityParam = new InventoryManagementSystem.MovementDetailDto(); // MovementDetailDto | entityParam


var callback = function(error, data, response) {
  if (error) {
    console.error(error);
  } else {
    console.log('API called successfully. Returned data: ' + data);
  }
};
apiInstance.updateMovementDetailUsingPUT(id, entityParam, callback);
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **Number**| id | 
 **entityParam** | [**MovementDetailDto**](MovementDetailDto.md)| entityParam | 

### Return type

[**ResponseCanonicalMovementDetailDto**](ResponseCanonicalMovementDetailDto.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: */*

