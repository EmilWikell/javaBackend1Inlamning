package com.example.demo.controller;

import com.example.demo.model.CustomerOrder;
import com.example.demo.repository.CustomerOrderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class CustomerOrderController {

    @Autowired
    CustomerOrderRepo customerOrderReop;

    @RequestMapping("")
    public Iterable<CustomerOrder> getAllCustomerOrders() {
        return customerOrderReop.findAll();
    }

    @RequestMapping("/{customerId}")
    public List<CustomerOrder> getAllCustomerOrdersByCustomerId(@PathVariable Long customerId){
        return customerOrderReop.findByCustomerId(customerId);
    }
}
