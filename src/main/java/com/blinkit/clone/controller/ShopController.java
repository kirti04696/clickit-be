package com.blinkit.clone.controller;

import com.blinkit.clone.common.Response;
import com.blinkit.clone.model.Shop;
import com.blinkit.clone.model.User;
import com.blinkit.clone.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController()
@RequestMapping("/shop")
public class ShopController {

    @Autowired
    private ShopService shopService;

    @PostMapping(value = "/register")
    public ResponseEntity<Object> registerShop(@RequestBody Shop shop, @RequestBody User shopOwner){
        Response response = new Response();
        try{
            shop.setShopStatus("PENDING");
            shopService.addShop(shop);
            response.setData(shop);
        }catch (Exception e){
            response.setMessage(e.getMessage());
            response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return response.sendResponse();
    }

    @GetMapping(value = "/{shopId}")
    public ResponseEntity<Object> getShopById(@PathVariable Integer shopId){
        Response response = new Response();
        try{
            Shop shop = shopService.getById(shopId);
            response.setData(shop);
        }catch (Exception e){
            response.setMessage(e.getMessage());
            response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return response.sendResponse();
    }
}
