package com.paymetrust.backend.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.time.LocalDate;

/**
 * Entity class representing the operators table in the database.
 */
@Entity
@Table(name = "operators")
@Data // Generates getters, setters, toString, equals, hashCode
@NoArgsConstructor // Generates a no-argument constructor
@AllArgsConstructor // Generates an all-argument constructor
public class Operator {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "country_code", length = 10)
    private String countryCode;

    @Column(length = 10)
    private String code;

    @Column(length = 30)
    private String name;

    @Column(length = 255)
    private String type;

    @Column(name = "api_user", length = 191)
    private String apiUser;

    @Column(name = "api_key", length = 191)
    private String apiKey;

    @Column(name = "api_token", columnDefinition = "TEXT")
    private String apiToken;

    @Column(name = "token_expires_in", length = 191)
    private String tokenExpiresIn;

    @Column(name = "token_expires_at")
    private Instant tokenExpiresAt;

    @Column
    private Boolean active = false; // Sensible default

    @Column(name = "created_at")
    private Instant createdAt;

    @Column(name = "updated_at")
    private Instant updatedAt;

    @Column(name = "deleted_at")
    private Instant deletedAt;

    @Column(name = "api_token_2", columnDefinition = "TEXT")
    private String apiToken2;

    @Column(name = "token_2_expires_in", length = 191)
    private String token2ExpiresIn;

    @Column(name = "token_2_expires_at")
    private Instant token2ExpiresAt;

    @Column(name = "creation_date")
    private LocalDate creationDate;
}