# InventoryManagementSystem.RootControllerApi

All URIs are relative to *https://localhost:9091*

Method | HTTP request | Description
------------- | ------------- | -------------
[**heartBeatUsingGET**](RootControllerApi.md#heartBeatUsingGET) | **GET** / | heartBeat


<a name="heartBeatUsingGET"></a>
# **heartBeatUsingGET**
> ResponseCanonicalstring heartBeatUsingGET()

heartBeat

### Example
```javascript
var InventoryManagementSystem = require('inventory_management_system');

var apiInstance = new InventoryManagementSystem.RootControllerApi();

var callback = function(error, data, response) {
  if (error) {
    console.error(error);
  } else {
    console.log('API called successfully. Returned data: ' + data);
  }
};
apiInstance.heartBeatUsingGET(callback);
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**ResponseCanonicalstring**](ResponseCanonicalstring.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

