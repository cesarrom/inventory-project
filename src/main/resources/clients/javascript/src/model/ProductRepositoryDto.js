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
    define(['ApiClient', 'model/MovementDetailDto', 'model/ProductDto', 'model/RepositoryDto'], factory);
  } else if (typeof module === 'object' && module.exports) {
    // CommonJS-like environments that support module.exports, like Node.
    module.exports = factory(require('../ApiClient'), require('./MovementDetailDto'), require('./ProductDto'), require('./RepositoryDto'));
  } else {
    // Browser globals (root is window)
    if (!root.InventoryManagementSystem) {
      root.InventoryManagementSystem = {};
    }
    root.InventoryManagementSystem.ProductRepositoryDto = factory(root.InventoryManagementSystem.ApiClient, root.InventoryManagementSystem.MovementDetailDto, root.InventoryManagementSystem.ProductDto, root.InventoryManagementSystem.RepositoryDto);
  }
}(this, function(ApiClient, MovementDetailDto, ProductDto, RepositoryDto) {
  'use strict';




  /**
   * The ProductRepositoryDto model module.
   * @module model/ProductRepositoryDto
   * @version 2.0
   */

  /**
   * Constructs a new <code>ProductRepositoryDto</code>.
   * @alias module:model/ProductRepositoryDto
   * @class
   */
  var exports = function() {
    var _this = this;










  };

  /**
   * Constructs a <code>ProductRepositoryDto</code> from a plain JavaScript object, optionally creating a new instance.
   * Copies all relevant properties from <code>data</code> to <code>obj</code> if supplied or a new instance if not.
   * @param {Object} data The plain JavaScript object bearing properties of interest.
   * @param {module:model/ProductRepositoryDto} obj Optional instance to populate.
   * @return {module:model/ProductRepositoryDto} The populated <code>ProductRepositoryDto</code> instance.
   */
  exports.constructFromObject = function(data, obj) {
    if (data) {
      obj = obj || new exports();

      if (data.hasOwnProperty('createdAt')) {
        obj['createdAt'] = ApiClient.convertToType(data['createdAt'], 'Date');
      }
      if (data.hasOwnProperty('currentQuantity')) {
        obj['currentQuantity'] = ApiClient.convertToType(data['currentQuantity'], 'Number');
      }
      if (data.hasOwnProperty('id')) {
        obj['id'] = ApiClient.convertToType(data['id'], 'Number');
      }
      if (data.hasOwnProperty('negativeMovements')) {
        obj['negativeMovements'] = ApiClient.convertToType(data['negativeMovements'], [MovementDetailDto]);
      }
      if (data.hasOwnProperty('positiveMovements')) {
        obj['positiveMovements'] = ApiClient.convertToType(data['positiveMovements'], [MovementDetailDto]);
      }
      if (data.hasOwnProperty('price')) {
        obj['price'] = ApiClient.convertToType(data['price'], 'Number');
      }
      if (data.hasOwnProperty('product')) {
        obj['product'] = ProductDto.constructFromObject(data['product']);
      }
      if (data.hasOwnProperty('repository')) {
        obj['repository'] = RepositoryDto.constructFromObject(data['repository']);
      }
      if (data.hasOwnProperty('updatedAt')) {
        obj['updatedAt'] = ApiClient.convertToType(data['updatedAt'], 'Date');
      }
    }
    return obj;
  }

  /**
   * @member {Date} createdAt
   */
  exports.prototype['createdAt'] = undefined;
  /**
   * @member {Number} currentQuantity
   */
  exports.prototype['currentQuantity'] = undefined;
  /**
   * @member {Number} id
   */
  exports.prototype['id'] = undefined;
  /**
   * @member {Array.<module:model/MovementDetailDto>} negativeMovements
   */
  exports.prototype['negativeMovements'] = undefined;
  /**
   * @member {Array.<module:model/MovementDetailDto>} positiveMovements
   */
  exports.prototype['positiveMovements'] = undefined;
  /**
   * @member {Number} price
   */
  exports.prototype['price'] = undefined;
  /**
   * @member {module:model/ProductDto} product
   */
  exports.prototype['product'] = undefined;
  /**
   * @member {module:model/RepositoryDto} repository
   */
  exports.prototype['repository'] = undefined;
  /**
   * @member {Date} updatedAt
   */
  exports.prototype['updatedAt'] = undefined;



  return exports;
}));

