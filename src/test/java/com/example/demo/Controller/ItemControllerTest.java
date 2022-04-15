package com.example.demo.Controller;

import com.example.demo.model.Customer;
import com.example.demo.model.CustomerOrder;
import com.example.demo.model.Item;
import com.example.demo.repository.CustomerOrderRepo;
import com.example.demo.repository.CustomerRepo;
import com.example.demo.repository.ItemRepo;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Optional;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@SpringBootTest
class ItemControllerTest {

    @MockBean
    private ItemRepo itemRepo;
    @MockBean
    private CustomerRepo customerRepo;
    @MockBean
    private CustomerOrderRepo customerOrderRepo;


    @BeforeEach
    public void init(){
        Item i1 = new Item(1L, "Gräsklippare" , "-2020");
        Customer c1 = new Customer(1L, "Magnus" , "Gatan 3");
        when(itemRepo.findItemByName("Gräsklippare")).thenReturn(i1);
        when(itemRepo.findById(1L)).thenReturn(Optional.of(i1));
        when(customerRepo.findById(1L)).thenReturn(Optional.of(c1));
    }
    @Autowired
    private MockMvc mvc;

    @Test
    void getItemByName() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/items/Gräsklippare").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json("{\"id\":1,\"name\":\"Gräsklippare\",\"articleNr\":\"-2020\"}"));
    }


    @Test
    void buyItemTestSuccessEndpoint() throws Exception {
        mvc.perform(MockMvcRequestBuilders
                        .post("/items/buy")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"customer\":1,\"item\": 1}"))
                .andExpect(MockMvcResultMatchers.status().isCreated())
                .andExpect(MockMvcResultMatchers.header().exists("Location"))
                .andExpect(MockMvcResultMatchers.header().string("Location", Matchers.containsString("0")));
    }
    @Test
    void buyItemTestFailedEndpoint() throws Exception {
        mvc.perform(MockMvcRequestBuilders
                        .post("/items/buy")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"customer\":2,\"item\": 1}"))
                .andExpect(MockMvcResultMatchers.status().isCreated())
                .andExpect(MockMvcResultMatchers.header().exists("Location"))
                .andExpect(MockMvcResultMatchers.header().string("Location", Matchers.containsString("failed")));
    }
}