package com.schroodinger.matomeEngine.repositories;


import com.schroodinger.matomeEngine.models.Makgalemela;
import com.schroodinger.matomeEngine.models.TreeView;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TreeViewRepository extends JpaRepository<TreeView, Long> {

}
