# InventoryManagementSystem.MovementControllerApi

All URIs are relative to *https://localhost:9091*

Method | HTTP request | Description
------------- | ------------- | -------------
[**findMovementUsingGET**](MovementControllerApi.md#findMovementUsingGET) | **GET** /movements/{movementId} | findMovement
[**generateMovementUsingPOST**](MovementControllerApi.md#generateMovementUsingPOST) | **POST** /movements/ | generateMovement
[**listMovementsUsingGET**](MovementControllerApi.md#listMovementsUsingGET) | **GET** /movements/ | listMovements
[**rollbackMovementUsingPUT**](MovementControllerApi.md#rollbackMovementUsingPUT) | **PUT** /movements/{parentMovementId} | rollbackMovement


<a name="findMovementUsingGET"></a>
# **findMovementUsingGET**
> ResponseCanonicalMovementDto findMovementUsingGET(movementId)

findMovement

### Example
```javascript
var InventoryManagementSystem = require('inventory_management_system');

var apiInstance = new InventoryManagementSystem.MovementControllerApi();

var movementId = 789; // Number | movementId


var callback = function(error, data, response) {
  if (error) {
    console.error(error);
  } else {
    console.log('API called successfully. Returned data: ' + data);
  }
};
apiInstance.findMovementUsingGET(movementId, callback);
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **movementId** | **Number**| movementId | 

### Return type

[**ResponseCanonicalMovementDto**](ResponseCanonicalMovementDto.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: */*

<a name="generateMovementUsingPOST"></a>
# **generateMovementUsingPOST**
> ResponseCanonicalMovementDto generateMovementUsingPOST(movementInfo)

generateMovement

### Example
```javascript
var InventoryManagementSystem = require('inventory_management_system');

var apiInstance = new InventoryManagementSystem.MovementControllerApi();

var movementInfo = new InventoryManagementSystem.MovementDto(); // MovementDto | movementInfo


var callback = function(error, data, response) {
  if (error) {
    console.error(error);
  } else {
    console.log('API called successfully. Returned data: ' + data);
  }
};
apiInstance.generateMovementUsingPOST(movementInfo, callback);
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **movementInfo** | [**MovementDto**](MovementDto.md)| movementInfo | 

### Return type

[**ResponseCanonicalMovementDto**](ResponseCanonicalMovementDto.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: */*

<a name="listMovementsUsingGET"></a>
# **listMovementsUsingGET**
> ResponseCanonicalListMovementDto listMovementsUsingGET(opts)

listMovements

### Example
```javascript
var InventoryManagementSystem = require('inventory_management_system');

var apiInstance = new InventoryManagementSystem.MovementControllerApi();

var opts = { 
  'movementDetailIds': [3.4], // [Number] | 
  'productIds': [3.4], // [Number] | 
  'movementTypeIds': [3.4], // [Number] | 
  'skip': 56, // Number | 
  'limit': 56, // Number | 
  'from': new Date("2013-10-20T19:20:30+01:00"), // Date | 
  'to': new Date("2013-10-20T19:20:30+01:00"), // Date | 
  'sourceRepositoryId': 789, // Number | 
  'targetRepositoryId': 789, // Number | 
  'customerId': 789, // Number | 
  'supplierId': 789 // Number | 
};

var callback = function(error, data, response) {
  if (error) {
    console.error(error);
  } else {
    console.log('API called successfully. Returned data: ' + data);
  }
};
apiInstance.listMovementsUsingGET(opts, callback);
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **movementDetailIds** | [**[Number]**](Number.md)|  | [optional] 
 **productIds** | [**[Number]**](Number.md)|  | [optional] 
 **movementTypeIds** | [**[Number]**](Number.md)|  | [optional] 
 **skip** | **Number**|  | [optional] 
 **limit** | **Number**|  | [optional] 
 **from** | **Date**|  | [optional] 
 **to** | **Date**|  | [optional] 
 **sourceRepositoryId** | **Number**|  | [optional] 
 **targetRepositoryId** | **Number**|  | [optional] 
 **customerId** | **Number**|  | [optional] 
 **supplierId** | **Number**|  | [optional] 

### Return type

[**ResponseCanonicalListMovementDto**](ResponseCanonicalListMovementDto.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: */*

<a name="rollbackMovementUsingPUT"></a>
# **rollbackMovementUsingPUT**
> ResponseCanonicalMovementDto rollbackMovementUsingPUT(parentMovementId, headerInfo)

rollbackMovement

### Example
```javascript
var InventoryManagementSystem = require('inventory_management_system');

var apiInstance = new InventoryManagementSystem.MovementControllerApi();

var parentMovementId = 789; // Number | parentMovementId

var headerInfo = new InventoryManagementSystem.MovementDto(); // MovementDto | headerInfo


var callback = function(error, data, response) {
  if (error) {
    console.error(error);
  } else {
    console.log('API called successfully. Returned data: ' + data);
  }
};
apiInstance.rollbackMovementUsingPUT(parentMovementId, headerInfo, callback);
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **parentMovementId** | **Number**| parentMovementId | 
 **headerInfo** | [**MovementDto**](MovementDto.md)| headerInfo | 

### Return type

[**ResponseCanonicalMovementDto**](ResponseCanonicalMovementDto.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: */*

