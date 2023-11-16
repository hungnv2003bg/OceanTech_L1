package com.example.baitapl1.controller;


import com.example.baitapl1.dto.MyFirstApiDto;
import com.example.baitapl1.service.MyFirstApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class MyFirstApiController {
    @Autowired
    private MyFirstApiService myFirstApiService;

    @PostMapping("/myfirstapi")
    public MyFirstApiDto myFirstApi(@RequestBody MyFirstApiDto myFirstApiDto) {
        return myFirstApiDto;
    }
}