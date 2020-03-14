package com.schroodinger.schroodinger.repositories;

import com.schroodinger.schroodinger.models.user;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface userRepository extends JpaRepository<user, Long> {
}
