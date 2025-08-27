package com.paymetrust.backend.repository;

import com.paymetrust.backend.entity.Operator;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository interface for Operator entity.
 * Provides CRUD operations for the Operator entity.
 */
@Repository
public interface OperatorRepository extends JpaRepository<Operator, Long> {
    // Add custom query methods if needed
}