package com.example.baitapl1.controller;

import com.example.baitapl1.Entity.Employee;
import com.example.baitapl1.Entity.Tinh;
import com.example.baitapl1.dto.EmployeeSearchDTO;
import com.example.baitapl1.service.EmployeeService;
import com.example.baitapl1.service.TinhService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("tinh")
public class TinhController {
    @Autowired
    TinhService service;

    @GetMapping("/hien-thi")
    public ResponseEntity<?> getAll(){
        return ResponseEntity.ok(service.getAll());
    }

    @PostMapping("/search")
    public ResponseEntity<List<Tinh>> searchTinh(@RequestBody Tinh tinh) {
        List<Tinh> employee = service.searchTinh(tinh);
        return ResponseEntity.ok(employee);
    }

    @PostMapping("add")
    public ResponseEntity<?> add( @RequestBody Tinh tinh){
        return ResponseEntity.ok(service.add(tinh));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Tinh> update(@PathVariable Long id, @RequestBody Tinh tinh) {
        return ResponseEntity.ok(service.update(tinh, id));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        return ResponseEntity.ok(service.delete(id));
    }

}
