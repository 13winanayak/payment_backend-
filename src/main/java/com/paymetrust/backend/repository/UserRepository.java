package com.paymetrust.backend.repository;

import com.paymetrust.backend.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository interface for User entity.
 * Provides CRUD operations for the User entity.
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    // Add custom query methods if needed
}