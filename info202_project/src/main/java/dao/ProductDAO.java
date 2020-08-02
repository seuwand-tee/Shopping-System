/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import domain.Product;
import java.util.Collection;

/**
 *
 * @author User
 */
public interface ProductDAO {

    void deleteProduct(Product p);

    Collection<Product> filterByCategory(String category);

    Collection<String> getCategories();

    Collection<Product> getProducts();

    void saveProduct(Product p);

    Product searchByID(String id);
    
}
