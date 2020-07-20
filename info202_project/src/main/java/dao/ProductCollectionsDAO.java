/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import domain.Product;
import java.util.ArrayList;
import java.util.Collection;

/**
 *
 * @author teewa743
 */
public class ProductCollectionsDAO {
	private static Collection<domain.Product> products= new ArrayList<domain.Product>();


public void saveProduct(Product p){
	products.add(p);
}

public Collection<domain.Product> getProduct(){
return products;
}

public void deleteProduct(Product p){
	products.remove(p);
}
}