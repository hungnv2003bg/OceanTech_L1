package com.example.baitapl1.controller;

import com.example.baitapl1.Entity.Employee;
import com.example.baitapl1.dto.EmployeeSearchDTO;
import com.example.baitapl1.service.EmployeeService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("employee")
public class EmployeeController {
    @Autowired
    EmployeeService eService;

    @GetMapping("/hien-thi")
    public ResponseEntity<?> getAll(){
        return ResponseEntity.ok(eService.getAll());
    }

    @PostMapping("/search")
    public ResponseEntity<List<Employee>> searchEmployee(@RequestBody EmployeeSearchDTO eDto) {
        List<Employee> employee = eService.searchEmployee(eDto);
        return ResponseEntity.ok(employee);
    }

    @PostMapping("add")
    public ResponseEntity<?> add( @RequestBody Employee employee){
        return ResponseEntity.ok(eService.add(employee));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody Employee employee){
        return ResponseEntity.ok(eService.update(employee, id));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        return ResponseEntity.ok(eService.delete(id));
    }

    @GetMapping("/excel")
    public void generateExcelReport(HttpServletResponse response) throws IOException {
        response.setContentType("application/octet-strean");
        String headerKey = "Content-Disposition";
        String headerValue = "attachment;filename=employees.xls";
        response.setHeader(headerKey,headerValue);
        eService.generateExel(response);
    }
}
