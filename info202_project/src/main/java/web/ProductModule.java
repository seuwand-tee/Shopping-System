/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web;

import org.jooby.Jooby;

/**
 *
 * @author User
 */
public class ProductModule extends Jooby {

	final dao.ProductDAO productsList;

	public ProductModule(dao.ProductDAO productsList) {
		this.productsList = new dao.ProductJdbcDAO();
		get("/api/products", () -> productsList.getProducts());
		get("/api/products/:id", (req) -> {
			String id = req.param("id").value();
			return productsList.searchByID(id);
		});
                get("/api/categories", () -> productsList.getCategories());
		get("/api/categories/:category", (req) -> {
			String category = req.param("category").value();
			return productsList.filterByCategory(category);
		});
	}
}
