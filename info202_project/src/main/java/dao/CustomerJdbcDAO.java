/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import domain.Customer;
import helpers.ScryptHelper;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author User
 */
public class CustomerJdbcDAO implements CustomerDAO {

    private String uri;
	

    public CustomerJdbcDAO() {
        uri = dao.DbConnection.getDefaultConnectionUri();
    }

    public CustomerJdbcDAO(String uri) {
        this.uri = uri;
    }

    @Override
    public Customer getCustomer(String username) {
        String sql = "select * from Customer where username = ?";

        try (
                // get a connection to the database
                 Connection dbCon = DbConnection.getConnection(uri); // create the statement
                  PreparedStatement stmt = dbCon.prepareStatement(sql);) {
            stmt.setString(1, username);
// execute the query
            ResultSet rs = stmt.executeQuery();

            // iterate through the query results
            if (rs.next()) {

                // get the data out of the query
                Integer customer_id = rs.getInt("customer_id");
                //String username = rs.getString("username");
                String firstname = rs.getString("firstname");
                String surname = rs.getString("surname");
                String password = rs.getString("password");
                String email_address = rs.getString("email_address");
                String shipping_address = rs.getString("shipping_address");

                // use the data to create a student object
                Customer c = new Customer(customer_id, username, firstname, surname, password, email_address, shipping_address);

                // and put it in the collection
                return c;
            } else {
                return null;
            }

        } catch (SQLException ex) {  // we are forced to catch SQLException
            // don't let the SQLException leak from our DAO encapsulation
            throw new DAOException(ex.getMessage(), ex);
        }
    }

    @Override
    public void saveCustomer(Customer customer) {
		  String hash = ScryptHelper.hash(customer.getPassword()).toString();
        String sql = "insert into Customer (username, firstname, surname, password, email_address, shipping_address) values (?,?,?,?,?,?)";
        try (
                 Connection dbCon = DbConnection.getConnection(uri);  PreparedStatement stmt = dbCon.prepareStatement(sql);) {
            stmt.setString(1, customer.getUsername());
            stmt.setString(2, customer.getFirstname());
            stmt.setString(3, customer.getSurname());
            stmt.setString(4, hash);
            stmt.setString(5, customer.getEmail_address());
            stmt.setString(6, customer.getShipping_address());

            stmt.executeUpdate();  // execute the statement

        } catch (SQLException ex) {  // we are forced to catch SQLException
            // don't let the SQLException leak from our DAO encapsulation
            throw new DAOException(ex.getMessage(), ex);
        }
    }

    @Override
    public Boolean validateCredentials(String username, String password) {
        String sql = "select * from Customer where username = ? and password = ?";

        try (
                // get a connection to the database
                 Connection dbCon = DbConnection.getConnection(uri); // create the statement
                  PreparedStatement stmt = dbCon.prepareStatement(sql);) {
            stmt.setString(1, username);
           
            ResultSet rs = stmt.executeQuery();
				if (rs.next()) {
         String hash = rs.getString("password");

         // check that the password matches the hash
         return ScryptHelper.check(hash, password);
      } else {
         // no matching username
         return false;
      }

        } catch (SQLException ex) {  // we are forced to catch SQLException
            // don't let the SQLException leak from our DAO encapsulation
            throw new DAOException(ex.getMessage(), ex);
        }
    }

}
