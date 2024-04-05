package com.example.Oder.services;

import com.example.Oder.models.Order;
import com.example.Oder.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.Oder.repositories.OrderRepositoty;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class OrderSevice {
    private final OrderRepositoty orderRepositoty;
    private final RestTemplate restTemplate;
    @Autowired
    public OrderSevice(OrderRepositoty orderRepositoty, RestTemplate restTemplate) {
        this.orderRepositoty = orderRepositoty;
        this.restTemplate = restTemplate;
    }

    public List<Order> getAllOrders(){
       List<Order> list = orderRepositoty.findAll();
        for (Order o: list){
            User user = restTemplate.getForObject("http://localhost:8084/api/v3/users/"+o.getId(), User.class );
            o.setUser(user);
        }
        return list;
    }


    public Order getOrderId(long id){
        Order order = orderRepositoty.findById(id).get();
        User user = restTemplate.getForObject("http://localhost:8084/api/v3/users/"+order.getId(), User.class );
        order.setUser(user);
        return order;
    }

    public Order addOrder(Order order){
        return orderRepositoty.save(order);
    }

    public void deleteOrder(long id){
        orderRepositoty.deleteById(id);
    }
}
