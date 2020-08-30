/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import domain.Product;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;

/**
 *
 * @author User
 */
public class ProductJdbcDAO implements ProductDAO {

	private String uri;

	public ProductJdbcDAO() {
		uri = dao.DbConnection.getDefaultConnectionUri();
	}

	public ProductJdbcDAO(String uri) {
		this.uri = uri;
	}

	@Override
	public void deleteProduct(Product p) {
		String sql = "delete from Product where productID = ?";
		try (
				  Connection dbCon = DbConnection.getConnection(uri);
				  PreparedStatement stmt = dbCon.prepareStatement(sql);) {
			stmt.setString(1, p.getProductID());
			stmt.executeUpdate();  // execute the statement

		} catch (SQLException ex) {  // we are forced to catch SQLException
			// don't let the SQLException leak from our DAO encapsulation
			throw new DAOException(ex.getMessage(), ex);
		}
	}

	@Override
	public Collection<Product> filterByCategory(String category) {
		String sql = "select * from Product where category = ?";
		try (
				  // get a connection to the database
				  Connection dbCon = DbConnection.getConnection(uri);
				  // create the statement
				  PreparedStatement stmt = dbCon.prepareStatement(sql);) {
			stmt.setString(1, category);
			// execute the query
			ResultSet rs = stmt.executeQuery();

			// Using a List to preserve the order in which the data was returned from the query.
			Collection<Product> product = new HashSet<>();

			// iterate through the query results
			while (rs.next()) {

				// get the data out of the query
				String productID = rs.getString("productID");
				String name = rs.getString("name");
				String description = rs.getString("description");
				String productcategory = rs.getString("category");
				BigDecimal listPrice = rs.getBigDecimal("listPrice");
				BigDecimal quantityInStock = rs.getBigDecimal("quantityInStock");

				// use the data to create a student object
				Product p = new Product(productID, name, description, productcategory, listPrice, quantityInStock);

				// and put it in the collection
				product.add(p);
			}

			return product;

		} catch (SQLException ex) {  // we are forced to catch SQLException
			// don't let the SQLException leak from our DAO encapsulation
			throw new DAOException(ex.getMessage(), ex);
		}
	}

	@Override
	public Collection<String> getCategories() {
		String sql = "select distinct category from Product order by category";
		try (
				  // get a connection to the database
				  Connection dbCon = DbConnection.getConnection(uri);
				  // create the statement
				  PreparedStatement stmt = dbCon.prepareStatement(sql);) {
			// execute the query
			ResultSet rs = stmt.executeQuery();

			// Using a List to preserve the order in which the data was returned from the query.
			Collection<String> categories = new HashSet<>();

			// iterate through the query results
			while (rs.next()) {

				// get the data out of the query
				String category = rs.getString("category");

				// and put it in the collection
				categories.add(category);
			}

			return categories;

		} catch (SQLException ex) {  // we are forced to catch SQLException
			// don't let the SQLException leak from our DAO encapsulation
			throw new DAOException(ex.getMessage(), ex);
		}
	}

	@Override
	public Collection<Product> getProducts() {
		String sql = "select * from Product order by productID";

		try (
				  // get a connection to the database
				  Connection dbCon = DbConnection.getConnection(uri);
				  // create the statement
				  PreparedStatement stmt = dbCon.prepareStatement(sql);) {
			// execute the query
			ResultSet rs = stmt.executeQuery();

			// Using a List to preserve the order in which the data was returned from the query.
			Collection<Product> product = new ArrayList<>();

			// iterate through the query results
			while (rs.next()) {

				// get the data out of the query
				String productID = rs.getString("productID");
				String name = rs.getString("name");
				String description = rs.getString("description");
				String category = rs.getString("category");
				BigDecimal listPrice = rs.getBigDecimal("listPrice");
				BigDecimal quantityInStock = rs.getBigDecimal("quantityInStock");

				// use the data to create a student object
				Product p = new Product(productID, name, description, category, listPrice, quantityInStock);

				// and put it in the collection
				product.add(p);
			}

			return product;

		} catch (SQLException ex) {  // we are forced to catch SQLException
			// don't let the SQLException leak from our DAO encapsulation
			throw new DAOException(ex.getMessage(), ex);
		}
	}

	@Override
	public void saveProduct(Product p) {
		String sql = "insert into Product (productID, name, description, category, listPrice, quantityInStock) values (?,?,?,?,?,?)";
		try (
				  Connection dbCon = DbConnection.getConnection(uri);
				  PreparedStatement stmt = dbCon.prepareStatement(sql);) {
			stmt.setString(1, p.getProductID());
			stmt.setString(2, p.getProductName());
			stmt.setString(3, p.getDescription());
			stmt.setString(4, p.getCategory());
			stmt.setBigDecimal(5, p.getListPrice());
			stmt.setBigDecimal(6, p.getQuantityInStock());

			stmt.executeUpdate();  // execute the statement

		} catch (SQLException ex) {  // we are forced to catch SQLException
			// don't let the SQLException leak from our DAO encapsulation
			throw new DAOException(ex.getMessage(), ex);
		}
	}

	@Override
	public Product searchByID(String id) {
		String sql = "select * from Product where productID = ?";

		try (
				  // get connection to database
				  Connection connection = DbConnection.getConnection(uri);
				  // create the statement
				  PreparedStatement stmt = connection.prepareStatement(sql);) {
			// set the parameter
			stmt.setString(1, id);

			// execute the query
			ResultSet rs = stmt.executeQuery();

			// query only returns a single result, so use 'if' instead of 'while'
			if (rs.next()) {
				String productID = rs.getString("productID");
				String name = rs.getString("name");
				String description = rs.getString("description");
				String category = rs.getString("category");
				BigDecimal listPrice = rs.getBigDecimal("listPrice");
				BigDecimal quantityInStock = rs.getBigDecimal("quantityInStock");

				return new Product(productID, name, description, category, listPrice, quantityInStock);

			} else {
				// no student matches given ID so return null
				return null;
			}

		} catch (SQLException ex) {  // we are forced to catch SQLException
			// don't let the SQLException leak from our DAO encapsulation
			throw new DAOException(ex.getMessage(), ex);
		}
	}
}
