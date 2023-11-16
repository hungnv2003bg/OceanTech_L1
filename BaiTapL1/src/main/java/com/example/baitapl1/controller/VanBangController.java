package com.example.baitapl1.controller;

import com.example.baitapl1.Entity.VanBang;
import com.example.baitapl1.Entity.Xa;
import com.example.baitapl1.service.VanBangService;
import com.example.baitapl1.service.XaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("van-bang")
public class VanBangController {
    @Autowired
    VanBangService service;

    @GetMapping("/hien-thi")
    public ResponseEntity<?> getAll(){
        return ResponseEntity.ok(service.getAllVanBang());
    }

    @PostMapping("/search")
    public ResponseEntity<List<VanBang>> searchVanBang(@RequestBody VanBang vanBang) {
        List<VanBang> vanBangList = service.searchVanBang(vanBang);
        return ResponseEntity.ok(vanBangList);
    }

    @PostMapping("add")
    public ResponseEntity<?> add( @RequestBody VanBang vanBang){
        return ResponseEntity.ok(service.add(vanBang));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody VanBang vanBang){
        return ResponseEntity.ok(service.update(vanBang, id));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        return ResponseEntity.ok(service.delete(id));
    }
}
