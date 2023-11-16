package com.example.baitapl1.reposiitory;

import com.example.baitapl1.Entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    List<Employee> findByCodeContainingAndNameContainingAllIgnoreCase (String code, String name);
}
