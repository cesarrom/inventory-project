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
    define(['ApiClient', 'model/MovementTypeDto'], factory);
  } else if (typeof module === 'object' && module.exports) {
    // CommonJS-like environments that support module.exports, like Node.
    module.exports = factory(require('../ApiClient'), require('./MovementTypeDto'));
  } else {
    // Browser globals (root is window)
    if (!root.InventoryManagementSystem) {
      root.InventoryManagementSystem = {};
    }
    root.InventoryManagementSystem.ResponseCanonicalMovementTypeDto = factory(root.InventoryManagementSystem.ApiClient, root.InventoryManagementSystem.MovementTypeDto);
  }
}(this, function(ApiClient, MovementTypeDto) {
  'use strict';




  /**
   * The ResponseCanonicalMovementTypeDto model module.
   * @module model/ResponseCanonicalMovementTypeDto
   * @version 2.0
   */

  /**
   * Constructs a new <code>ResponseCanonicalMovementTypeDto</code>.
   * @alias module:model/ResponseCanonicalMovementTypeDto
   * @class
   */
  var exports = function() {
    var _this = this;



  };

  /**
   * Constructs a <code>ResponseCanonicalMovementTypeDto</code> from a plain JavaScript object, optionally creating a new instance.
   * Copies all relevant properties from <code>data</code> to <code>obj</code> if supplied or a new instance if not.
   * @param {Object} data The plain JavaScript object bearing properties of interest.
   * @param {module:model/ResponseCanonicalMovementTypeDto} obj Optional instance to populate.
   * @return {module:model/ResponseCanonicalMovementTypeDto} The populated <code>ResponseCanonicalMovementTypeDto</code> instance.
   */
  exports.constructFromObject = function(data, obj) {
    if (data) {
      obj = obj || new exports();

      if (data.hasOwnProperty('response')) {
        obj['response'] = MovementTypeDto.constructFromObject(data['response']);
      }
      if (data.hasOwnProperty('status')) {
        obj['status'] = ApiClient.convertToType(data['status'], 'Number');
      }
    }
    return obj;
  }

  /**
   * @member {module:model/MovementTypeDto} response
   */
  exports.prototype['response'] = undefined;
  /**
   * @member {Number} status
   */
  exports.prototype['status'] = undefined;



  return exports;
}));

