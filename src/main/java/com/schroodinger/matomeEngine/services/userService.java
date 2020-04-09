package com.schroodinger.matomeEngine.services;

import com.schroodinger.matomeEngine.models.User;
import com.schroodinger.matomeEngine.repositories.userRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class userService {

  @Autowired
  private userRepository userRepo;

  public List<User> getAllUsers(){
     return  userRepo.findAll();
  }

  public  User createUser(User user){
    return userRepo.save(user);
  }

  public Optional<User> getUserById(Long userId){
    return userRepo.findById(userId);
  }

}
