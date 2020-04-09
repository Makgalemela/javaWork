package com.schroodinger.matomeEngine.services;


import com.schroodinger.matomeEngine.models.Container;
import com.schroodinger.matomeEngine.repositories.containerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class containerService {

    @Autowired
    private containerRepository  containerRepo;

    public List<Container> getAllContainers(){
        return  containerRepo.findContainerByParentContainerIsNull();
    }
}
