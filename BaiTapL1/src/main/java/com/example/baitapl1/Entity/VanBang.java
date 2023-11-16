package com.example.baitapl1.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.*;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Entity
@Table(name = "VanBang")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class VanBang {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String loaiVanBang;

    private Date thoiGianBatDau;

    private Date thoiGianKetThuc;
}
