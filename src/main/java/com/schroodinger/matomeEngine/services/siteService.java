package com.schroodinger.matomeEngine.services;


import com.schroodinger.matomeEngine.models.Site;
import com.schroodinger.matomeEngine.repositories.SiteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class siteService {


    @Autowired
    private SiteRepository siteRepo;

    public List<Site> getAllSites(){
        return  siteRepo.findAll();
    }
}
