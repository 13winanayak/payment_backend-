package com.paymetrust.backend.service.impl;

import com.paymetrust.backend.entity.Payment;
import com.paymetrust.backend.repository.PaymentRepository;
import com.paymetrust.backend.service.PaymentService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

/**
 * Implementation of the PaymentService interface.
 */
@Service
public class PaymentServiceImpl implements PaymentService {

    private final PaymentRepository paymentRepository;

    public PaymentServiceImpl(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    @Override
    public List<Payment> getAllPayments() {
        return paymentRepository.findAll();
    }

    @Override
    public Payment getPaymentById(Long id) {
        return paymentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Payment not found with id " + id));
    }

    @Override
    public Payment createPayment(Payment payment) {
        // Set creation timestamp
        payment.setCreatedAt(LocalDateTime.now());
        payment.setUpdatedAt(LocalDateTime.now());
        payment.setCreationDate(LocalDate.now());
        return paymentRepository.save(payment);
    }

    @Override
    public Payment updatePayment(Long id, Payment updatedPayment) {
        return paymentRepository.findById(id)
                .map(payment -> {
                    // Update fields
                    if (updatedPayment.getMerchant() != null) {
                        payment.setMerchant(updatedPayment.getMerchant());
                    }
                    if (updatedPayment.getCustomer() != null) {
                        payment.setCustomer(updatedPayment.getCustomer());
                    }
                    if (updatedPayment.getOtpCode() != null) {
                        payment.setOtpCode(updatedPayment.getOtpCode());
                    }
                    if (updatedPayment.getOtpExpiredAt() != null) {
                        payment.setOtpExpiredAt(updatedPayment.getOtpExpiredAt());
                    }
                    if (updatedPayment.getFee() != null) {
                        payment.setFee(updatedPayment.getFee());
                    }
                    if (updatedPayment.getPaymentToken() != null) {
                        payment.setPaymentToken(updatedPayment.getPaymentToken());
                    }
                    if (updatedPayment.getNotifyToken() != null) {
                        payment.setNotifyToken(updatedPayment.getNotifyToken());
                    }
                    if (updatedPayment.getTransactionId() != null) {
                        payment.setTransactionId(updatedPayment.getTransactionId());
                    }
                    if (updatedPayment.getMerchantTransactionId() != null) {
                        payment.setMerchantTransactionId(updatedPayment.getMerchantTransactionId());
                    }
                    if (updatedPayment.getCurrency() != null) {
                        payment.setCurrency(updatedPayment.getCurrency());
                    }
                    if (updatedPayment.getAmount() != null) {
                        payment.setAmount(updatedPayment.getAmount());
                    }
                    if (updatedPayment.getFeeAmount() != null) {
                        payment.setFeeAmount(updatedPayment.getFeeAmount());
                    }
                    if (updatedPayment.getMerchantAmount() != null) {
                        payment.setMerchantAmount(updatedPayment.getMerchantAmount());
                    }
                    if (updatedPayment.getFeeServiceAmount() != null) {
                        payment.setFeeServiceAmount(updatedPayment.getFeeServiceAmount());
                    }
                    if (updatedPayment.getNetCommissionAmount() != null) {
                        payment.setNetCommissionAmount(updatedPayment.getNetCommissionAmount());
                    }
                    if (updatedPayment.getDesignation() != null) {
                        payment.setDesignation(updatedPayment.getDesignation());
                    }
                    if (updatedPayment.getNotifyUrl() != null) {
                        payment.setNotifyUrl(updatedPayment.getNotifyUrl());
                    }
                    if (updatedPayment.getSuccessUrl() != null) {
                        payment.setSuccessUrl(updatedPayment.getSuccessUrl());
                    }
                    if (updatedPayment.getFailedUrl() != null) {
                        payment.setFailedUrl(updatedPayment.getFailedUrl());
                    }
                    if (updatedPayment.getNotifyWithApiStatus() != null) {
                        payment.setNotifyWithApiStatus(updatedPayment.getNotifyWithApiStatus());
                    }
                    if (updatedPayment.getStatus() != null) {
                        payment.setStatus(updatedPayment.getStatus());
                    }
                    if (updatedPayment.getApiStatus() != null) {
                        payment.setApiStatus(updatedPayment.getApiStatus());
                    }
                    if (updatedPayment.getApiMessage() != null) {
                        payment.setApiMessage(updatedPayment.getApiMessage());
                    }
                    if (updatedPayment.getPayAt() != null) {
                        payment.setPayAt(updatedPayment.getPayAt());
                    }
                    if (updatedPayment.getDetails() != null) {
                        payment.setDetails(updatedPayment.getDetails());
                    }
                    if (updatedPayment.getLang() != null) {
                        payment.setLang(updatedPayment.getLang());
                    }
                    // Always update the updated_at timestamp
                    payment.setUpdatedAt(LocalDateTime.now());
                    
                    // Update other fields as needed
                    if (updatedPayment.getPhoneNumber() != null) {
                        payment.setPhoneNumber(updatedPayment.getPhoneNumber());
                    }
                    if (updatedPayment.getCountry() != null) {
                        payment.setCountry(updatedPayment.getCountry());
                    }
                    if (updatedPayment.getOperatorTransactionId() != null) {
                        payment.setOperatorTransactionId(updatedPayment.getOperatorTransactionId());
                    }
                    if (updatedPayment.getExternalTransactionId() != null) {
                        payment.setExternalTransactionId(updatedPayment.getExternalTransactionId());
                    }
                    
                    return paymentRepository.save(payment);
                })
                .orElseThrow(() -> new RuntimeException("Payment not found with id " + id));
    }

    @Override
    public void deletePayment(Long id) {
        Payment payment = paymentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Payment not found with id " + id));
        paymentRepository.delete(payment);
    }

    @Override
    public Payment findByTransactionId(String transactionId) {
        return paymentRepository.findByTransactionId(transactionId);
    }

    @Override
    public Payment findByPaymentToken(String paymentToken) {
        return paymentRepository.findByPaymentToken(paymentToken);
    }

    @Override
    public List<Payment> findByMerchantId(Long merchantId) {
        return paymentRepository.findByMerchantId(merchantId);
    }

    @Override
    public List<Payment> findByStatus(String status) {
        return paymentRepository.findByStatus(status);
    }

    @Override
    public List<Payment> findByPhoneNumber(String phoneNumber) {
        return paymentRepository.findByPhoneNumber(phoneNumber);
    }

    @Override
    public List<Payment> findByCountry(String country) {
        return paymentRepository.findByCountry(country);
    }

    @Override
    public List<Payment> findByCreationDate(LocalDate creationDate) {
        return paymentRepository.findByCreationDate(creationDate);
    }

    @Override
    public List<Payment> findByExternalTransactionId(String externalTransactionId) {
        return paymentRepository.findByExternalTransactionId(externalTransactionId);
    }
}