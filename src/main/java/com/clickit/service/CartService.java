package com.clickit.service;

import com.clickit.dao.CartDao;
import com.clickit.model.Cart;
import com.clickit.model.Product;
import com.clickit.model.ProductVariety;
import com.clickit.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CartService {

    @Autowired
    CartDao cartDao;

    @Autowired
    ProductService productService;

    @Autowired
    UserService userService;


    @Autowired
    ProductVarietyService varietyService;

    public List<Cart>getAllCartItem(){
        return cartDao.findAll();
    }
    public List<Cart>getUserCartItems(User user){
        return cartDao.findByUser(user);
    }
    public Cart addToCart(Cart cart){
        User user=userService.getUserById(cart.getUser().getUserId());
        Product product=productService.getProductById(cart.getProduct().getProductId());
        ProductVariety variety=varietyService.getProductVarietyById(cart.getProductVarity().getProductVarietyId());
        cart.setProduct(product);
        cart.setUser(user);
        cart.setProductVarity(variety);
        cartDao.save(cart);
        return cart;
    }
}
