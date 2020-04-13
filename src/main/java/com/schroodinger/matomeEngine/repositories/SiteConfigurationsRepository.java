package com.schroodinger.matomeEngine.repositories;


import com.schroodinger.matomeEngine.models.SiteConfigurations;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SiteConfigurationsRepository extends JpaRepository<SiteConfigurations , Long> {

   // SiteConfigurations findBySiteId(Long SiteId);
}
