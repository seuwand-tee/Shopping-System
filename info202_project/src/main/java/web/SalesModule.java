/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web;

import org.jooby.Jooby;
import org.jooby.Status;
import domain.Sale;
import java.util.concurrent.CompletableFuture;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

/**
 *
 * @author User
 */
public class SalesModule extends Jooby {
    final dao.SaleDAO salesDAO;
	 final dao.ProductDAO productDAO;
    public SalesModule (dao.SaleDAO sales, dao.ProductDAO productDAO){
        this.salesDAO = sales;
		  this.productDAO = productDAO;
        post("/api/sales", (req, rsp) -> {
            Sale sale = req.body().to(Sale.class);
				System.out.println(sale.toString());
				for (domain.SaleItem item: sale.getItems()){
				String id =  item.getProduct().getProductID();
				domain.Product product = productDAO.searchByID(id);
				item.setSale_price(product.getListPrice());
				}
            salesDAO.save(sale);
				CompletableFuture.runAsync(() -> {
				SimpleEmail email = new SimpleEmail();
				email.setHostName("localhost");
				email.setSmtpPort(2525);
					try {
						email.setFrom("user@gmail.com");
						email.setSubject("Confirmation Order");
						email.setMsg("Hi, "+ sale.getCustomer().getUsername()+"\nThis is your order " +sale.toString());
						email.addTo(sale.getCustomer().getEmail_address());
						email.send();
					} catch (EmailException ex) {
						Logger.getLogger(SalesModule.class.getName()).log(Level.SEVERE, null, ex);
					}
					rsp.status(Status.CREATED);
				});
            
        });
        
}
}
