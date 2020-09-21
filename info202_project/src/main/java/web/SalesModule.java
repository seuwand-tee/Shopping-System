/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web;

import org.jooby.Jooby;
import org.jooby.Status;
import domain.Sale;

/**
 *
 * @author User
 */
public class SalesModule extends Jooby {
    final dao.SaleDAO salesDAO;
    
    public SalesModule (dao.SaleDAO sales){
        this.salesDAO = sales;
        post("/api/sales", (req, rsp) -> {
            Sale sale = req.body().to(Sale.class);
            salesDAO.save(sale);
            rsp.status(Status.CREATED);
        });
        
    }
}
