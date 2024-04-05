package com.example.Oder.contronllers;

import com.example.Oder.models.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;
import com.example.Oder.services.OrderSevice;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class OrderContronller {
    @Autowired
    private OrderSevice orderSevice;

    @GetMapping("/orders")
    @Cacheable(cacheNames = "cache1", key = "'orders'")
    public List<Order> getAlOrders(){
        return orderSevice.getAllOrders();
    }


    @GetMapping("/orders/{id}")
    @Cacheable(value = "order", key = "#id")
    public Order getUserById(@PathVariable(value = "id") long id){
        return orderSevice.getOrderId(id);
    }

    @PostMapping("/orders")
    @CachePut(value = "order", key = "#result.id")
    public Order addOrder(@RequestBody Order order) {
        return orderSevice.addOrder(order);
    }

    @DeleteMapping("/orders/{orderId}")
    @CacheEvict(value = "order")
    public void deleteOrder(@PathVariable(value = "orderId") long orderId){
        orderSevice.deleteOrder(orderId);
    }
}
