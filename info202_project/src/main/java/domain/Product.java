/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.math.BigDecimal;
import java.util.Objects;
import net.sf.oval.constraint.Length;
import net.sf.oval.constraint.NotBlank;
import net.sf.oval.constraint.NotNegative;
import net.sf.oval.constraint.NotNull;

/**
 *
 * @author teewa743
 */
public class Product {

    @NotNull(message = "Product ID must be provided.")
    @NotBlank(message = "Product ID must be provided.")
    private String productID;
    @NotNull(message = "Name must be provided.")
    @NotBlank(message = "Name must be provided.")
    @Length(min = 2, message = "Name must contain at least two characters.")
    private String name;
    @NotNull(message = "Description must be provided.")
    @NotBlank(message = "Description must be provided.")
    private String description;
    @NotNull(message = "Category must be provided.")
    @NotBlank(message = "Category must be provided.")
    private String category;
    @NotNull(message = "Price must be provided.")
    @NotNegative(message = "Price must be zero or greater.")
    private BigDecimal list_price;
    @NotNull(message = "Stock Quantity must be provided.")
    @NotNegative(message = "Stock Quantity must be zero or greater.")
    private BigDecimal quantity_in_stock;

    public Product() {
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 43 * hash + Objects.hashCode(this.productID);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Product other = (Product) obj;
        if (!Objects.equals(this.productID, other.productID)) {
            return false;
        }
        return true;
    }

    public Product(String productID, String name, String description, String category, BigDecimal list_price, BigDecimal quantity_in_stock) {
        this.productID = productID;
        this.name = name;
        this.description = description;
        this.category = category;
        this.list_price = list_price;
        this.quantity_in_stock = quantity_in_stock;
    }

    public String getProductID() {
        return productID;
    }

    public String getProductName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getCategory() {
        return category;
    }

    public BigDecimal getListPrice() {
        return list_price;
    }

    public BigDecimal getQuantityInStock() {
        return quantity_in_stock;
    }

    public void setProductID(String productID) {
        this.productID = productID;
    }

    public void setProductName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setListPrice(BigDecimal list_price) {
        this.list_price = list_price;
    }

    public void setQuantityInStock(BigDecimal quantity_in_stock) {
        this.quantity_in_stock = quantity_in_stock;
    }

    @Override
    public String toString() {
        return "Product ID= " + productID + ", name= " + name;
    }

}
