package com.schroodinger.matomeEngine.controllers;

import com.schroodinger.matomeEngine.models.User;
import com.schroodinger.matomeEngine.services.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Optional;

@Controller
@CrossOrigin("*")
@RequestMapping("/data")
public class userController {

  @Autowired
  userService _userService;

  @RequestMapping(method = RequestMethod.GET , value = "/getByUserId/{userId}")
  public  ResponseEntity getUserById(@PathVariable(value = "userId") Long userId){
        Optional<User> resUser = _userService.getUserById(userId);
        return new ResponseEntity(resUser, HttpStatus.OK);
  }

  @RequestMapping(method = RequestMethod.GET , value = "/getAllUsers")
  public ResponseEntity getUsers( ){
    List<User> allUser = _userService.getAllUsers();
   return  new ResponseEntity(allUser , HttpStatus.OK);
  }
  @RequestMapping(method = RequestMethod.POST , value = "/saveUser")
  public ResponseEntity saveUser(@RequestBody User user){
      User newUser = _userService.createUser(user);
      return new ResponseEntity(newUser , HttpStatus.OK);
  }
}
