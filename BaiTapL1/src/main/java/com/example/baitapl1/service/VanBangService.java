package com.example.baitapl1.service;

import com.example.baitapl1.Entity.VanBang;
import com.example.baitapl1.Entity.Xa;
import com.example.baitapl1.reposiitory.VanBangRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VanBangService {
    @Autowired
    private VanBangRepository vanBangRepository;

    public List<VanBang> getAllVanBang() {
        return vanBangRepository.findAll();
    }

    public List<VanBang> searchVanBang(VanBang vanBang) {
        return vanBangRepository.findByIdContainingAllIgnoreCase(
                vanBang.getId()
        );
    }

    public VanBang add(VanBang vanBang){
        return vanBangRepository.save(vanBang);
    }

    public VanBang update(VanBang vanBang, Long id){
        Optional<VanBang> vb1 = vanBangRepository.findById(id);
        if(vb1.isPresent()){
            VanBang upVanbang = vb1.get();
            upVanbang.setLoaiVanBang(vanBang.getLoaiVanBang());
            upVanbang.setThoiGianBatDau(vanBang.getThoiGianBatDau());
            upVanbang.setThoiGianKetThuc(vanBang.getThoiGianKetThuc());
            return vanBangRepository.save(upVanbang);
        }
        else {
            throw new RuntimeException("Không có Van bang");
        }
    }

    public Boolean delete(Long id){
        Optional<VanBang> vb1 = vanBangRepository.findById(id);
        if(vb1.isPresent()){
            VanBang vanBang = vb1.get();
            vanBangRepository.delete(vanBang);
            return true;
        }else {
            return false;
        }
    }
}

