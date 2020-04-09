package com.schroodinger.matomeEngine.repositories;

import com.schroodinger.matomeEngine.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface userRepository extends JpaRepository<User, Long> {
}
