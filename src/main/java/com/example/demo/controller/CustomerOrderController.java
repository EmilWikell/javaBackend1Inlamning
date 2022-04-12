package com.example.demo.controller;

import com.example.demo.model.CustomerOrder;
import com.example.demo.repository.CustomerOrderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")
public class CustomerOrderController {

    @Autowired
    CustomerOrderRepo customerOrderReop;

    @RequestMapping("")
    public Iterable<CustomerOrder> getAllCustomerOrders() {
        return customerOrderReop.findAll();
    }
}
