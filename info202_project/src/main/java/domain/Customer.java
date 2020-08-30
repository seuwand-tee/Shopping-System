package domain;

import java.math.BigDecimal;

/**
 *
 * @author teewa743
 */
public class Customer {
	private Integer customer_id;
	private String username;
	private String firstname;
	private String surname;
	private String password;
	private String email_address;
	private String shipping_address;
        
        public Customer(){
        }

	public Customer(Integer customer_id, String username, String firstname, String surname, String password, String email_address, String shipping_address) {
		this.customer_id = customer_id;
		this.username = username;
		this.firstname = firstname;
		this.surname = surname;
		this.password = password;
		this.email_address = email_address;
		this.shipping_address = shipping_address;
	}

    public Customer(String productID, String name, String description, String category, BigDecimal listPrice, BigDecimal quantityInStock) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

	public Integer getCustomer_id() {
		return customer_id;
	}

	public String getUsername() {
		return username;
	}

	public String getFirstname() {
		return firstname;
	}

	public String getSurname() {
		return surname;
	}

	public String getPassword() {
		return password;
	}

	public String getEmail_address() {
		return email_address;
	}

	public String getShipping_address() {
		return shipping_address;
	}

	public void setCustomer_id(Integer customer_id) {
		this.customer_id = customer_id;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setEmail_address(String email_address) {
		this.email_address = email_address;
	}

	public void setShipping_address(String shipping_address) {
		this.shipping_address = shipping_address;
	}

	@Override
	public String toString() {
		return "Customer{" + "customer_id=" + customer_id + ", username=" + username + ", firstname=" + firstname + ", surname=" + surname + ", password=" + password + ", email_address=" + email_address + ", shipping_address=" + shipping_address + '}';
	}
		
			  
}
