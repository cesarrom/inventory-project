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
    define(['ApiClient', 'model/CategoryDto', 'model/ProductDto', 'model/SupplierDto'], factory);
  } else if (typeof module === 'object' && module.exports) {
    // CommonJS-like environments that support module.exports, like Node.
    module.exports = factory(require('../ApiClient'), require('./CategoryDto'), require('./ProductDto'), require('./SupplierDto'));
  } else {
    // Browser globals (root is window)
    if (!root.InventoryManagementSystem) {
      root.InventoryManagementSystem = {};
    }
    root.InventoryManagementSystem.CategoryDto = factory(root.InventoryManagementSystem.ApiClient, root.InventoryManagementSystem.CategoryDto, root.InventoryManagementSystem.ProductDto, root.InventoryManagementSystem.SupplierDto);
  }
}(this, function(ApiClient, CategoryDto, ProductDto, SupplierDto) {
  'use strict';




  /**
   * The CategoryDto model module.
   * @module model/CategoryDto
   * @version 2.0
   */

  /**
   * Constructs a new <code>CategoryDto</code>.
   * @alias module:model/CategoryDto
   * @class
   */
  var exports = function() {
    var _this = this;










  };

  /**
   * Constructs a <code>CategoryDto</code> from a plain JavaScript object, optionally creating a new instance.
   * Copies all relevant properties from <code>data</code> to <code>obj</code> if supplied or a new instance if not.
   * @param {Object} data The plain JavaScript object bearing properties of interest.
   * @param {module:model/CategoryDto} obj Optional instance to populate.
   * @return {module:model/CategoryDto} The populated <code>CategoryDto</code> instance.
   */
  exports.constructFromObject = function(data, obj) {
    if (data) {
      obj = obj || new exports();

      if (data.hasOwnProperty('createdAt')) {
        obj['createdAt'] = ApiClient.convertToType(data['createdAt'], 'Date');
      }
      if (data.hasOwnProperty('description')) {
        obj['description'] = ApiClient.convertToType(data['description'], 'String');
      }
      if (data.hasOwnProperty('id')) {
        obj['id'] = ApiClient.convertToType(data['id'], 'Number');
      }
      if (data.hasOwnProperty('name')) {
        obj['name'] = ApiClient.convertToType(data['name'], 'String');
      }
      if (data.hasOwnProperty('parentCategory')) {
        obj['parentCategory'] = CategoryDto.constructFromObject(data['parentCategory']);
      }
      if (data.hasOwnProperty('products')) {
        obj['products'] = ApiClient.convertToType(data['products'], [ProductDto]);
      }
      if (data.hasOwnProperty('subCategories')) {
        obj['subCategories'] = ApiClient.convertToType(data['subCategories'], [CategoryDto]);
      }
      if (data.hasOwnProperty('supplier')) {
        obj['supplier'] = SupplierDto.constructFromObject(data['supplier']);
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
   * @member {String} description
   */
  exports.prototype['description'] = undefined;
  /**
   * @member {Number} id
   */
  exports.prototype['id'] = undefined;
  /**
   * @member {String} name
   */
  exports.prototype['name'] = undefined;
  /**
   * @member {module:model/CategoryDto} parentCategory
   */
  exports.prototype['parentCategory'] = undefined;
  /**
   * @member {Array.<module:model/ProductDto>} products
   */
  exports.prototype['products'] = undefined;
  /**
   * @member {Array.<module:model/CategoryDto>} subCategories
   */
  exports.prototype['subCategories'] = undefined;
  /**
   * @member {module:model/SupplierDto} supplier
   */
  exports.prototype['supplier'] = undefined;
  /**
   * @member {Date} updatedAt
   */
  exports.prototype['updatedAt'] = undefined;



  return exports;
}));

