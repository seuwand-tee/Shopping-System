"use strict";

class SaleItem {

    constructor(product, quantity) {
        // only set the fields if we have a valid product
        if (product) {
            this.product = product;
            this.quantity_purchased = quantity;
            this.sale_price = product.list_price;
        }
    }

    getItemTotal() {
        return this.sale_price * this.quantity_purchased;
    }

}

class ShoppingCart {

    constructor() {
        this.items = new Array();
    }

    reconstruct(sessionData) {
        for (let item of sessionData.items) {
            this.addItem(Object.assign(new SaleItem(), item));
        }
    }

    getItems() {
        return this.items;
    }

    addItem(item) {
        this.items.push(item);
    }

    setCustomer(customer) {
        this.customer = customer;
    }

    getTotal() {
        let total = 0;
        for (let item of this.items) {
            total += item.getItemTotal();
        }
        return total;
    }

}

// create a new module, and load the other pluggable modules
var module = angular.module('ShoppingApp', ['ngResource', 'ngStorage']);

module.factory('productAPI', function ($resource) {
    return $resource('/api/products/:id');
});

module.factory('categoryAPI', function ($resource) {
    return $resource('/api/categories/:cat');
});

module.factory('signInAPI', function ($resource) {
   return $resource('/api/customers/:username');
});

module.factory('registerAPI', function ($resource) {
   return $resource('/api/register');
});

module.factory('cart', function ($sessionStorage) {
    let cart = new ShoppingCart();

    // is the cart in the session storage?
    if ($sessionStorage.cart) {

        // reconstruct the cart from the session data
        cart.reconstruct($sessionStorage.cart);
    }

    return cart;
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
	this.showAll = function () {
		this.products = productAPI.query();
	};
});

module.controller('CustomerController', function (registerAPI, signInAPI, $window, $sessionStorage) {
	
	// alias 'this' so that we can access it inside callback functions
	let ctrl = this;
	
	this.signInMessage = "Please sign in to continue.";
	
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

	};


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


module.controller('ShoppingCartController', function (cart, $sessionStorage, $window) {
	this.items = cart.getItems();
	this.total = cart.getTotal();
	this.selectedProduct = $sessionStorage.selectedProduct;
	
	this.buy = function(product){
		 $sessionStorage.selectedProduct = product;
		 $window.location = "quantity.html";
	};
});