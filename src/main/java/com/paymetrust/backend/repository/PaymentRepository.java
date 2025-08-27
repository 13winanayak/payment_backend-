package com.paymetrust.backend.repository;

import com.paymetrust.backend.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

/**
 * Repository interface for Payment entity.
 * Provides CRUD operations for the Payment entity.
 */
@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long> {
    
    /**
     * Find payment by transaction ID
     * @param transactionId The transaction ID
     * @return The payment if found
     */
    Payment findByTransactionId(String transactionId);
    
    /**
     * Find payment by payment token
     * @param paymentToken The payment token
     * @return The payment if found
     */
    Payment findByPaymentToken(String paymentToken);
    
    /**
     * Find payments by merchant ID
     * @param merchantId The merchant ID
     * @return List of payments for the merchant
     */
    List<Payment> findByMerchantId(Long merchantId);
    
    /**
     * Find payments by status
     * @param status The payment status
     * @return List of payments with the given status
     */
    List<Payment> findByStatus(String status);
    
    /**
     * Find payments by phone number
     * @param phoneNumber The phone number
     * @return List of payments with the given phone number
     */
    List<Payment> findByPhoneNumber(String phoneNumber);
    
    /**
     * Find payments by country
     * @param country The country code
     * @return List of payments for the given country
     */
    List<Payment> findByCountry(String country);
    
    /**
     * Find payments by creation date
     * @param creationDate The creation date
     * @return List of payments created on the given date
     */
    List<Payment> findByCreationDate(LocalDate creationDate);
    
    /**
     * Find payments by merchant ID and merchant transaction ID
     * @param merchantId The merchant ID
     * @param merchantTransactionId The merchant transaction ID
     * @return The payment if found
     */
    Payment findByMerchantIdAndMerchantTransactionId(Long merchantId, String merchantTransactionId);
    
    /**
     * Find payments by external transaction ID
     * @param externalTransactionId The external transaction ID
     * @return List of payments with the given external transaction ID
     */
    List<Payment> findByExternalTransactionId(String externalTransactionId);
}