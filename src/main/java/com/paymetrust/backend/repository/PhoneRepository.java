package com.paymetrust.backend.repository;

import com.paymetrust.backend.entity.Phone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

/**
 * Repository interface for Phone entity operations.
 */
@Repository
public interface PhoneRepository extends JpaRepository<Phone, Long> {

    /**
     * Find phone by phone number
     * @param phoneNumber Phone number
     * @return List of phones
     */
    List<Phone> findByPhoneNumber(String phoneNumber);

    /**
     * Find phone by carrier name
     * @param carrierName Carrier name
     * @return List of phones
     */
    List<Phone> findByCarrierName(String carrierName);

    /**
     * Find phone by creation date
     * @param creationDate Creation date
     * @return List of phones
     */
    List<Phone> findByCreationDate(LocalDate creationDate);
}