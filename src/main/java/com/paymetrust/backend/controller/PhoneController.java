package com.paymetrust.backend.controller;

import com.paymetrust.backend.entity.Phone;
import com.paymetrust.backend.service.PhoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

/**
 * REST controller for Phone operations.
 */
@RestController
@RequestMapping("/api/phones")
public class PhoneController {

    private final PhoneService phoneService;

    @Autowired
    public PhoneController(PhoneService phoneService) {
        this.phoneService = phoneService;
    }

    /**
     * Get all phones
     * @return List of all phones
     */
    @GetMapping
    public ResponseEntity<List<Phone>> getAllPhones() {
        return ResponseEntity.ok(phoneService.getAllPhones());
    }

    /**
     * Get phone by ID
     * @param id Phone ID
     * @return Phone object
     */
    @GetMapping("/{id}")
    public ResponseEntity<Phone> getPhoneById(@PathVariable Long id) {
        return ResponseEntity.ok(phoneService.getPhoneById(id));
    }

    /**
     * Find phones by phone number
     * @param phoneNumber Phone number
     * @return List of phones
     */
    @GetMapping("/number/{phoneNumber}")
    public ResponseEntity<List<Phone>> findByPhoneNumber(@PathVariable String phoneNumber) {
        return ResponseEntity.ok(phoneService.findByPhoneNumber(phoneNumber));
    }

    /**
     * Find phones by carrier name
     * @param carrierName Carrier name
     * @return List of phones
     */
    @GetMapping("/carrier/{carrierName}")
    public ResponseEntity<List<Phone>> findByCarrierName(@PathVariable String carrierName) {
        return ResponseEntity.ok(phoneService.findByCarrierName(carrierName));
    }

    /**
     * Find phones by creation date
     * @param creationDate Creation date
     * @return List of phones
     */
    @GetMapping("/date/{creationDate}")
    public ResponseEntity<List<Phone>> findByCreationDate(
            @PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate creationDate) {
        return ResponseEntity.ok(phoneService.findByCreationDate(creationDate));
    }

    /**
     * Create a new phone
     * @param phone Phone object
     * @return Created phone
     */
    @PostMapping
    public ResponseEntity<Phone> createPhone(@RequestBody Phone phone) {
        return new ResponseEntity<>(phoneService.savePhone(phone), HttpStatus.CREATED);
    }

    /**
     * Update an existing phone
     * @param id Phone ID
     * @param phone Phone object
     * @return Updated phone
     */
    @PutMapping("/{id}")
    public ResponseEntity<Phone> updatePhone(@PathVariable Long id, @RequestBody Phone phone) {
        return ResponseEntity.ok(phoneService.updatePhone(id, phone));
    }

    /**
     * Delete a phone
     * @param id Phone ID
     * @return No content
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePhone(@PathVariable Long id) {
        phoneService.deletePhone(id);
        return ResponseEntity.noContent().build();
    }
}