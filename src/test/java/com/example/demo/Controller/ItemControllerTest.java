package com.example.demo.Controller;

import com.example.demo.model.Customer;
import com.example.demo.model.Item;
import com.example.demo.repository.CustomerRepo;
import com.example.demo.repository.ItemRepo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Arrays;
import java.util.Optional;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
@AutoConfigureMockMvc
@SpringBootTest
class ItemControllerTest {

    @MockBean
    private ItemRepo itemRepo;


    @BeforeEach
    public void init(){
        Item i1 = new Item(1L, "Gräsklippare" , "-2020");
        when(itemRepo.findItemByName("Gräsklippare")).thenReturn(i1);

    }
    @Autowired
    private MockMvc mvc;

    @Test
    void getItemByName() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/items/name").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json("{\"id\":1,\"name\":\"Gräsklippare\",\"articleNr\":\"-2020\"}"));
    }
}