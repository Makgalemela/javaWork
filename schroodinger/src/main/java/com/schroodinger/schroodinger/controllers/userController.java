package com.schroodinger.schroodinger.controllers;
import com.schroodinger.schroodinger.models.user;
import com.schroodinger.schroodinger.services.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@CrossOrigin("*")
@RequestMapping("/data")
public class userController {

  @Autowired
  userService _userService;

  @RequestMapping(method = RequestMethod.GET , value = "/getAllUsers")
  public ResponseEntity getUsers( ){
    List<user>  allUser = _userService.getAllUsers();
   return  new ResponseEntity(allUser , HttpStatus.OK);
  }

  @RequestMapping(method = RequestMethod.POST , value = "/saveUser")
  public ResponseEntity saveUser(@RequestBody user _user){
      user __user = _userService.createUser(_user);
      return new ResponseEntity(__user , HttpStatus.OK);
  }
}
