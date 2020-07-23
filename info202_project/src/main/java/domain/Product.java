/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.math.BigDecimal;

/**
 *
 * @author teewa743
 */
public class Product {
	private String product_id;
	private String name;
	private String description;
	private String category;
	private BigDecimal list_price;
	private BigDecimal quantity_in_stock;

	public Product() {
	}
	

	public Product(String product_id, String name, String description, String category, BigDecimal list_price, BigDecimal quantity_in_stock) {
		this.product_id = product_id;
		this.name = name;
		this.description = description;
		this.category = category;
		this.list_price = list_price;
		this.quantity_in_stock = quantity_in_stock;
	}
	

	public String getProductID() {
		return product_id;
	}

	public String getProductName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public String getCategory() {
		return category;
	}

	public BigDecimal getListPrice() {
		return list_price;
	}

	public BigDecimal getQuantityInStock() {
		return quantity_in_stock;
	}

	public void setProductID(String product_id) {
		this.product_id = product_id;
	}

	public void setProductName(String name) {
		this.name = name;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public void setListPrice(BigDecimal list_price) {
		this.list_price = list_price;
	}

	public void setQuantityInStock(BigDecimal quantity_in_stock) {
		this.quantity_in_stock = quantity_in_stock;
	}

	@Override
	public String toString() {
		return "Product ID= " + product_id + ", name= " + name;
	}

	
}