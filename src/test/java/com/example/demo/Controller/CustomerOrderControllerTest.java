package com.example.demo.Controller;

import com.example.demo.model.Customer;
import com.example.demo.model.CustomerOrder;
import com.example.demo.model.Item;
import com.example.demo.repository.CustomerOrderRepo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;

@AutoConfigureMockMvc
@SpringBootTest
class CustomerOrderControllerTest {

    @MockBean
    private CustomerOrderRepo customerOrderRepo;

    @Autowired
    private MockMvc mvc;

    @BeforeEach
    private void init(){
        Customer customer = new Customer("Lena" , "Bron4");

        Item item1 = new Item("Spik","2021");
        Item item2 = new Item("Slägga","2022");

        CustomerOrder customerOrder1 = new CustomerOrder("1011", customer,item1);
        CustomerOrder customerOrder2 = new CustomerOrder("1012", customer,item2);



    }

    @Test
    void getAllCustomerOrders() {
    }

    @Test
    void getAllCustomerOrdersByCustomerId() {
    }
}