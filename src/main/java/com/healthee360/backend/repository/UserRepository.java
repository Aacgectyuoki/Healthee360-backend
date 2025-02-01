package com.healthee360.backend.repository;

import com.healthee360.backend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    // Custom database queries can be defined here
}
