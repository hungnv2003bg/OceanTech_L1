package com.example.baitapl1.reposiitory;

import com.example.baitapl1.Entity.Tinh;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TinhRepository extends JpaRepository<Tinh,Long> {
    List<Tinh> findByIdContainingAllIgnoreCase (Long id);

}
