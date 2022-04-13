package com.example.demo.controller;

import com.example.demo.model.Item;
import com.example.demo.repository.ItemRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/items")
public class ItemController {


    @Autowired
    ItemRepo itemRepo;

    @RequestMapping("/{name}")
    public Item getItemByName(@PathVariable String name){
        return itemRepo.findItemByName(name);
    }

    @RequestMapping("")
    public Iterable<Item> getAllItems(){
        return itemRepo.findAll();
    }

    @PostMapping("/add")
    public String addItem(@RequestBody Item item){
        itemRepo.save(item);
        return "Item added";
    }
}
