package com.example.baitapl1.service;

import com.example.baitapl1.Entity.Tinh;
import com.example.baitapl1.reposiitory.TinhRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TinhService {
    @Autowired
    TinhRepository repository;

    public List<Tinh> getAll(){
        return repository.findAll();
    }

    public List<Tinh> searchTinh(Tinh tinh) {
        return repository.findByIdContainingAllIgnoreCase (
                tinh.getId()
        );
    }

    public Tinh add(Tinh tinh){
        return repository.save(tinh);
    }

    public Tinh update(Tinh tinh, Long id) {
        Optional<Tinh> existingTinh = repository.findById(id);
        if (existingTinh.isPresent()) {
            Tinh updatedTinh = existingTinh.get();
            updatedTinh.setTenTinh(tinh.getTenTinh());
            return repository.save(updatedTinh);
        } else {
            throw new RuntimeException("Khong co tinh " + id);
        }
    }
    public Boolean delete(Long id){
        Optional<Tinh> tinh1 =repository.findById(id);
        if(tinh1.isPresent()){
            Tinh tinh = tinh1.get();
            repository.delete(tinh);
            return true;
        }else {
            return false;
        }
    }
}
