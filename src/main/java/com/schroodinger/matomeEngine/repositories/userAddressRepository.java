package com.schroodinger.matomeEngine.repositories;
import com.schroodinger.matomeEngine.models.User;
import com.schroodinger.matomeEngine.models.userAddress;

import jdk.nashorn.internal.runtime.options.Option;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface userAddressRepository extends JpaRepository<userAddress, Long> {

    List<userAddress> findByUserId(Long userId);
    List<userAddress>  findByIdAndAndUserId(Long Id , Long userId);
    userAddress findByUser(User user);

}
