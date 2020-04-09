package com.schroodinger.matomeEngine.repositories;


import com.schroodinger.matomeEngine.models.Container;
import com.schroodinger.matomeEngine.models.userAddress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface containerRepository  extends JpaRepository<Container, Long> {
    List<Container> findByParentContainerIsNull();
//    @Query("SELECT containerName FROM Container")
    List<Container> findContainerByParentContainerIsNull();
    List<Container> findContainerByParentContainerIsNullAndContainerNameAndCreateAt();
}
