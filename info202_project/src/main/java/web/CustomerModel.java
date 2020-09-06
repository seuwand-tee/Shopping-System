/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web;

import domain.Customer;
import org.jooby.Jooby;
import org.jooby.Status;

/**
 *
 * @author User
 */
public class CustomerModel extends Jooby {

    final dao.CustomerDAO customerDAO;

    public CustomerModel(dao.CustomerDAO dao) {
        this.customerDAO = dao;
        get("/api/customer/:username", (req) -> {
            String username = req.param("username").value();
            return customerDAO.getCustomer(username);
        });
        post("/api/register", (req, rsp) -> {
            Customer customer = req.body().to(Customer.class);
            customerDAO.saveCustomer(customer);
            rsp.status(Status.CREATED);
        });
    }
}
