package com.paymetrust.backend.service;

import com.paymetrust.backend.entity.Phone;

import java.time.LocalDate;
import java.util.List;

/**
 * Service interface for Phone operations.
 */
public interface PhoneService {

    /**
     * Get all phones
     * @return List of all phones
     */
    List<Phone> getAllPhones();

    /**
     * Get phone by ID
     * @param id Phone ID
     * @return Phone object
     */
    Phone getPhoneById(Long id);

    /**
     * Find phones by phone number
     * @param phoneNumber Phone number
     * @return List of phones
     */
    List<Phone> findByPhoneNumber(String phoneNumber);

    /**
     * Find phones by carrier name
     * @param carrierName Carrier name
     * @return List of phones
     */
    List<Phone> findByCarrierName(String carrierName);

    /**
     * Find phones by creation date
     * @param creationDate Creation date
     * @return List of phones
     */
    List<Phone> findByCreationDate(LocalDate creationDate);

    /**
     * Save a new phone
     * @param phone Phone object
     * @return Saved phone
     */
    Phone savePhone(Phone phone);

    /**
     * Update an existing phone
     * @param id Phone ID
     * @param phone Phone object
     * @return Updated phone
     */
    Phone updatePhone(Long id, Phone phone);

    /**
     * Delete a phone
     * @param id Phone ID
     */
    void deletePhone(Long id);
}