package com.schroodinger.matomeEngine.controllers;

import com.schroodinger.matomeEngine.models.*;
import com.schroodinger.matomeEngine.services.MakgalemelaService;
import com.schroodinger.matomeEngine.services.TreeViewService;
import com.schroodinger.matomeEngine.services.containerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;


@Controller
@CrossOrigin("*")
@RequestMapping("/lookup")
public class containerController {

    @Autowired
    private containerService  service;

    @Autowired
    private MakgalemelaService mService;

    @Autowired
    private  TreeViewService treeViewService;



    @RequestMapping(method = RequestMethod.GET , value = "/getAllContainer")
    public ResponseEntity getAllContainer( ){
        List<Object[]> containers = service.getAllContainers();
        return  new ResponseEntity(containers , HttpStatus.OK);
    }



    @RequestMapping(method = RequestMethod.POST , value = "/saveContainer/{meId}")
    public Optional<ResponseEntity> addAddress(@PathVariable(value = "meId") Long meId ,
                                               @Valid @RequestBody Container container , TreeView tree){
        Optional<Makgalemela> currMe = mService.getMeById(meId);
        return currMe
                .map(me -> {
                    container.setMakgalemela(me);
                    Container currContainer = service.saveContainer(container);
                  // treeViewService.saveById(meId , currContainer);
                    TreeView trees = new TreeView(container.getContainerName(), "Container");
                    return new ResponseEntity(currContainer , HttpStatus.OK);
                });
    }
}
