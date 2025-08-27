package com.paymetrust.backend.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

/**
 * Entity class representing the merchant_virement table in the database.
 */
@Entity
@Table(name = "merchant_virement")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MerchantVirement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @Column(name = "deleted_at")
    private LocalDateTime deletedAt;

    @Column(name = "amount")
    private Double amount;

    @Column(name = "unique_id")
    private UUID uniqueId;

    @Column(name = "usdt")
    private Integer usdt;

    @Column(name = "merchant_id")
    private Long merchantId;

    @Column(name = "merchant_name")
    private String merchantName;

    @Column(name = "merchant_slug")
    private String merchantSlug;

    @Column(name = "merchant_phone")
    private String merchantPhone;

    @Column(name = "merchant_email")
    private String merchantEmail;

    @Column(name = "merchant_address")
    private String merchantAddress;

    @Column(name = "merchant_city")
    private String merchantCity;

    @Column(name = "merchant_country")
    private String merchantCountry;

    @Column(name = "merchant_postal_code")
    private String merchantPostalCode;

    @Column(name = "merchant_website")
    private String merchantWebsite;

    @Column(name = "merchant_logo")
    private String merchantLogo;

    @Column(name = "merchant_description")
    private String merchantDescription;

    @Column(name = "merchant_status")
    private String merchantStatus;

    @Column(name = "merchant_type")
    private String merchantType;

    @Column(name = "merchant_category")
    private String merchantCategory;

    @Column(name = "merchant_subcategory")
    private String merchantSubcategory;

    @Column(name = "merchant_currency")
    private String merchantCurrency;

    @Column(name = "merchant_language")
    private String merchantLanguage;

    @Column(name = "merchant_timezone")
    private String merchantTimezone;

    @Column(name = "merchant_tax_id")
    private String merchantTaxId;

    @Column(name = "merchant_vat_id")
    private String merchantVatId;

    @Column(name = "merchant_registration_number")
    private String merchantRegistrationNumber;

    @Column(name = "merchant_bank_name")
    private String merchantBankName;

    @Column(name = "merchant_bank_account_number")
    private String merchantBankAccountNumber;

    @Column(name = "merchant_bank_routing_number")
    private String merchantBankRoutingNumber;

    @Column(name = "merchant_bank_swift_code")
    private String merchantBankSwiftCode;

    @Column(name = "merchant_bank_iban")
    private String merchantBankIban;

    @Column(name = "merchant_bank_address")
    private String merchantBankAddress;

    @Column(name = "merchant_bank_city")
    private String merchantBankCity;

    @Column(name = "merchant_bank_country")
    private String merchantBankCountry;

    @Column(name = "merchant_bank_postal_code")
    private String merchantBankPostalCode;

    @Column(name = "status")
    private String status;

    @Column(name = "notes")
    private String notes;
}