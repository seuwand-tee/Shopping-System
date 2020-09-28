
import java.math.BigDecimal;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author teewa743
 */
public class Main {

	/**
	 * @param args the command line arguments
	 */
	public static void main(String[] args) {
	final dao.ProductDAO productsList = new dao.ProductJdbcDAO();
	domain.Product product;
	domain.Product item;
	domain.Product stock;
	dao.ProductCollectionsDAO products;
	
		products = new dao.ProductCollectionsDAO();
		product = new domain.Product();
		product.setCategory("category");
		product.setDescription("description");
		product.setProductID("item");
		product.setProductName("Polkadot Widget");
		product.setListPrice(new BigDecimal(10));
		product.setQuantityInStock(new BigDecimal(5));
		item = new domain.Product();
		item.setCategory("category1");
		item.setDescription("description1");
		item.setProductID("item1");
		item.setProductName("Widget");
		item.setListPrice(new BigDecimal(101));
		item.setQuantityInStock(new BigDecimal(51));
		stock = new domain.Product();
		stock.setCategory("category2");
		stock.setDescription("description2");
		stock.setProductID("item2");
		stock.setProductName("Widget2");
		stock.setListPrice(new BigDecimal(102));
		stock.setQuantityInStock(new BigDecimal(52));
		products.saveProduct(item);
		products.saveProduct(stock);
		products.saveProduct(product);
		
		gui.MainMenu main = new gui.MainMenu(productsList);
		main.setLocationRelativeTo(null);
		main.setVisible(true);

	}
	
}
