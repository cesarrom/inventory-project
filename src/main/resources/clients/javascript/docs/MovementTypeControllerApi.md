# InventoryManagementSystem.MovementTypeControllerApi

All URIs are relative to *https://localhost:9091*

Method | HTTP request | Description
------------- | ------------- | -------------
[**createMovementTypeUsingPOST**](MovementTypeControllerApi.md#createMovementTypeUsingPOST) | **POST** /movement-types/ | createMovementType
[**findMovementTypeUsingGET**](MovementTypeControllerApi.md#findMovementTypeUsingGET) | **GET** /movement-types/{id} | findMovementType
[**listMovementTypesUsingGET**](MovementTypeControllerApi.md#listMovementTypesUsingGET) | **GET** /movement-types/ | listMovementTypes
[**updateMovementTypeUsingPUT**](MovementTypeControllerApi.md#updateMovementTypeUsingPUT) | **PUT** /movement-types/{id} | updateMovementType


<a name="createMovementTypeUsingPOST"></a>
# **createMovementTypeUsingPOST**
> ResponseCanonicalMovementTypeDto createMovementTypeUsingPOST(entityParam)

createMovementType

### Example
```javascript
var InventoryManagementSystem = require('inventory_management_system');

var apiInstance = new InventoryManagementSystem.MovementTypeControllerApi();

var entityParam = new InventoryManagementSystem.MovementTypeDto(); // MovementTypeDto | entityParam


var callback = function(error, data, response) {
  if (error) {
    console.error(error);
  } else {
    console.log('API called successfully. Returned data: ' + data);
  }
};
apiInstance.createMovementTypeUsingPOST(entityParam, callback);
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **entityParam** | [**MovementTypeDto**](MovementTypeDto.md)| entityParam | 

### Return type

[**ResponseCanonicalMovementTypeDto**](ResponseCanonicalMovementTypeDto.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: */*

<a name="findMovementTypeUsingGET"></a>
# **findMovementTypeUsingGET**
> ResponseCanonicalMovementTypeDto findMovementTypeUsingGET(id)

findMovementType

### Example
```javascript
var InventoryManagementSystem = require('inventory_management_system');

var apiInstance = new InventoryManagementSystem.MovementTypeControllerApi();

var id = 789; // Number | id


var callback = function(error, data, response) {
  if (error) {
    console.error(error);
  } else {
    console.log('API called successfully. Returned data: ' + data);
  }
};
apiInstance.findMovementTypeUsingGET(id, callback);
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **Number**| id | 

### Return type

[**ResponseCanonicalMovementTypeDto**](ResponseCanonicalMovementTypeDto.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: */*

<a name="listMovementTypesUsingGET"></a>
# **listMovementTypesUsingGET**
> ResponseCanonicalListMovementTypeDto listMovementTypesUsingGET(opts)

listMovementTypes

### Example
```javascript
var InventoryManagementSystem = require('inventory_management_system');

var apiInstance = new InventoryManagementSystem.MovementTypeControllerApi();

var opts = { 
  'skip': 56, // Number | 
  'limit': 56, // Number | 
  'from': new Date("2013-10-20T19:20:30+01:00"), // Date | 
  'to': new Date("2013-10-20T19:20:30+01:00"), // Date | 
  'name': "name_example", // String | 
  'description': "description_example", // String | 
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
apiInstance.listMovementTypesUsingGET(opts, callback);
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
 **sourceRepositoryId** | **Number**|  | [optional] 
 **targetRepositoryId** | **Number**|  | [optional] 

### Return type

[**ResponseCanonicalListMovementTypeDto**](ResponseCanonicalListMovementTypeDto.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: */*

<a name="updateMovementTypeUsingPUT"></a>
# **updateMovementTypeUsingPUT**
> ResponseCanonicalMovementTypeDto updateMovementTypeUsingPUT(id, entityParam)

updateMovementType

### Example
```javascript
var InventoryManagementSystem = require('inventory_management_system');

var apiInstance = new InventoryManagementSystem.MovementTypeControllerApi();

var id = 789; // Number | id

var entityParam = new InventoryManagementSystem.MovementTypeDto(); // MovementTypeDto | entityParam


var callback = function(error, data, response) {
  if (error) {
    console.error(error);
  } else {
    console.log('API called successfully. Returned data: ' + data);
  }
};
apiInstance.updateMovementTypeUsingPUT(id, entityParam, callback);
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **Number**| id | 
 **entityParam** | [**MovementTypeDto**](MovementTypeDto.md)| entityParam | 

### Return type

[**ResponseCanonicalMovementTypeDto**](ResponseCanonicalMovementTypeDto.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: */*

