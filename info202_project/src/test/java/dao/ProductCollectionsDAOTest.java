/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.math.BigDecimal;
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
		item.setCategory("category");
		item.setDescription("description");
		item.setProductID("item");
		item.setProductName("Polkadot Widget");
		item.setListPrice(new BigDecimal(10));
		item.setQuantityInStock(new BigDecimal(5));
		stock = new domain.Product();
		stock.setCategory("category");
		stock.setDescription("description");
		stock.setProductID("item");
		stock.setProductName("Polkadot Widget");
		stock.setListPrice(new BigDecimal(10));
		stock.setQuantityInStock(new BigDecimal(5));
		
	}
	
	@AfterEach
	public void tearDown() {
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
