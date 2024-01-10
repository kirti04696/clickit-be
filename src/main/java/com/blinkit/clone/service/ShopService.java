package com.blinkit.clone.service;

import com.blinkit.clone.dao.ShopDao;
import com.blinkit.clone.model.Shop;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShopService {

    @Autowired
    private ShopDao shopDao;

    public Shop addShop(Shop shop) {
        shopDao.save(shop);
        return shop;
    }

    public Shop getById(Integer shopId){
        Shop shop = shopDao.getOne(shopId);
        return shop;
    }
}
