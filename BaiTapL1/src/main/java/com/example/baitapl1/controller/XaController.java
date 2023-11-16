package com.example.baitapl1.controller;

import com.example.baitapl1.Entity.Xa;
import com.example.baitapl1.service.HuyenService;
import com.example.baitapl1.service.XaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("xa")
public class XaController {
    @Autowired
    XaService service;

    @GetMapping("/hien-thi")
    public ResponseEntity<?> getAll(){
        return ResponseEntity.ok(service.getAll());
    }

    @PostMapping("/search")
    public ResponseEntity<List<Xa>> searchXa(@RequestBody Xa xa) {
        List<Xa> xaList = service.searchXa(xa);
        return ResponseEntity.ok(xaList);
    }

    @PostMapping("add")
    public ResponseEntity<?> add( @RequestBody Xa xa){
        return ResponseEntity.ok(service.add(xa));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody Xa xa){
        return ResponseEntity.ok(service.update(xa, id));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        return ResponseEntity.ok(service.delete(id));
    }
}
