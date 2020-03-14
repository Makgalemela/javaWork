package com.schroodinger.schroodinger.services;

import com.schroodinger.schroodinger.models.user;
import com.schroodinger.schroodinger.repositories.userRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class userService {

  @Autowired
  userRepository userRepo;

  public List<user> getAllUsers(){
     return  userRepo.findAll();
  }

  public  user createUser(user _user){
    return userRepo.save(_user);
  }

  public Optional<user> getUserById(Long id){
    return userRepo.findById(id);
  }

}
