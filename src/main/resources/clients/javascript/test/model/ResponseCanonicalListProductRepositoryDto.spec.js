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
    instance = new InventoryManagementSystem.ResponseCanonicalListProductRepositoryDto();
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

  describe('ResponseCanonicalListProductRepositoryDto', function() {
    it('should create an instance of ResponseCanonicalListProductRepositoryDto', function() {
      // uncomment below and update the code to test ResponseCanonicalListProductRepositoryDto
      //var instance = new InventoryManagementSystem.ResponseCanonicalListProductRepositoryDto();
      //expect(instance).to.be.a(InventoryManagementSystem.ResponseCanonicalListProductRepositoryDto);
    });

    it('should have the property response (base name: "response")', function() {
      // uncomment below and update the code to test the property response
      //var instance = new InventoryManagementSystem.ResponseCanonicalListProductRepositoryDto();
      //expect(instance).to.be();
    });

    it('should have the property status (base name: "status")', function() {
      // uncomment below and update the code to test the property status
      //var instance = new InventoryManagementSystem.ResponseCanonicalListProductRepositoryDto();
      //expect(instance).to.be();
    });

  });

}));
