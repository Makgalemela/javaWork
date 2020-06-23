package com.schroodinger.matomeEngine.services;

import com.schroodinger.matomeEngine.models.userAddress;
import com.schroodinger.matomeEngine.repositories.userAddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

//import jdk.nashorn.internal.runtime.options.Option;

@Service
public class userAddressService {

    @Autowired
    private userAddressRepository _userAddressRepository;
//
    public List<userAddress> getAddressByUserId(Long id ){
        return  _userAddressRepository.findByUserId (id);
    }

//    public Option<userAddress> getAddressByUserAddressIdAndUserId(Long userId , Long userAddressId){
//        return  _userAddressRepository.findByIdAndUserId(userAddressId  , userId);
//    }

    public userAddress addAddress(userAddress Address){
        return _userAddressRepository.save(Address);
    }

    public  List<userAddress>  getAllUserAddress(){
       return  _userAddressRepository.findAll();
    }
}
