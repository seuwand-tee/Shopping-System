/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web;

import org.jooby.Jooby;

/**
 *
 * @author User
 */
public class CustomerModel extends Jooby {

	final dao.CustomerDAO customerDAO;

	public CustomerModel(dao.CustomerDAO dao) {
		this.customerDAO = dao;
		get("/api/customer/:customer_id", (req) -> {
			String id = req.param("customer_id").value();
			return customerDAO.getCustomer(id);
		});
	}
}
