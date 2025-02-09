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
    instance = new InventoryManagementSystem.MovementTypeDto();
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

  describe('MovementTypeDto', function() {
    it('should create an instance of MovementTypeDto', function() {
      // uncomment below and update the code to test MovementTypeDto
      //var instance = new InventoryManagementSystem.MovementTypeDto();
      //expect(instance).to.be.a(InventoryManagementSystem.MovementTypeDto);
    });

    it('should have the property createdAt (base name: "createdAt")', function() {
      // uncomment below and update the code to test the property createdAt
      //var instance = new InventoryManagementSystem.MovementTypeDto();
      //expect(instance).to.be();
    });

    it('should have the property description (base name: "description")', function() {
      // uncomment below and update the code to test the property description
      //var instance = new InventoryManagementSystem.MovementTypeDto();
      //expect(instance).to.be();
    });

    it('should have the property id (base name: "id")', function() {
      // uncomment below and update the code to test the property id
      //var instance = new InventoryManagementSystem.MovementTypeDto();
      //expect(instance).to.be();
    });

    it('should have the property movements (base name: "movements")', function() {
      // uncomment below and update the code to test the property movements
      //var instance = new InventoryManagementSystem.MovementTypeDto();
      //expect(instance).to.be();
    });

    it('should have the property name (base name: "name")', function() {
      // uncomment below and update the code to test the property name
      //var instance = new InventoryManagementSystem.MovementTypeDto();
      //expect(instance).to.be();
    });

    it('should have the property parentMovementRequired (base name: "parentMovementRequired")', function() {
      // uncomment below and update the code to test the property parentMovementRequired
      //var instance = new InventoryManagementSystem.MovementTypeDto();
      //expect(instance).to.be();
    });

    it('should have the property sourceRepository (base name: "sourceRepository")', function() {
      // uncomment below and update the code to test the property sourceRepository
      //var instance = new InventoryManagementSystem.MovementTypeDto();
      //expect(instance).to.be();
    });

    it('should have the property targetRepository (base name: "targetRepository")', function() {
      // uncomment below and update the code to test the property targetRepository
      //var instance = new InventoryManagementSystem.MovementTypeDto();
      //expect(instance).to.be();
    });

    it('should have the property updatedAt (base name: "updatedAt")', function() {
      // uncomment below and update the code to test the property updatedAt
      //var instance = new InventoryManagementSystem.MovementTypeDto();
      //expect(instance).to.be();
    });

  });

}));
