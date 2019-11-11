package com.bitbyte.cargaraage.api.services;

import com.bitbyte.cargaraage.api.entities.Order;
import com.bitbyte.cargaraage.api.entities.OrderDetails;
import com.bitbyte.cargaraage.api.entities.User;
import com.bitbyte.cargaraage.api.repositories.OrderDetailsRepository;
import com.bitbyte.cargaraage.api.repositories.OrderRepository;
import com.bitbyte.cargaraage.api.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private OrderDetailsRepository orderDetailsRepository;

    public Long saveNewOrder(Order order){
        Long userId = order.getUserId();
        Optional<User> user = userRepository.findById(userId);
        order.setUser(user.get());
        Order savedOrder = orderRepository.save(order);
        Set<OrderDetails> orderDetailsSet = order.getOrderDetails();
        orderDetailsSet.forEach(orderDetails -> {
            orderDetails.setOrderId(savedOrder.getId());
            orderDetails.setUserId(savedOrder.getUserId());
        });
        orderDetailsRepository.saveAll(orderDetailsSet);
        return savedOrder.getId();
    }
}
