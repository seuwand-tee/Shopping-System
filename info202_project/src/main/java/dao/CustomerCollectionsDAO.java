/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

/**
 *
 * @author User
 */
 
import domain.Customer;
import java.util.HashMap;
import java.util.Map;
 
public final class CustomerCollectionsDAO implements CustomerDAO {
 
	private static final Map<String, Customer> customers = new HashMap<>();
 
	public CustomerCollectionsDAO() {
		// some dummy data for testing
		domain.Customer boris = new domain.Customer();
		boris.setUsername("boris");
		boris.setFirstname("Boris");
		boris.setSurname("McNorris");
		boris.setPassword("guest");
		boris.setShipping_address("123 Some Street,\nNorth East Valley,\nDunedin");
		boris.setEmail_address("boris@example.net");
 
		Customer doris = new Customer();
		doris.setUsername("doris");
		doris.setFirstname("Doris");
		doris.setSurname("Dolores");
		doris.setPassword("guest");
		doris.setShipping_address("321 Anywere Ave,\nSt Clair,\nDunedin");
		doris.setEmail_address("doris@example.net");
 
		saveCustomer(boris);
		saveCustomer(doris);
	}
 
	@Override
	public void saveCustomer(Customer customer) {
		System.out.println("Saving customer: " + customer);
		customers.put(customer.getUsername(), customer);
	}
 
	@Override
	public Customer getCustomer(String username) {
		return customers.get(username);
	}
 
	@Override
	public Boolean validateCredentials(String username, String password) {
		if (customers.containsKey(username)) {
			return customers.get(username).getPassword().equals(password);
		} else {
			return false;
		}
	}
 
}
