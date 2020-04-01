package com.schroodinger.matomeEngine.repositories;

import com.schroodinger.matomeEngine.models.user;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface userRepository extends JpaRepository<user, Long> {
}
