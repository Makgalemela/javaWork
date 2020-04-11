package com.schroodinger.matomeEngine.services;


import com.schroodinger.matomeEngine.models.Container;
import com.schroodinger.matomeEngine.models.TreeView;
import com.schroodinger.matomeEngine.repositories.TreeViewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class TreeViewService {

    public TreeViewService() {

    }

    @Autowired
    private TreeViewRepository repo;

    public List<TreeView> populateTree(){
        return  repo.findAll();
    }

    public  TreeView saveTree(TreeView tree){
        return  repo.save(tree);
    }

//    public TreeView saveById(Long id , Container container){
//        TreeView tree = new TreeView();
//        return repo.findById(id).map(parent->{
//            tree.setParent(parent);
//            TreeView tree2 = new TreeView();
//            Set<TreeView> hash_Set = new HashSet<TreeView>();
//            tree2.setText(container.getContainerName());
//            tree2.setType("Conatiner");
//            hash_Set.add(tree2);
//            tree.setChildren(hash_Set)
//        });
//    }
}
