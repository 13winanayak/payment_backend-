package com.paymetrust.backend.service;

import com.paymetrust.backend.entity.Operator;

import java.util.List;

/**
 * Service interface for Operator entity.
 * Defines business operations for Operator entities.
 */
public interface OperatorService {
    
    /**
     * Retrieve all operators
     * @return List of all operators
     */
    List<Operator> getAllOperators();
    
    /**
     * Retrieve an operator by ID
     * @param id The ID of the operator to retrieve
     * @return The operator if found
     */
    Operator getOperatorById(Long id);
    
    /**
     * Create a new operator
     * @param operator The operator to create
     * @return The created operator
     */
    Operator createOperator(Operator operator);
    
    /**
     * Update an existing operator
     * @param id The ID of the operator to update
     * @param operator The updated operator data
     * @return The updated operator
     */
    Operator updateOperator(Long id, Operator operator);
    
    /**
     * Delete an operator by ID
     * @param id The ID of the operator to delete
     */
    void deleteOperator(Long id);
}