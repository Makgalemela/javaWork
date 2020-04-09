package com.schroodinger.matomeEngine.controllers;

import com.schroodinger.matomeEngine.models.Container;
import com.schroodinger.matomeEngine.models.User;
import com.schroodinger.matomeEngine.services.containerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;


@Controller
@CrossOrigin("*")
@RequestMapping("/lookup")
public class containerController {

    @Autowired
    private containerService  service;



    @RequestMapping(method = RequestMethod.GET , value = "/getAllContainer")
    public ResponseEntity getAllContainer( ){
        List<Container> containers = service.getAllContainers();
        return  new ResponseEntity(containers , HttpStatus.OK);
    }
}
