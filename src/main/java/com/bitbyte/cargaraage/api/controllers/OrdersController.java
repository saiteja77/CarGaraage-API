package com.bitbyte.cargaraage.api.controllers;

import com.bitbyte.cargaraage.api.entities.Order;
import com.bitbyte.cargaraage.api.services.AuthorizationService;
import com.bitbyte.cargaraage.api.services.OrderService;
import com.bitbyte.cargaraage.api.services.PaymentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@CrossOrigin
public class OrdersController {

    private static final Logger LOG = LoggerFactory.getLogger(OrdersController.class);

    @Autowired
    private OrderService orderService;

    @Autowired
    private AuthorizationService authorizationService;

    @Autowired
    private PaymentService paymentService;

    @PostMapping("/orders")
    public ResponseEntity<Long> saveOrder(@RequestHeader("access-token") String token, @RequestBody Order order){
        try {
            if(authorizationService.isAuthorized(token, "USER")){
                if(paymentService.authorizePayment(order.getPayment())){
                    Long orderId = orderService.saveNewOrder(order);
                    return new ResponseEntity<>(orderId, HttpStatus.CREATED);
                } else
                    throw new ResponseStatusException(HttpStatus.NOT_FOUND);
            } else {
                LOG.error("Unauthorized request for new Order");
                throw new ResponseStatusException(HttpStatus.UNAUTHORIZED);
            }
        } catch (Exception e){
            LOG.error(e.getMessage());
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
