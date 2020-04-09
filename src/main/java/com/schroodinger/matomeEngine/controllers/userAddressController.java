package com.schroodinger.matomeEngine.controllers;
import com.schroodinger.matomeEngine.models.User;
import com.schroodinger.matomeEngine.models.userAddress;
import com.schroodinger.matomeEngine.repositories.userAddressRepository;
import com.schroodinger.matomeEngine.services.userAddressService;
import com.schroodinger.matomeEngine.services.userService;
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
@RequestMapping("/address")
public class userAddressController {
    @Autowired
    private userService _userService;

    @Autowired
    private userAddressService _userAddressService;

    @Autowired
    private userAddressRepository _userAddressRepository;

    @RequestMapping(method = RequestMethod.GET, value = "/{userId}/address")
    public ResponseEntity getAddressByUserId(@PathVariable (value = "userId") Long userId){
        List<userAddress> userAddress = _userAddressService.getAddressByUserId(userId);
        return  new ResponseEntity(userAddress , HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET , value = "/allAddresses")
    public ResponseEntity allAddress( ){
        List<userAddress>  userAddress = _userAddressService.getAllUserAddress();
        return  new ResponseEntity(userAddress , HttpStatus.OK);
    }
  //  @PostMapping("/save/{userId}")
   @RequestMapping(method = RequestMethod.POST, value = "/save/{userId}")
    public Optional<ResponseEntity> addAddress(@PathVariable (value = "userId") Long userId ,
                                               @Valid @RequestBody userAddress userAddress){
        Optional<User> currUser = _userService.getUserById(userId);
        return currUser
                .map(user -> {
            userAddress.setUser(user);
            userAddress currAddress =_userAddressRepository.save(userAddress);
            return new ResponseEntity(currAddress , HttpStatus.OK);
        });
    }
}
