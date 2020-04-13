package com.schroodinger.matomeEngine.services;


import com.schroodinger.matomeEngine.models.SiteConfigurations;
import com.schroodinger.matomeEngine.repositories.SiteConfigurationsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SiteConfigurationsService {

    @Autowired
    private SiteConfigurationsRepository siteConfigRepo;

//        SiteConfigurations getSiteConfigurationBySiteId(Long siteId){
//       }


       public List<SiteConfigurations> getAllSiteConfigs(){
            return  siteConfigRepo.findAll();
        }
}
