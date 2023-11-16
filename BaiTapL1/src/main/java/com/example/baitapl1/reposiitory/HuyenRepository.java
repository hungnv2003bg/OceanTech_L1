package com.example.baitapl1.reposiitory;

import com.example.baitapl1.Entity.Huyen;
import com.example.baitapl1.Entity.Tinh;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HuyenRepository extends JpaRepository<Huyen, Long> {
    List<Huyen> findByIdContainingAllIgnoreCase (Long id);
}
