package com.example.demo.repository;

import com.example.demo.model.CustomerOrder;
import org.springframework.data.repository.CrudRepository;

public interface CustomerOrderRepo extends CrudRepository<CustomerOrder, Long> {
}
