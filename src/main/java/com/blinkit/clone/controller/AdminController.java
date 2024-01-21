package com.blinkit.clone.controller;

import com.blinkit.clone.common.Response;
import com.blinkit.clone.model.Shop;
import com.blinkit.clone.model.User;
import com.blinkit.clone.service.ShopService;
import com.blinkit.clone.service.UserService;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.bind.DefaultValue;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private ShopService shopService;

    @Autowired
    private UserService userService;


    @GetMapping("/shops")
    public ResponseEntity<Object> getAllShops(){
        Response response = new Response();
        List<Shop> shops = shopService.getAllShops();

        response.setData(shops);
        response.setStatus(HttpStatus.OK);
        return response.sendResponse();

    }

    @GetMapping("/users")
    public ResponseEntity<Object> getAllUser(){
        Response response = new Response();
        List<User> users = userService.getUserByType(Arrays.asList("USER"));

        response.setData(users);
        response.setStatus(HttpStatus.OK);
        return response.sendResponse();

    }

    @PutMapping("/shop/{shopId}")
    public ResponseEntity<Object> updateShopStatus(@PathVariable Integer shopId, @DefaultValue("DECLINED") @PathParam("status") String status){
        Shop shop = shopService.updateShopStatus(shopId, status);
        return new Response(shop,"Shop status updated.", HttpStatus.OK).sendResponse();
    }

}
