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
    define(['ApiClient', 'model/MovementDto', 'model/ProductDto', 'model/ProductRepositoryDto'], factory);
  } else if (typeof module === 'object' && module.exports) {
    // CommonJS-like environments that support module.exports, like Node.
    module.exports = factory(require('../ApiClient'), require('./MovementDto'), require('./ProductDto'), require('./ProductRepositoryDto'));
  } else {
    // Browser globals (root is window)
    if (!root.InventoryManagementSystem) {
      root.InventoryManagementSystem = {};
    }
    root.InventoryManagementSystem.MovementDetailDto = factory(root.InventoryManagementSystem.ApiClient, root.InventoryManagementSystem.MovementDto, root.InventoryManagementSystem.ProductDto, root.InventoryManagementSystem.ProductRepositoryDto);
  }
}(this, function(ApiClient, MovementDto, ProductDto, ProductRepositoryDto) {
  'use strict';




  /**
   * The MovementDetailDto model module.
   * @module model/MovementDetailDto
   * @version 2.0
   */

  /**
   * Constructs a new <code>MovementDetailDto</code>.
   * @alias module:model/MovementDetailDto
   * @class
   */
  var exports = function() {
    var _this = this;










  };

  /**
   * Constructs a <code>MovementDetailDto</code> from a plain JavaScript object, optionally creating a new instance.
   * Copies all relevant properties from <code>data</code> to <code>obj</code> if supplied or a new instance if not.
   * @param {Object} data The plain JavaScript object bearing properties of interest.
   * @param {module:model/MovementDetailDto} obj Optional instance to populate.
   * @return {module:model/MovementDetailDto} The populated <code>MovementDetailDto</code> instance.
   */
  exports.constructFromObject = function(data, obj) {
    if (data) {
      obj = obj || new exports();

      if (data.hasOwnProperty('createdAt')) {
        obj['createdAt'] = ApiClient.convertToType(data['createdAt'], 'Date');
      }
      if (data.hasOwnProperty('id')) {
        obj['id'] = ApiClient.convertToType(data['id'], 'Number');
      }
      if (data.hasOwnProperty('movement')) {
        obj['movement'] = MovementDto.constructFromObject(data['movement']);
      }
      if (data.hasOwnProperty('product')) {
        obj['product'] = ProductDto.constructFromObject(data['product']);
      }
      if (data.hasOwnProperty('quantity')) {
        obj['quantity'] = ApiClient.convertToType(data['quantity'], 'Number');
      }
      if (data.hasOwnProperty('sourceProductRepository')) {
        obj['sourceProductRepository'] = ProductRepositoryDto.constructFromObject(data['sourceProductRepository']);
      }
      if (data.hasOwnProperty('targetProductRepository')) {
        obj['targetProductRepository'] = ProductRepositoryDto.constructFromObject(data['targetProductRepository']);
      }
      if (data.hasOwnProperty('updatedAt')) {
        obj['updatedAt'] = ApiClient.convertToType(data['updatedAt'], 'Date');
      }
      if (data.hasOwnProperty('value')) {
        obj['value'] = ApiClient.convertToType(data['value'], 'Number');
      }
    }
    return obj;
  }

  /**
   * @member {Date} createdAt
   */
  exports.prototype['createdAt'] = undefined;
  /**
   * @member {Number} id
   */
  exports.prototype['id'] = undefined;
  /**
   * @member {module:model/MovementDto} movement
   */
  exports.prototype['movement'] = undefined;
  /**
   * @member {module:model/ProductDto} product
   */
  exports.prototype['product'] = undefined;
  /**
   * @member {Number} quantity
   */
  exports.prototype['quantity'] = undefined;
  /**
   * @member {module:model/ProductRepositoryDto} sourceProductRepository
   */
  exports.prototype['sourceProductRepository'] = undefined;
  /**
   * @member {module:model/ProductRepositoryDto} targetProductRepository
   */
  exports.prototype['targetProductRepository'] = undefined;
  /**
   * @member {Date} updatedAt
   */
  exports.prototype['updatedAt'] = undefined;
  /**
   * @member {Number} value
   */
  exports.prototype['value'] = undefined;



  return exports;
}));

