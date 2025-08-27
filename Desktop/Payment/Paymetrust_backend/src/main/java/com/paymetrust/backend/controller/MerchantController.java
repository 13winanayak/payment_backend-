package com.paymetrust.backend.controller;

import com.paymetrust.backend.entity.User;
import com.paymetrust.backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Controller for handling merchant-related operations
 */
@RestController
@RequestMapping("/api/merchants")
@CrossOrigin(origins = "*") // Allow requests from any origin
public class MerchantController {

    @Autowired
    private UserService userService;

    /**
     * Get all merchants (users with account_type = 'merchant')
     * @return ResponseEntity with all merchants and status
     */
    @GetMapping
    public ResponseEntity<Map<String, Object>> getAllMerchants() {
        try {
            // Get all users
            List<User> allUsers = userService.getAllUsers();
            
            // Filter users with account_type = 'merchant'
            List<User> merchants = allUsers.stream()
                .filter(user -> "merchant".equalsIgnoreCase(user.getAccountType()))
                .collect(Collectors.toList());
            
            Map<String, Object> response = new HashMap<>();
            response.put("status", "success");
            response.put("message", "Merchants retrieved successfully");
            response.put("data", merchants);
            
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            Map<String, Object> response = new HashMap<>();
            response.put("status", "error");
            response.put("message", e.getMessage());
            
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * Get merchant details by ID
     * @param id The merchant ID
     * @return ResponseEntity with the merchant details and status
     */
    @GetMapping("/{id}")
    public ResponseEntity<Map<String, Object>> getMerchantById(@PathVariable Long id) {
        try {
            User user = userService.getUserById(id);
            
            if (user == null) {
                Map<String, Object> response = new HashMap<>();
                response.put("status", "error");
                response.put("message", "Merchant not found");
                
                return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
            }
            
            // Check if the user is a merchant
            if (!"merchant".equalsIgnoreCase(user.getAccountType())) {
                Map<String, Object> response = new HashMap<>();
                response.put("status", "error");
                response.put("message", "User is not a merchant");
                
                return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
            }
            
            Map<String, Object> response = new HashMap<>();
            response.put("status", "success");
            response.put("message", "Merchant retrieved successfully");
            response.put("data", user);
            
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            Map<String, Object> response = new HashMap<>();
            response.put("status", "error");
            response.put("message", e.getMessage());
            
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}