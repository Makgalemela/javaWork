package com.schroodinger.matomeEngine.repositories;


import com.schroodinger.matomeEngine.models.Container;
import com.schroodinger.matomeEngine.models.userAddress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface containerRepository  extends JpaRepository<Container, Long> {
    @Query("select s.containerName , s.subContainer from Container s")
    List<Object[]> findByParentContainerIsNull();


  //@Query("SELECT containerName  as text  ,  createAt as type FROM Container ")
  List<Object[]> findContainerByParentContainerIsNull();
}
//interface ContainerSummary {
//
//    String getContainerName();
////    String getLastname();
////    AddressSummary getAddress();
//
//    interface SubContainerSummary {
//        String getContainerName();
//    }
//}
