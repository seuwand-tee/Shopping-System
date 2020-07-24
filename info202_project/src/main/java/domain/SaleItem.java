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
public class SaleItem {
	private BigDecimal quantity_purchased;
	private BigDecimal sale_price;
	private Product product;

	public SaleItem() {
	}

	public SaleItem(BigDecimal quantity_purchased, BigDecimal sale_price, Product product) {
		this.quantity_purchased = quantity_purchased;
		this.sale_price = sale_price;
		this.product = product;
	}
	

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}
	
		public BigDecimal getItemTotal(){
			
		return sale_price.multiply(quantity_purchased);
		}

	public BigDecimal getQuantity_purchased() {
		return quantity_purchased;
	}

	public BigDecimal getSale_price() {
		return sale_price;
	}

	public void setQuantity_purchased(BigDecimal quantity_purchased) {
		this.quantity_purchased = quantity_purchased;
	}

	public void setSale_price(BigDecimal sale_price) {
		this.sale_price = sale_price;
	}

	@Override
	public String toString() {
		return "SaleItem{" + "quantity_purchased=" + quantity_purchased + ", sale_price=" + sale_price + '}';
	}
	
		
}
