/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import domain.Customer;

/**
 *
 * @author User
 */
public interface CustomerDAO {

    Customer getCustomer(String username);

    void saveCustomer(Customer customer);

    Boolean validateCredentials(String username, String password);
    
}
