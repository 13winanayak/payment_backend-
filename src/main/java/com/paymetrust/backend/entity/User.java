package com.paymetrust.backend.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * Entity class representing the users table in the database.
 */
@Entity
@Table(name = "users", indexes = {
    @Index(name = "idx_phone_number", columnList = "phone_number"),
    @Index(name = "idx_account_type", columnList = "account_type"),
    @Index(name = "idx_status_payment", columnList = "status_payment"),
    @Index(name = "idx_status_topup", columnList = "status_topup"),
    @Index(name = "idx_status_transfer", columnList = "status_transfer"),
    @Index(name = "idx_status_withdraw", columnList = "status_withdraw"),
    @Index(name = "idx_status", columnList = "status"),
    @Index(name = "idx_tag", columnList = "tag")
})
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name", length = 255)
    private String name;

    @Column(name = "surname", length = 255)
    private String surname;

    @Column(name = "email", length = 255)
    private String email;

    @Column(name = "sending_email", length = 255, nullable = true)
    private String sendingEmail;

    @Column(name = "phone_number", length = 90)
    private String phoneNumber;

    @Column(name = "account_id", length = 255)
    private String accountId;

    @Column(name = "account_key", length = 255)
    private String accountKey;

    @Column(name = "account_type", length = 255)
    private String accountType;

    @Column(name = "password", length = 255)
    private String password;

    @Column(name = "country", length = 5, nullable = true)
    private String country;

    @Column(name = "status", length = 50, columnDefinition = "varchar(50) default 'active'")
    private String status = "active";

    @Column(name = "status_topup", length = 50, columnDefinition = "varchar(50) default 'Y'")
    private String statusTopup = "Y";

    @Column(name = "status_withdraw", length = 50, columnDefinition = "varchar(50) default 'N'")
    private String statusWithdraw = "N";

    @Column(name = "status_payment", length = 50, columnDefinition = "varchar(50) default 'Y'")
    private String statusPayment = "Y";

    @Column(name = "status_transfer", length = 50, columnDefinition = "varchar(50) default 'Y'")
    private String statusTransfer = "Y";

    @Column(name = "verification_token", length = 255, nullable = true)
    private String verificationToken;

    @Column(name = "email_verified_at", nullable = true)
    private LocalDateTime emailVerifiedAt;

    @Column(name = "remember_token", length = 100, nullable = true)
    private String rememberToken;

    @Column(name = "created_at", columnDefinition = "timestamp default CURRENT_TIMESTAMP")
    private LocalDateTime createdAt;

    @Column(name = "updated_at", columnDefinition = "timestamp default CURRENT_TIMESTAMP")
    private LocalDateTime updatedAt;

    @Column(name = "deleted_at", nullable = true)
    private LocalDateTime deletedAt;

    @Column(name = "account_password", length = 255, nullable = true)
    private String accountPassword;

    @Column(name = "picture", columnDefinition = "text", nullable = true)
    private String picture;

    @Column(name = "code", nullable = true)
    private Long code;

    @Column(name = "parent_id", nullable = true)
    private Long parentId;

    @Column(name = "role_id", nullable = true)
    private Long roleId;

    @Column(name = "periodicity", columnDefinition = "integer default 7", nullable = true)
    private Integer periodicity = 7;

    @Column(name = "currency", length = 6, columnDefinition = "varchar(6) default 'XOF'")
    private String currency = "XOF";

    @Column(name = "lockNumber", nullable = true)
    private Short lockNumber;

    @Column(name = "tag", nullable = true)
    private String tag;

    @Column(name = "misc", length = 50, nullable = true)
    private String misc;

    @Column(name = "statusAutoRedirect", nullable = true)
    private Boolean statusAutoRedirect;

    @Column(name = "can_change_payment_method", columnDefinition = "boolean default false")
    private Boolean canChangePaymentMethod = false;

    @Column(name = "category", length = 90, nullable = true)
    private String category;

    @Column(name = "reporting_url", columnDefinition = "text", nullable = true)
    private String reportingUrl;

    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
        updatedAt = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        updatedAt = LocalDateTime.now();
    }
}