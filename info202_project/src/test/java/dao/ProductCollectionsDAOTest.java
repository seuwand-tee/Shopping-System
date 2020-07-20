/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author teewa743
 */
public class ProductCollectionsDAOTest {
	private domain.Product product;
	private domain.Product item;
	private domain.Product stock;
	private static Collection<domain.Product> items = new ArrayList<domain.Product>();
	
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
		items.add(item);
		items.add(stock);
		
	}
	
	@AfterEach
	public void tearDown() {
		items.remove(item);
		items.remove(stock);
	}

	@Test
	public void testSaveProduct() {
		fail();
	}

	@Test
	public void testGetProduct() {
		fail();
	}

	@Test
	public void testDeleteProduct() {
		fail();
	}
	
}
