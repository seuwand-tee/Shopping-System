/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.ArrayList;

/**
 *
 * @author teewa743
 */
public class ProductCollectionsDAO {
	private static Collection<domain.Product> products= new ArrayList<domain.Product>();
	private static domain.Product item = new domain.Product();

public static void saveProduct(){
	products.add();
}

public ArrayList getProduct(){
return products;
}

public static void deleteProduct(){
	products.remove();
}
}