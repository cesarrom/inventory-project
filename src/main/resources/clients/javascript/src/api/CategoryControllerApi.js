/**
 * Inventory Management System
 * No description provided (generated by Swagger Codegen https://github.com/swagger-api/swagger-codegen)
 *
 * OpenAPI spec version: 2.0
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 *
 * Swagger Codegen version: 2.4.7
 *
 * Do not edit the class manually.
 *
 */

(function(root, factory) {
  if (typeof define === 'function' && define.amd) {
    // AMD. Register as an anonymous module.
    define(['ApiClient', 'model/CategoryDto', 'model/ResponseCanonicalCategoryDto', 'model/ResponseCanonicalListCategoryDto'], factory);
  } else if (typeof module === 'object' && module.exports) {
    // CommonJS-like environments that support module.exports, like Node.
    module.exports = factory(require('../ApiClient'), require('../model/CategoryDto'), require('../model/ResponseCanonicalCategoryDto'), require('../model/ResponseCanonicalListCategoryDto'));
  } else {
    // Browser globals (root is window)
    if (!root.InventoryManagementSystem) {
      root.InventoryManagementSystem = {};
    }
    root.InventoryManagementSystem.CategoryControllerApi = factory(root.InventoryManagementSystem.ApiClient, root.InventoryManagementSystem.CategoryDto, root.InventoryManagementSystem.ResponseCanonicalCategoryDto, root.InventoryManagementSystem.ResponseCanonicalListCategoryDto);
  }
}(this, function(ApiClient, CategoryDto, ResponseCanonicalCategoryDto, ResponseCanonicalListCategoryDto) {
  'use strict';

  /**
   * CategoryController service.
   * @module api/CategoryControllerApi
   * @version 2.0
   */

  /**
   * Constructs a new CategoryControllerApi. 
   * @alias module:api/CategoryControllerApi
   * @class
   * @param {module:ApiClient} [apiClient] Optional API client implementation to use,
   * default to {@link module:ApiClient#instance} if unspecified.
   */
  var exports = function(apiClient) {
    this.apiClient = apiClient || ApiClient.instance;


    /**
     * Callback function to receive the result of the createCategoryUsingPOST operation.
     * @callback module:api/CategoryControllerApi~createCategoryUsingPOSTCallback
     * @param {String} error Error message, if any.
     * @param {module:model/ResponseCanonicalCategoryDto} data The data returned by the service call.
     * @param {String} response The complete HTTP response.
     */

    /**
     * createCategory
     * @param {module:model/CategoryDto} entityParam entityParam
     * @param {module:api/CategoryControllerApi~createCategoryUsingPOSTCallback} callback The callback function, accepting three arguments: error, data, response
     * data is of type: {@link module:model/ResponseCanonicalCategoryDto}
     */
    this.createCategoryUsingPOST = function(entityParam, callback) {
      var postBody = entityParam;

      // verify the required parameter 'entityParam' is set
      if (entityParam === undefined || entityParam === null) {
        throw new Error("Missing the required parameter 'entityParam' when calling createCategoryUsingPOST");
      }


      var pathParams = {
      };
      var queryParams = {
      };
      var collectionQueryParams = {
      };
      var headerParams = {
      };
      var formParams = {
      };

      var authNames = [];
      var contentTypes = ['application/json'];
      var accepts = ['*/*'];
      var returnType = ResponseCanonicalCategoryDto;

      return this.apiClient.callApi(
        '/categories/', 'POST',
        pathParams, queryParams, collectionQueryParams, headerParams, formParams, postBody,
        authNames, contentTypes, accepts, returnType, callback
      );
    }

    /**
     * Callback function to receive the result of the findCategoryUsingGET operation.
     * @callback module:api/CategoryControllerApi~findCategoryUsingGETCallback
     * @param {String} error Error message, if any.
     * @param {module:model/ResponseCanonicalCategoryDto} data The data returned by the service call.
     * @param {String} response The complete HTTP response.
     */

    /**
     * findCategory
     * @param {Number} id id
     * @param {module:api/CategoryControllerApi~findCategoryUsingGETCallback} callback The callback function, accepting three arguments: error, data, response
     * data is of type: {@link module:model/ResponseCanonicalCategoryDto}
     */
    this.findCategoryUsingGET = function(id, callback) {
      var postBody = null;

      // verify the required parameter 'id' is set
      if (id === undefined || id === null) {
        throw new Error("Missing the required parameter 'id' when calling findCategoryUsingGET");
      }


      var pathParams = {
        'id': id
      };
      var queryParams = {
      };
      var collectionQueryParams = {
      };
      var headerParams = {
      };
      var formParams = {
      };

      var authNames = [];
      var contentTypes = [];
      var accepts = ['*/*'];
      var returnType = ResponseCanonicalCategoryDto;

      return this.apiClient.callApi(
        '/categories/{id}', 'GET',
        pathParams, queryParams, collectionQueryParams, headerParams, formParams, postBody,
        authNames, contentTypes, accepts, returnType, callback
      );
    }

    /**
     * Callback function to receive the result of the listCategoriesUsingGET operation.
     * @callback module:api/CategoryControllerApi~listCategoriesUsingGETCallback
     * @param {String} error Error message, if any.
     * @param {module:model/ResponseCanonicalListCategoryDto} data The data returned by the service call.
     * @param {String} response The complete HTTP response.
     */

    /**
     * listCategories
     * @param {Object} opts Optional parameters
     * @param {Number} opts.skip 
     * @param {Number} opts.limit 
     * @param {Date} opts.from 
     * @param {Date} opts.to 
     * @param {String} opts.name 
     * @param {String} opts.description 
     * @param {Number} opts.parentCategoryId 
     * @param {module:api/CategoryControllerApi~listCategoriesUsingGETCallback} callback The callback function, accepting three arguments: error, data, response
     * data is of type: {@link module:model/ResponseCanonicalListCategoryDto}
     */
    this.listCategoriesUsingGET = function(opts, callback) {
      opts = opts || {};
      var postBody = null;


      var pathParams = {
      };
      var queryParams = {
        'skip': opts['skip'],
        'limit': opts['limit'],
        'from': opts['from'],
        'to': opts['to'],
        'name': opts['name'],
        'description': opts['description'],
        'parentCategoryId': opts['parentCategoryId'],
      };
      var collectionQueryParams = {
      };
      var headerParams = {
      };
      var formParams = {
      };

      var authNames = [];
      var contentTypes = [];
      var accepts = ['*/*'];
      var returnType = ResponseCanonicalListCategoryDto;

      return this.apiClient.callApi(
        '/categories/', 'GET',
        pathParams, queryParams, collectionQueryParams, headerParams, formParams, postBody,
        authNames, contentTypes, accepts, returnType, callback
      );
    }

    /**
     * Callback function to receive the result of the updateCategoryUsingPUT operation.
     * @callback module:api/CategoryControllerApi~updateCategoryUsingPUTCallback
     * @param {String} error Error message, if any.
     * @param {module:model/ResponseCanonicalCategoryDto} data The data returned by the service call.
     * @param {String} response The complete HTTP response.
     */

    /**
     * updateCategory
     * @param {Number} id id
     * @param {module:model/CategoryDto} entityParam entityParam
     * @param {module:api/CategoryControllerApi~updateCategoryUsingPUTCallback} callback The callback function, accepting three arguments: error, data, response
     * data is of type: {@link module:model/ResponseCanonicalCategoryDto}
     */
    this.updateCategoryUsingPUT = function(id, entityParam, callback) {
      var postBody = entityParam;

      // verify the required parameter 'id' is set
      if (id === undefined || id === null) {
        throw new Error("Missing the required parameter 'id' when calling updateCategoryUsingPUT");
      }

      // verify the required parameter 'entityParam' is set
      if (entityParam === undefined || entityParam === null) {
        throw new Error("Missing the required parameter 'entityParam' when calling updateCategoryUsingPUT");
      }


      var pathParams = {
        'id': id
      };
      var queryParams = {
      };
      var collectionQueryParams = {
      };
      var headerParams = {
      };
      var formParams = {
      };

      var authNames = [];
      var contentTypes = ['application/json'];
      var accepts = ['*/*'];
      var returnType = ResponseCanonicalCategoryDto;

      return this.apiClient.callApi(
        '/categories/{id}', 'PUT',
        pathParams, queryParams, collectionQueryParams, headerParams, formParams, postBody,
        authNames, contentTypes, accepts, returnType, callback
      );
    }
  };

  return exports;
}));
