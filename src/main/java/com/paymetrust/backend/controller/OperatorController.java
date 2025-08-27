package com.paymetrust.backend.controller;

import com.paymetrust.backend.entity.Operator;
import com.paymetrust.backend.service.OperatorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * REST controller for managing Operator entities.
 */
@RestController
@RequestMapping("/api/operator")
@CrossOrigin(origins = "http://localhost:8081") // allow React dev server
public class OperatorController {

    private final OperatorService operatorService;

    public OperatorController(OperatorService operatorService) {
        this.operatorService = operatorService;
    }

    /**
     * GET /api/operator : get all operators
     *
     * @return the ResponseEntity with status 200 (OK) and the list of operators in body
     */
    @GetMapping
    public ResponseEntity<List<Operator>> getAllOperators() {
        List<Operator> operators = operatorService.getAllOperators();
        return new ResponseEntity<>(operators, HttpStatus.OK);
    }

    /**
     * GET /api/operator/:id : get the "id" operator
     *
     * @param id the id of the operator to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the operator, or with status 404 (Not Found)
     */
    @GetMapping("/{id}")
    public ResponseEntity<Operator> getOperator(@PathVariable Long id) {
        try {
            Operator operator = operatorService.getOperatorById(id);
            return new ResponseEntity<>(operator, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    /**
     * POST /api/operator : Create a new operator
     *
     * @param operator the operator to create
     * @return the ResponseEntity with status 201 (Created) and with body the new operator
     */
    @PostMapping
    public ResponseEntity<Operator> createOperator(@RequestBody Operator operator) {
        Operator result = operatorService.createOperator(operator);
        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }

    /**
     * PUT /api/operator/:id : Updates an existing operator
     *
     * @param id the id of the operator to update
     * @param operator the operator to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated operator,
     * or with status 404 (Not Found) if the operator is not found
     */
    @PutMapping("/{id}")
    public ResponseEntity<Operator> updateOperator(
            @PathVariable Long id,
            @RequestBody Operator operator) {
        try {
            Operator result = operatorService.updateOperator(id, operator);
            return new ResponseEntity<>(result, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    /**
     * DELETE /api/operator/:id : delete the "id" operator
     *
     * @param id the id of the operator to delete
     * @return the ResponseEntity with status 204 (NO_CONTENT)
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOperator(@PathVariable Long id) {
        try {
            operatorService.deleteOperator(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}