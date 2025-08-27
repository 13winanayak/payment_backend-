package com.paymetrust.backend.service;

import com.paymetrust.backend.entity.User;

import java.util.List;

/**
 * Service interface for User operations
 */
public interface UserService {
    
    /**
     * Create a new user
     * @param user The user to create
     * @return The created user
     */
    User createUser(User user);
    
    /**
     * Get a user by ID
     * @param id The user ID
     * @return The user if found, null otherwise
     */
    User getUserById(Long id);
    
    /**
     * Get all users
     * @return List of all users
     */
    List<User> getAllUsers();
}