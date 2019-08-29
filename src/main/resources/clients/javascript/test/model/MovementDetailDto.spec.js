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
    // AMD.
    define(['expect.js', '../../src/index'], factory);
  } else if (typeof module === 'object' && module.exports) {
    // CommonJS-like environments that support module.exports, like Node.
    factory(require('expect.js'), require('../../src/index'));
  } else {
    // Browser globals (root is window)
    factory(root.expect, root.InventoryManagementSystem);
  }
}(this, function(expect, InventoryManagementSystem) {
  'use strict';

  var instance;

  beforeEach(function() {
    instance = new InventoryManagementSystem.MovementDetailDto();
  });

  var getProperty = function(object, getter, property) {
    // Use getter method if present; otherwise, get the property directly.
    if (typeof object[getter] === 'function')
      return object[getter]();
    else
      return object[property];
  }

  var setProperty = function(object, setter, property, value) {
    // Use setter method if present; otherwise, set the property directly.
    if (typeof object[setter] === 'function')
      object[setter](value);
    else
      object[property] = value;
  }

  describe('MovementDetailDto', function() {
    it('should create an instance of MovementDetailDto', function() {
      // uncomment below and update the code to test MovementDetailDto
      //var instance = new InventoryManagementSystem.MovementDetailDto();
      //expect(instance).to.be.a(InventoryManagementSystem.MovementDetailDto);
    });

    it('should have the property createdAt (base name: "createdAt")', function() {
      // uncomment below and update the code to test the property createdAt
      //var instance = new InventoryManagementSystem.MovementDetailDto();
      //expect(instance).to.be();
    });

    it('should have the property id (base name: "id")', function() {
      // uncomment below and update the code to test the property id
      //var instance = new InventoryManagementSystem.MovementDetailDto();
      //expect(instance).to.be();
    });

    it('should have the property movement (base name: "movement")', function() {
      // uncomment below and update the code to test the property movement
      //var instance = new InventoryManagementSystem.MovementDetailDto();
      //expect(instance).to.be();
    });

    it('should have the property product (base name: "product")', function() {
      // uncomment below and update the code to test the property product
      //var instance = new InventoryManagementSystem.MovementDetailDto();
      //expect(instance).to.be();
    });

    it('should have the property quantity (base name: "quantity")', function() {
      // uncomment below and update the code to test the property quantity
      //var instance = new InventoryManagementSystem.MovementDetailDto();
      //expect(instance).to.be();
    });

    it('should have the property sourceProductRepository (base name: "sourceProductRepository")', function() {
      // uncomment below and update the code to test the property sourceProductRepository
      //var instance = new InventoryManagementSystem.MovementDetailDto();
      //expect(instance).to.be();
    });

    it('should have the property targetProductRepository (base name: "targetProductRepository")', function() {
      // uncomment below and update the code to test the property targetProductRepository
      //var instance = new InventoryManagementSystem.MovementDetailDto();
      //expect(instance).to.be();
    });

    it('should have the property updatedAt (base name: "updatedAt")', function() {
      // uncomment below and update the code to test the property updatedAt
      //var instance = new InventoryManagementSystem.MovementDetailDto();
      //expect(instance).to.be();
    });

    it('should have the property value (base name: "value")', function() {
      // uncomment below and update the code to test the property value
      //var instance = new InventoryManagementSystem.MovementDetailDto();
      //expect(instance).to.be();
    });

  });

}));