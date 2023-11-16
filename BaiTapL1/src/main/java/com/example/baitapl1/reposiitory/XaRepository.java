package com.example.baitapl1.reposiitory;

import com.example.baitapl1.Entity.Tinh;
import com.example.baitapl1.Entity.Xa;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface XaRepository extends JpaRepository<Xa,Long> {
    List<Xa> findByIdContainingAllIgnoreCase (Long id);
}
