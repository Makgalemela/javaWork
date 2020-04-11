package com.schroodinger.matomeEngine.services;


import com.schroodinger.matomeEngine.models.Makgalemela;
import com.schroodinger.matomeEngine.repositories.MakgalemelaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MakgalemelaService {


    @Autowired
    private MakgalemelaRepository repo;

    public List<Makgalemela>  getMe(){
        return  repo.findMakgalemelaByCreateAtIsNotNull();
    }

    public  Makgalemela saveMe(Makgalemela matome){
        return  repo.save(matome);
    }

    public Optional<Makgalemela> getMeById(Long me){
        return  repo.findById(me);
    }
}
