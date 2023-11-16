package com.example.baitapl1.service;

import com.example.baitapl1.Entity.Huyen;
import com.example.baitapl1.reposiitory.HuyenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HuyenService {
    @Autowired
    HuyenRepository repository;

    public List<Huyen> getAll(){
        return repository.findAll();
    }

    public List<Huyen> searchHuyen(Huyen huyen) {
        return repository.findByIdContainingAllIgnoreCase(
                huyen.getId()
        );
    }

    public Huyen add(Huyen huyen){
        return repository.save(huyen);
    }

    public Huyen update(Huyen huyen, Long id){
        Optional<Huyen> huyen1 = repository.findById(id);
        if(huyen1.isPresent()){
            Huyen upHuyen = huyen1.get();
            upHuyen.setTenHuyen(huyen.getTenHuyen());
            return repository.save(upHuyen);
        }
        else {
            throw new RuntimeException("Không có Huyen");
        }
    }

    public Boolean delete(Long id){
        Optional<Huyen> huyen1 = repository.findById(id);
        if(huyen1.isPresent()){
            Huyen huyen = huyen1.get();
            repository.delete(huyen);
            return true;
        }else {
            return false;
        }
    }
}
