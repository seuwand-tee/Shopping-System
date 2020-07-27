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
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.Matchers.*;

/**
 *
 * @author teewa743
 */
public class ProductCollectionsDAOTest {

	private domain.Product product1;
	private domain.Product product2;
	private domain.Product product3;
	private static dao.ProductCollectionsDAO products;

	@BeforeEach
	public void setUp() {
		products = new dao.ProductCollectionsDAO();
		product1 = new domain.Product();
		product1.setCategory("category");
		product1.setDescription("description");
		product1.setProductID("product1");
		product1.setProductName("Polkadot Widget");
		product1.setListPrice(new BigDecimal(10));
		product1.setQuantityInStock(new BigDecimal(5));
		product2 = new domain.Product();
		product2.setCategory("category1");
		product2.setDescription("description1");
		product2.setProductID("product2");
		product2.setProductName("Widget");
		product2.setListPrice(new BigDecimal(101));
		product2.setQuantityInStock(new BigDecimal(51));
		product3 = new domain.Product();
		product3.setCategory("category2");
		product3.setDescription("description2");
		product3.setProductID("product3");
		product3.setProductName("Widget2");
		product3.setListPrice(new BigDecimal(102));
		product3.setQuantityInStock(new BigDecimal(52));
		products.saveProduct(product2);
		products.saveProduct(product3);

	}

	@AfterEach
	public void tearDown() {
		products.deleteProduct(product2);
		products.deleteProduct(product3);
		products.deleteProduct(product1);
	}

	@Test
	public void testSaveProduct() {
		products.saveProduct(product1);
		assertThat(products.getProducts(), hasItem(product1));
	}

	@Test
	public void testGetProduct() {
		assertThat(products.getProducts(), hasItem(product2));
		assertThat(products.getProducts(), hasItem(product3));
		assertThat(products.getProducts(), hasSize(2));
	}

	@Test
	public void testDeleteProduct() {
		assertThat(products.getProducts(), hasItem(product2));
		products.deleteProduct(product2);
		assertThat(products.getProducts(), not(hasItem(product2)));

		assertThat(products.getProducts(), hasItem(product3));
		products.deleteProduct(product3);
		assertThat(products.getProducts(), not(hasItem(product3)));
		assertThat(products.getProducts(), hasSize(0));
	}

	@Test
	public void testGetCategories() {
		assertThat(products.getCategories(), hasItem(product2.getCategory()));
		assertThat(products.getCategories(), hasItem(product3.getCategory()));
		assertThat(products.getProducts(), hasSize(2));
	}
	@Test
	public void testSearchByID() {
		assertThat(product2, equalTo(products.searchByID("product2")));
		assertThat(product3, equalTo(products.searchByID("product3")));
		assertThat(product1, not(equalTo(products.searchByID("product1"))));
	}
	@Test
	public void testFilterByCategory() {
		assertThat(products.filterByCategory(product2.getCategory()), hasItem(product2));
		assertThat(products.filterByCategory(product3.getCategory()), hasItem(product3));
		assertThat(products.filterByCategory(product1.getCategory()), not(hasItem(product1)));
		
	}
}
