package com.example.baitapl1.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor
public class EmployeeDTO {
    private Long id;
    private String code;
    private String name;
    private String email;
    private String phone;
    private Long age;
}
