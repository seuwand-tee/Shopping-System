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

	public String getProduct_id() {
		return product_id;
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public String getCategory() {
		return category;
	}

	public BigDecimal getList_price() {
		return list_price;
	}

	public BigDecimal getQuantity_in_stock() {
		return quantity_in_stock;
	}

	public void setProduct_id(String product_id) {
		this.product_id = product_id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public void setList_price(BigDecimal list_price) {
		this.list_price = list_price;
	}

	public void setQuantity_in_stock(BigDecimal quantity_in_stock) {
		this.quantity_in_stock = quantity_in_stock;
	}

	@Override
	public String toString() {
		return "Product{" + "product_id=" + product_id + ", name=" + name;
	
	
}
}