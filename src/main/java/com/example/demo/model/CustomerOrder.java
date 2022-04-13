package com.example.demo.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Iterator;

@Entity
@Data
public class CustomerOrder {

    @GeneratedValue
    @Id
    private long Id;
    private String orderNr;

    @ManyToOne
    @JoinColumn
    private Customer customer;

    @ManyToOne
    @JoinColumn
    private Item item;

    public CustomerOrder(long id, String orderNr, Customer customer, Item item) {
        this.Id = id;
        this.orderNr = orderNr;
        this.customer = customer;
        this.item = item;
    }

    public CustomerOrder(String orderNr, Customer customer, Item item) {
        this.orderNr = orderNr;
        this.customer = customer;
        this.item = item;
    }

    public CustomerOrder() {

    }


}
