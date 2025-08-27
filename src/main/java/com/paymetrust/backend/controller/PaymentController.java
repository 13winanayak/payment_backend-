package com.paymetrust.backend.controller;

import com.paymetrust.backend.entity.Payment;
import com.paymetrust.backend.service.PaymentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

/**
 * REST controller for Payment entity.
 * Handles HTTP requests related to payments.
 */
@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api/payments")
public class PaymentController {

    private final PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    /**
     * Get all payments
     * @return List of all payments
     */
    @GetMapping
    public ResponseEntity<List<Payment>> getAllPayments() {
        List<Payment> payments = paymentService.getAllPayments();
        return new ResponseEntity<>(payments, HttpStatus.OK);
    }

    /**
     * Get payment by ID
     * @param id The ID of the payment to retrieve
     * @return The payment if found
     */
    @GetMapping("/{id}")
    public ResponseEntity<Payment> getPaymentById(@PathVariable("id") Long id) {
        Payment payment = paymentService.getPaymentById(id);
        return new ResponseEntity<>(payment, HttpStatus.OK);
    }

    /**
     * Create a new payment
     * @param payment The payment to create
     * @return The created payment
     */
    @PostMapping
    public ResponseEntity<Payment> createPayment(@RequestBody Payment payment) {
        Payment createdPayment = paymentService.createPayment(payment);
        return new ResponseEntity<>(createdPayment, HttpStatus.CREATED);
    }

    /**
     * Update an existing payment
     * @param id The ID of the payment to update
     * @param payment The updated payment data
     * @return The updated payment
     */
    @PutMapping("/{id}")
    public ResponseEntity<Payment> updatePayment(@PathVariable("id") Long id, @RequestBody Payment payment) {
        Payment updatedPayment = paymentService.updatePayment(id, payment);
        return new ResponseEntity<>(updatedPayment, HttpStatus.OK);
    }

    /**
     * Delete a payment
     * @param id The ID of the payment to delete
     * @return No content response
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deletePayment(@PathVariable("id") Long id) {
        paymentService.deletePayment(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    /**
     * Find payment by transaction ID
     * @param transactionId The transaction ID
     * @return The payment if found
     */
    @GetMapping("/transaction/{transactionId}")
    public ResponseEntity<Payment> findByTransactionId(@PathVariable("transactionId") String transactionId) {
        Payment payment = paymentService.findByTransactionId(transactionId);
        return new ResponseEntity<>(payment, HttpStatus.OK);
    }

    /**
     * Find payment by payment token
     * @param paymentToken The payment token
     * @return The payment if found
     */
    @GetMapping("/token/{paymentToken}")
    public ResponseEntity<Payment> findByPaymentToken(@PathVariable("paymentToken") String paymentToken) {
        Payment payment = paymentService.findByPaymentToken(paymentToken);
        return new ResponseEntity<>(payment, HttpStatus.OK);
    }

    /**
     * Find payments by merchant ID
     * @param merchantId The merchant ID
     * @return List of payments for the merchant
     */
    @GetMapping("/merchant/{merchantId}")
    public ResponseEntity<List<Payment>> findByMerchantId(@PathVariable("merchantId") Long merchantId) {
        List<Payment> payments = paymentService.findByMerchantId(merchantId);
        return new ResponseEntity<>(payments, HttpStatus.OK);
    }

    /**
     * Find payments by status
     * @param status The payment status
     * @return List of payments with the given status
     */
    @GetMapping("/status/{status}")
    public ResponseEntity<List<Payment>> findByStatus(@PathVariable("status") String status) {
        List<Payment> payments = paymentService.findByStatus(status);
        return new ResponseEntity<>(payments, HttpStatus.OK);
    }

    /**
     * Find payments by phone number
     * @param phoneNumber The phone number
     * @return List of payments with the given phone number
     */
    @GetMapping("/phone/{phoneNumber}")
    public ResponseEntity<List<Payment>> findByPhoneNumber(@PathVariable("phoneNumber") String phoneNumber) {
        List<Payment> payments = paymentService.findByPhoneNumber(phoneNumber);
        return new ResponseEntity<>(payments, HttpStatus.OK);
    }

    /**
     * Find payments by country
     * @param country The country code
     * @return List of payments for the given country
     */
    @GetMapping("/country/{country}")
    public ResponseEntity<List<Payment>> findByCountry(@PathVariable("country") String country) {
        List<Payment> payments = paymentService.findByCountry(country);
        return new ResponseEntity<>(payments, HttpStatus.OK);
    }

    /**
     * Find payments by creation date
     * @param creationDate The creation date in format yyyy-MM-dd
     * @return List of payments created on the given date
     */
    @GetMapping("/date/{creationDate}")
    public ResponseEntity<List<Payment>> findByCreationDate(@PathVariable("creationDate") String creationDate) {
        LocalDate date = LocalDate.parse(creationDate);
        List<Payment> payments = paymentService.findByCreationDate(date);
        return new ResponseEntity<>(payments, HttpStatus.OK);
    }

    /**
     * Find payments by external transaction ID
     * @param externalTransactionId The external transaction ID
     * @return List of payments with the given external transaction ID
     */
    @GetMapping("/external/{externalTransactionId}")
    public ResponseEntity<List<Payment>> findByExternalTransactionId(@PathVariable("externalTransactionId") String externalTransactionId) {
        List<Payment> payments = paymentService.findByExternalTransactionId(externalTransactionId);
        return new ResponseEntity<>(payments, HttpStatus.OK);
    }
}