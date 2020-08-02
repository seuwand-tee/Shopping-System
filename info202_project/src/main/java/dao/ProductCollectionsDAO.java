/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;
import domain.Product;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 *
 * @author teewa743
 */
public class ProductCollectionsDAO implements ProductDAO {

	private static Collection<domain.Product> products = new HashSet<>();
	private static Collection<String> categories = new HashSet<>();
	private static Map<String, domain.Product> productID = new HashMap<>();
	private static Multimap<String,domain.Product> productCategory = HashMultimap.create();


    @Override
	public void saveProduct(Product p) {
		products.add(p);
		categories.add(p.getCategory());
		productID.put(p.getProductID(), p);
		productCategory.put(p.getCategory(), p);
	}

    @Override
	public Collection<domain.Product> getProducts() {
		return products;
	}

    @Override
	public void deleteProduct(Product p) {
		products.remove(p);
	}

    @Override
	public Collection<String> getCategories() {
		return categories;
	}
	
    @Override
	public domain.Product searchByID(String id){
		if (productID.containsKey(id)){
		return productID.get(id);
		}
		return null;	
}
    @Override
	public Collection<domain.Product> filterByCategory(String category){
			return productCategory.get(category);
		}
	}
