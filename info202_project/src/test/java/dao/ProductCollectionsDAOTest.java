/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.math.BigDecimal;
import static org.hamcrest.MatcherAssert.assertThat;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;

/**
 *
 * @author teewa743
 */
public class ProductCollectionsDAOTest {
	private domain.Product product;
	private domain.Product item;
	private domain.Product stock;
	private static dao.ProductCollectionsDAO products;
	
	@BeforeEach
	public void setUp() {
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
		
	}
	
	@AfterEach
	public void tearDown() {
		products.deleteProduct(item);
		products.deleteProduct(stock);
	}

	@Test
	public void testSaveProduct() {
		products = new ProductCollectionsDAO();
		products.saveProduct(product);
		assertThat(products.getProduct(), hasItem(product));
	}

	@Test
	public void testGetProduct() {
	assertThat(products.getProduct(), hasItem(item));
	assertThat(products.getProduct(), hasItem(stock));
	}

	@Test
	public void testDeleteProduct() {
		products.deleteProduct(item);
		assertThat(products.getProduct(), not(hasItem(item)));
		products.deleteProduct(stock);
		assertThat(products.getProduct(), not(hasItem(stock)));
	}
	
}
