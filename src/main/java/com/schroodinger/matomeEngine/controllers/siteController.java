package com.schroodinger.matomeEngine.controllers;


import com.schroodinger.matomeEngine.models.Site;
import com.schroodinger.matomeEngine.models.User;
import com.schroodinger.matomeEngine.services.siteService;
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
public class siteController {


    @Autowired
    private siteService service;


    @RequestMapping(method = RequestMethod.GET , value = "/getAllUsers")
    public ResponseEntity getUsers( ){
        List<Site> sites = service.getAllSites();
        return  new ResponseEntity(sites , HttpStatus.OK);
    }
}
