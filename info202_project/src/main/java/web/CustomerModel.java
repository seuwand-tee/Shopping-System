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
public class CustomerModel extends Jooby{
    final dao.ProductDAO productsList;
    public CustomerModule(dao.ProductDAO dao){
    productsList = new dao.ProductJdbcDAO(uri)
    get("/api/customer", () -> productsList.getProducts());
    get("/api/customer/:customer_id", (req) -> {
    String id = req.param("customer_id").value();
    return productsList.searchByID(id);
});
    }
}
}
