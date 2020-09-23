/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web;

import java.util.concurrent.CompletableFuture;
import org.jooby.Jooby;
import org.jooby.json.Gzon;

/**
 *
 * @author User
 */
public class Server extends Jooby{
    final dao.ProductDAO productDao = new dao.ProductJdbcDAO(); 
    final dao.CustomerDAO customerDao = new dao.CustomerJdbcDAO();
    final dao.SaleDAO salesDao = new dao.SaleJdbcDAO(); 
    public static void main(String[] args) throws Exception {
   System.out.println("\nStarting Server.");

   Server server = new Server();

   CompletableFuture.runAsync(() -> {
      server.start();
   });

   server.onStarted(() -> {
      System.out.println("\nPress Enter to stop the server.");
   });

   // wait for user to hit the Enter key
   System.in.read();
   System.exit(0);
}
    public Server(){
    port(8080);
    use(new web.ProductModule(productDao));
    use(new Gzon());
    use(new web.CustomerModel(customerDao));
    use(new AssetModule());
     use(new web.SalesModule(salesDao));
    }
}
