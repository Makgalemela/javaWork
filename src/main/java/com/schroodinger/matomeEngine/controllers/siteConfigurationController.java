package com.schroodinger.matomeEngine.controllers;

import com.schroodinger.matomeEngine.models.Site;
import com.schroodinger.matomeEngine.models.SiteConfigurations;
import com.schroodinger.matomeEngine.services.SiteConfigurationsService;
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
public class siteConfigurationController {
    @Autowired
    private SiteConfigurationsService siteService;
    @RequestMapping(method = RequestMethod.GET , value = "/getAllConfig")
    public ResponseEntity getUsers( ){
        List<SiteConfigurations> siteConfigs = siteService.getAllSiteConfigs();
        return  new ResponseEntity(siteConfigs , HttpStatus.OK);
    }
}
