package com.schroodinger.matomeEngine.repositories;


import com.schroodinger.matomeEngine.models.Container;
import com.schroodinger.matomeEngine.models.Makgalemela;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MakgalemelaRepository  extends JpaRepository<Makgalemela, Long> {

    //@Query("select m.id , m.name from Makgalemela m")
    List<Makgalemela> findMakgalemelaByCreateAtIsNotNull();
}
