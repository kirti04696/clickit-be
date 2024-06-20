package com.clickit.controller;

import com.clickit.common.Response;
import com.clickit.model.Order;
import com.clickit.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @PostMapping("/place-order")
    public Order placeOrder(@RequestBody Order order){
        Order order1=orderService.saveOrder(order);
        return order1;
    }

    @GetMapping("/get-orders/{user-id}")
    public ResponseEntity<Object> getAllOrders(@PathVariable("user-id") Long userId){
        List<Order> orders = orderService.getOrdersByUserId(userId);
        Response response = new Response();
        response.setData(orders);
        response.setStatus(HttpStatus.OK);
        return response.sendResponse();

    }
}
