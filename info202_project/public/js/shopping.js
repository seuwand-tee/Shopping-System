/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/* global $window, signInAPI, $sessionStorage */

"use strict";
// create a new module, and load the other pluggable modules
var module = angular.module('ShoppingApp', ['ngResource', 'ngStorage']);
module.factory('productAPI', function ($resource) {
    return $resource('/api/products/:id');
});
module.controller('ProductController', function (productAPI, categoryAPI) {
// load the products
this.products = productAPI.query();
// load the categories
this.categories = categoryAPI.query();
// click handler for the category filter buttons
this.selectCategory = function (selectedCat) {
   this.products = categoryAPI.query({"cat": selectedCat});
};
});
module.factory('categoryAPI', function ($resource) {
    return $resource('/api/categories/:cat');
});
module.controller('CustomerController', function (registerAPI) {
this.registerCustomer = function (customer) {
   registerAPI.save(null, customer,

   // success callback
   function () {
      $window.location = 'signin.html';
   },

   // error callback
   function (error) {
      console.log(error);
   }
);
this.signInMessage = "Please sign in to continue.";
};
// alias 'this' so that we can access it inside callback functions
let ctrl = this;

this.signIn = function (username, password) {

   // get customer from web service
   signInAPI.get({'username': username},
      // success callback
      function (customer) {
         // also store the retrieved customer
         $sessionStorage.customer = customer;

         // redirect to home
         $window.location = '.';
      },
      // fail callback
      function () {
         ctrl.signInMessage = 'Sign in failed. Please try again.';
      }
   );
};
});
module.factory('signInAPI', function ($resource) {
   return $resource('/api/customers/:username');
});
