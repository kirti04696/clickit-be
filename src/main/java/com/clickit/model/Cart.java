package com.clickit.model;

import jakarta.persistence.*;
import org.springframework.boot.autoconfigure.web.WebProperties;

import java.lang.reflect.Type;

@Entity
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int cartId;

    @OneToOne(cascade = CascadeType.MERGE)
    private Product product;

    @OneToOne(cascade = CascadeType.MERGE)
    private ProductVariety productVarity;

    private int quantity;

    @OneToOne(cascade = CascadeType.MERGE)
    private User user;

    public Cart() {
    }

    public Cart(int cartId, Product product, ProductVariety productVarity, int quantity, User user) {
        this.cartId = cartId;
        this.product = product;
        this.productVarity = productVarity;
        this.quantity = quantity;
        this.user = user;
    }

    public int getCartId() {
        return cartId;
    }

    public void setCartId(int cartId) {
        this.cartId = cartId;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public ProductVariety getProductVarity() {
        return productVarity;
    }

    public void setProductVarity(ProductVariety productVarity) {
        this.productVarity = productVarity;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "cartId=" + cartId +
                ", product=" + product +
                ", productVarity=" + productVarity +
                ", quantity=" + quantity +
                ", user=" + user +
                '}';
    }
}
