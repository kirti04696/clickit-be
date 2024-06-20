package com.clickit.service;

import com.clickit.dao.OrderDao;
import com.clickit.dao.UserDao;
import com.clickit.model.Order;
import com.clickit.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    @Autowired
    private OrderDao orderDao;

    @Autowired
    private UserDao userDao;

    public Order saveOrder(Order order) {
        return orderDao.save(order);
    }

    public List<Order> getOrdersByUserId(Long userId) {
        User user = userDao.findById(userId).get();
        return orderDao.findByUserOrderByOrderDateDesc(user);
    }
}
