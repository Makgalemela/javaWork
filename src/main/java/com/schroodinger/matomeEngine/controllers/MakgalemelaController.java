package com.schroodinger.matomeEngine.controllers;


import com.schroodinger.matomeEngine.models.Container;
import com.schroodinger.matomeEngine.models.Makgalemela;
import com.schroodinger.matomeEngine.services.MakgalemelaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@CrossOrigin("*")
@RequestMapping("/lookup")
public class MakgalemelaController {

    @Autowired
    private MakgalemelaService service;
    @RequestMapping(method = RequestMethod.GET , value = "/getMe")
    public ResponseEntity getAllContainer( ){
        List<Makgalemela> containers = service.getMe();
        return  new ResponseEntity(containers , HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST , value = "/saveMe")
    public ResponseEntity saveContainer(@RequestBody Makgalemela Matome){
        Makgalemela newMe = service.saveMe(Matome);
        return new ResponseEntity(newMe, HttpStatus.OK);
    }
}
