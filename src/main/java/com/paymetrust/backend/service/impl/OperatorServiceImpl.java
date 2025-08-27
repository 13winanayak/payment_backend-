package com.paymetrust.backend.service.impl;

import com.paymetrust.backend.entity.Operator;
import com.paymetrust.backend.repository.OperatorRepository;
import com.paymetrust.backend.service.OperatorService;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;

/**
 * Implementation of the OperatorService interface.
 */
@Service
public class OperatorServiceImpl implements OperatorService {

    private final OperatorRepository operatorRepository;

    public OperatorServiceImpl(OperatorRepository operatorRepository) {
        this.operatorRepository = operatorRepository;
    }

    @Override
    public List<Operator> getAllOperators() {
        return operatorRepository.findAll();
    }

    @Override
    public Operator getOperatorById(Long id) {
        return operatorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Operator not found with id " + id));
    }

    @Override
    public Operator createOperator(Operator operator) {
        // Set creation timestamp
        operator.setCreatedAt(Instant.now());
        operator.setUpdatedAt(Instant.now());
        return operatorRepository.save(operator);
    }

    @Override
    public Operator updateOperator(Long id, Operator updatedOperator) {
        return operatorRepository.findById(id)
                .map(operator -> {
                    // Update fields
                    operator.setCountryCode(updatedOperator.getCountryCode());
                    operator.setCode(updatedOperator.getCode());
                    operator.setName(updatedOperator.getName());
                    operator.setType(updatedOperator.getType());
                    operator.setApiUser(updatedOperator.getApiUser());
                    operator.setApiKey(updatedOperator.getApiKey());
                    operator.setApiToken(updatedOperator.getApiToken());
                    operator.setTokenExpiresIn(updatedOperator.getTokenExpiresIn());
                    operator.setTokenExpiresAt(updatedOperator.getTokenExpiresAt());
                    operator.setActive(updatedOperator.getActive());
                    operator.setApiToken2(updatedOperator.getApiToken2());
                    operator.setToken2ExpiresIn(updatedOperator.getToken2ExpiresIn());
                    operator.setToken2ExpiresAt(updatedOperator.getToken2ExpiresAt());
                    operator.setCreationDate(updatedOperator.getCreationDate());
                    
                    // Update timestamp
                    operator.setUpdatedAt(Instant.now());
                    
                    return operatorRepository.save(operator);
                })
                .orElseThrow(() -> new RuntimeException("Operator not found with id " + id));
    }

    @Override
    public void deleteOperator(Long id) {
        // Soft delete by setting deletedAt timestamp
        operatorRepository.findById(id)
                .map(operator -> {
                    operator.setDeletedAt(Instant.now());
                    return operatorRepository.save(operator);
                })
                .orElseThrow(() -> new RuntimeException("Operator not found with id " + id));
    }
}