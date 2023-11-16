package com.example.baitapl1.controller;

import com.example.baitapl1.Entity.Huyen;
import com.example.baitapl1.service.HuyenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("huyen")
public class HuyenController {
    @Autowired
    HuyenService service;

    @GetMapping("/hien-thi")
    public ResponseEntity<?> getAll(){
        return ResponseEntity.ok(service.getAll());
    }

    @PostMapping("/search")
    public ResponseEntity<List<Huyen>> searchHuyen(@RequestBody Huyen huyen) {
        List<Huyen> huyenList = service.searchHuyen(huyen);
        return ResponseEntity.ok(huyenList);
    }

    @PostMapping("add")
    public ResponseEntity<?> add( @RequestBody Huyen huyen){
        return ResponseEntity.ok(service.add(huyen));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody Huyen huyen){
        return ResponseEntity.ok(service.update(huyen, id));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        return ResponseEntity.ok(service.delete(id));
    }
}

