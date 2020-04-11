package com.schroodinger.matomeEngine.controllers;


import com.schroodinger.matomeEngine.models.Makgalemela;
import com.schroodinger.matomeEngine.models.TreeView;
import com.schroodinger.matomeEngine.services.TreeViewService;
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
public class TreeViewController {

@Autowired
public TreeViewService service;
    @RequestMapping(method = RequestMethod.GET , value = "/populateTree")
    public ResponseEntity getAllContainer( ){
        List<TreeView> tree = service.populateTree();
        return  new ResponseEntity(tree , HttpStatus.OK);
    }
}
