package com.example.baitapl1.service;

import com.example.baitapl1.Entity.Xa;
import com.example.baitapl1.reposiitory.XaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class XaService {
    @Autowired
    XaRepository repository;

    public List<Xa> getAll(){
        return repository.findAll();
    }

    public List<Xa> searchXa(Xa xa) {
        return repository.findByIdContainingAllIgnoreCase(
                xa.getId()
        );
    }

    public Xa add(Xa xa){
        return repository.save(xa);
    }

    public Xa update(Xa xa, Long id){
        Optional<Xa> xa1 = repository.findById(id);
        if(xa1.isPresent()){
            Xa upXa = xa1.get();
            upXa.setTenXa(xa.getTenXa());
            return repository.save(upXa);
        }
        else {
            throw new RuntimeException("Không có Xa");
        }
    }

    public Boolean delete(Long id){
        Optional<Xa> xa1 = repository.findById(id);
        if(xa1.isPresent()){
            Xa xa = xa1.get();
            repository.delete(xa);
            return true;
        }else {
            return false;
        }
    }
}
