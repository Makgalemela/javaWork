package com.schroodinger.matomeEngine.repositories;


import com.schroodinger.matomeEngine.models.Site;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SiteRepository extends JpaRepository<Site, Long> {

}
