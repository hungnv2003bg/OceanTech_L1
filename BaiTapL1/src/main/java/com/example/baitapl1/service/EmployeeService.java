package com.example.baitapl1.service;

import com.example.baitapl1.Entity.Employee;
import com.example.baitapl1.dto.EmployeeDTO;
import com.example.baitapl1.dto.EmployeeSearchDTO;
import com.example.baitapl1.reposiitory.EmployeeRepository;
import com.microsoft.sqlserver.jdbc.StringUtils;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Sheet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EmployeeService {
    @Autowired
    EmployeeRepository repository;

    public List<Employee> getAll(){
        return repository.findAll();
    }

    public List<Employee> searchEmployee(EmployeeSearchDTO eDto) {
        return repository.findByCodeContainingAndNameContainingAllIgnoreCase (
                eDto.getCode(), eDto.getName()
        );
    }

    public Employee add(Employee employee){
        return repository.save(employee);
    }

    public Employee update(Employee employee, Long id){
        Optional<Employee> employee1 =repository.findById(id);
        if(employee1.isPresent()){
            Employee upEmployee =employee1.get();
            upEmployee.setCode(employee.getCode());
            upEmployee.setName(employee.getName());
            upEmployee.setEmail(employee.getEmail());
            upEmployee.setPhone(employee.getPhone());
            upEmployee.setAge(employee.getAge());
            return repository.save(upEmployee);
        }
        else {
            throw new RuntimeException("khong co Employee");
        }
    }

    public Boolean delete(Long id){
        Optional<Employee> employee1 =repository.findById(id);
        if(employee1.isPresent()){
            Employee employee = employee1.get();
            repository.delete(employee);
            return true;
        }else {
            return false;
        }
    }
//Export Excel
    public void generateExel(HttpServletResponse response) throws IOException {
        List<Employee> employees = repository.findAll();

        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet("Employ Info");
        HSSFRow row = sheet.createRow(0);
        row.createCell(0).setCellValue("STT");
        row.createCell(1).setCellValue("Id");
        row.createCell(2).setCellValue("Code");
        row.createCell(3).setCellValue("Name");
        row.createCell(4).setCellValue("Email");
        row.createCell(5).setCellValue("Phone");
        row.createCell(6).setCellValue("Age");

        int dataRowIndex = 1;
        for(Employee employee : employees){
            HSSFRow dataRow = sheet.createRow(dataRowIndex);

            dataRow.createCell(0).setCellValue(dataRowIndex);
            dataRow.createCell(1).setCellValue(employee.getId() != null ? employee.getId().toString() : "");
            dataRow.createCell(2).setCellValue(employee.getCode() != null ? employee.getCode() : "");
            dataRow.createCell(3).setCellValue(employee.getName() != null ? employee.getName() : "");
            dataRow.createCell(4).setCellValue(employee.getEmail() != null ? employee.getEmail() : "");
            dataRow.createCell(5).setCellValue(employee.getPhone() != null ? employee.getPhone() : "");
            dataRow.createCell(6).setCellValue(employee.getAge() != null ? employee.getAge().toString() : "");

            dataRowIndex++;
        }
        ServletOutputStream ops = response.getOutputStream();
        workbook.write(ops);
        workbook.close();
        ops.close();

    }


}
