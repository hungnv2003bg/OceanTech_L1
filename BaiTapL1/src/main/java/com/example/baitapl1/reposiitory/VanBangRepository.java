package com.example.baitapl1.reposiitory;

import com.example.baitapl1.Entity.Tinh;
import com.example.baitapl1.Entity.VanBang;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VanBangRepository extends JpaRepository<VanBang,Long> {
    List<VanBang> findByIdContainingAllIgnoreCase (Long id);
}
