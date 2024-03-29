/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;

/**
 *
 * @author teewa743
 */
public class Sale {
	private Integer sale_id;
	private LocalDateTime date;
	private String status;
	private Customer customer;
	private Collection<SaleItem> items = new ArrayList<>();

	public Sale() {
	}

	public Sale(Integer sale_id, LocalDateTime date, String status, Customer customer) {
		this.sale_id = sale_id;
		this.date = date;
		this.status = status;
		this.customer = customer;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Collection<SaleItem> getItems() {
		return items;
	}

	public void setItems(Collection<SaleItem> items) {
		this.items = items;
	}
	
	public BigDecimal getTotal(){
		
		// loop through all sale items, calling getItemTotal() and summing together
		BigDecimal total = new BigDecimal(0);
		for (SaleItem s : items) {
		total = total.add(s.getItemTotal());
		}
		return total;
}
	public void addItem(SaleItem saleitem){
		items.add(saleitem);
	}

	public Integer getSale_id() {
		return sale_id;
	}

	public LocalDateTime getDate() {
		return date;
	}

	public String getStatus() {
		return status;
	}

	public void setSale_id(Integer sale_id) {
		this.sale_id = sale_id;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Sale{" + "sale_id=" + sale_id + ", date=" + date + ", status=" + status + ", customer=" + customer + ", items=" + items + '}';
	}


	
}
