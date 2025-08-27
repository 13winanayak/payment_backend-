package com.paymetrust.backend.service;

import com.paymetrust.backend.entity.Payment;

import java.time.LocalDate;
import java.util.List;

/**
 * Service interface for Payment entity.
 * Defines business operations for Payment entities.
 */
public interface PaymentService {
    
    /**
     * Retrieve all payments
     * @return List of all payments
     */
    List<Payment> getAllPayments();
    
    /**
     * Retrieve a payment by ID
     * @param id The ID of the payment to retrieve
     * @return The payment if found
     */
    Payment getPaymentById(Long id);
    
    /**
     * Create a new payment
     * @param payment The payment to create
     * @return The created payment
     */
    Payment createPayment(Payment payment);
    
    /**
     * Update an existing payment
     * @param id The ID of the payment to update
     * @param payment The updated payment data
     * @return The updated payment
     */
    Payment updatePayment(Long id, Payment payment);
    
    /**
     * Delete a payment
     * @param id The ID of the payment to delete
     */
    void deletePayment(Long id);
    
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
     * Find payments by external transaction ID
     * @param externalTransactionId The external transaction ID
     * @return List of payments with the given external transaction ID
     */
    List<Payment> findByExternalTransactionId(String externalTransactionId);
}