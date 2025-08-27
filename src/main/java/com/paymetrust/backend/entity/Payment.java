package com.paymetrust.backend.entity;

import com.fasterxml.jackson.databind.JsonNode;
import jakarta.persistence.*;
import jakarta.persistence.Convert;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * Entity class representing the payments table in the database.
 */
@Entity
@Table(name = "payments", uniqueConstraints = {
    @UniqueConstraint(name = "uk_payment_token", columnNames = {"payment_token"}),
    @UniqueConstraint(name = "uk_merchant_transaction", columnNames = {"merchant_id", "merchant_transaction_id"})
}, indexes = {
    @Index(name = "idx_status", columnList = "status"),
    @Index(name = "idx_currency", columnList = "currency"),
    @Index(name = "idx_api_status", columnList = "api_status"),
    @Index(name = "idx_created_at", columnList = "created_at"),
    @Index(name = "idx_phone_number", columnList = "phone_number"),
    @Index(name = "idx_country", columnList = "country"),
    @Index(name = "idx_merchant_id", columnList = "merchant_id"),
    @Index(name = "idx_customer_id", columnList = "customer_id"),
    @Index(name = "idx_fee_id", columnList = "fee_id"),
    @Index(name = "idx_creation_date", columnList = "creation_date")
})
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "merchant_id", referencedColumnName = "id")
    private User merchant;

    @ManyToOne
    @JoinColumn(name = "customer_id", referencedColumnName = "id", nullable = true)
    private User customer;

    @Column(name = "otp_code", length = 20, nullable = true)
    private String otpCode;

    @Column(name = "otp_expired_at", length = 20, nullable = true)
    private String otpExpiredAt;

    @ManyToOne
    @JoinColumn(name = "fee_id", referencedColumnName = "id")
    private Fee fee;

    @Column(name = "payment_token", length = 255, unique = true)
    private String paymentToken;

    @Column(name = "notify_token", length = 255)
    private String notifyToken;

    @Column(name = "transaction_id", length = 255, nullable = true)
    private String transactionId;

    @Column(name = "merchant_transaction_id", length = 255)
    private String merchantTransactionId;

    @Column(name = "currency", length = 6)
    private String currency = "XOF";

    @Column(name = "amount")
    private Double amount;

    @Column(name = "fee_amount")
    private Double feeAmount;

    @Column(name = "merchant_amount")
    private Double merchantAmount;

    @Column(name = "fee_service_amount", nullable = true)
    private Double feeServiceAmount;

    @Column(name = "net_commission_amount", nullable = true)
    private Double netCommissionAmount;

    @Column(name = "designation", columnDefinition = "TEXT", nullable = true)
    private String designation;

    @Column(name = "notify_url", length = 255)
    private String notifyUrl;

    @Column(name = "success_url", length = 255)
    private String successUrl;

    @Column(name = "failed_url", length = 255)
    private String failedUrl;

    @Column(name = "notify_with_api_status", length = 255, nullable = true)
    private String notifyWithApiStatus;

    @Column(name = "status", length = 50)
    private String status;

    @Column(name = "api_status", length = 255, nullable = true)
    private String apiStatus;

    @Column(name = "api_message", length = 255, nullable = true)
    private String apiMessage;

    @Column(name = "pay_at", nullable = true)
    private LocalDateTime payAt;

    @Column(name = "details", columnDefinition = "json", nullable = true)
    @Convert(converter = com.paymetrust.backend.config.JsonNodeConverter.class)
    private JsonNode details;

    @Column(name = "lang", length = 30)
    private String lang = "fr";

    @Column(name = "created_at")
    private LocalDateTime createdAt = LocalDateTime.now();

    @Column(name = "updated_at")
    private LocalDateTime updatedAt = LocalDateTime.now();

    @Column(name = "client_name", length = 255, nullable = true)
    private String clientName;

    @Column(name = "client_surname", length = 255, nullable = true)
    private String clientSurname;

    @Column(name = "client_phone_number", length = 90, nullable = true)
    private String clientPhoneNumber;

    @Column(name = "client_email", length = 255, nullable = true)
    private String clientEmail;

    @Column(name = "merchant_customer_id", nullable = true)
    private String merchantCustomerId;

    @Column(name = "check_operator_status", length = 255)
    private String checkOperatorStatus = "N";

    @Column(name = "sim_id", nullable = true)
    private Long simId;

    @Column(name = "phone_number", length = 90, nullable = true)
    private String phoneNumber;

    @Column(name = "country", length = 5, nullable = true)
    private String country;

    @Column(name = "carrier_name", length = 90)
    private String carrierName = "PAYMETRUST";

    @Column(name = "carrier_name_received", length = 90, nullable = true)
    private String carrierNameReceived;

    @Column(name = "error_status", length = 90, nullable = true)
    private String errorStatus;

    @Column(name = "error_description", columnDefinition = "TEXT", nullable = true)
    private String errorDescription;

    @Column(name = "client_ip_address", length = 225, nullable = true)
    private String clientIpAddress;

    @Column(name = "client_user_agent", columnDefinition = "TEXT", nullable = true)
    private String clientUserAgent;

    @Column(name = "value_date", nullable = true)
    private LocalDate valueDate;

    @Column(name = "sim_name", length = 225, nullable = true)
    private String simName;

    @Column(name = "updated_strategy", length = 255)
    private String updatedStrategy = "AUTO";

    @Column(name = "notify_context_data", columnDefinition = "json", nullable = true)
    @Convert(converter = com.paymetrust.backend.config.JsonNodeConverter.class)
    private JsonNode notifyContextData;

    @Column(name = "number_of_status_check_attempts")
    private Integer numberOfStatusCheckAttempts = 0;

    @Column(name = "completed_at", nullable = true)
    private LocalDateTime completedAt;

    @Column(name = "refund_transaction_id", length = 255, nullable = true)
    private String refundTransactionId;

    @Column(name = "refund_at", nullable = true)
    private LocalDateTime refundAt;

    @Column(name = "channel", length = 11, nullable = true)
    private String channel;

    @Column(name = "merchant_name", nullable = true)
    private String merchantName;

    @Column(name = "operator_transaction_id", nullable = true)
    private String operatorTransactionId;

    @Column(name = "external_transaction_id", nullable = true)
    private String externalTransactionId;

    @Column(name = "archived_at", nullable = true)
    private LocalDateTime archivedAt;

    @Column(name = "partner_status", length = 190, nullable = true)
    private String partnerStatus;

    @Column(name = "partner_response_do", columnDefinition = "json", nullable = true)
    @Convert(converter = com.paymetrust.backend.config.JsonNodeConverter.class)
    private JsonNode partnerResponseDo;

    @Column(name = "partner_response_check", columnDefinition = "json", nullable = true)
    @Convert(converter = com.paymetrust.backend.config.JsonNodeConverter.class)
    private JsonNode partnerResponseCheck;

    @Column(name = "partner_response_notification", columnDefinition = "json", nullable = true)
    @Convert(converter = com.paymetrust.backend.config.JsonNodeConverter.class)
    private JsonNode partnerResponseNotification;

    @Column(name = "creation_date")
    private LocalDate creationDate = LocalDate.now();
}