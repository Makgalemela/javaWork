package com.schroodinger.matomeEngine.repositories;
import com.schroodinger.matomeEngine.models.User;
import com.schroodinger.matomeEngine.models.userAddress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface userAddressRepository extends JpaRepository<userAddress, Long> {

    List<userAddress> findByUserId(Long userId);
    List<userAddress>  findByIdAndAndUserId(Long Id , Long userId);
    userAddress findByUser(User user);

}
