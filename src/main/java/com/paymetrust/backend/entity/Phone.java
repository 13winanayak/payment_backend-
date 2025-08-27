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
 * Entity class representing the phones table in the database.
 */
@Entity
@Table(name = "phones", indexes = {
    @Index(name = "idx_phone_number", columnList = "phone_number"),
    @Index(name = "idx_carrier_name", columnList = "carrier_name"),
    @Index(name = "idx_created_at", columnList = "created_at"),
    @Index(name = "idx_creation_date", columnList = "creation_date")
})
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Phone {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "phone_number", length = 90)
    private String phoneNumber;

    @Column(name = "carrier_name", length = 255)
    private String carrierName;

    @Column(name = "details", columnDefinition = "json", nullable = true)
    @Convert(converter = com.paymetrust.backend.config.JsonNodeConverter.class)
    private JsonNode details;

    @Column(name = "created_at")
    private LocalDateTime createdAt = LocalDateTime.now();

    @Column(name = "updated_at")
    private LocalDateTime updatedAt = LocalDateTime.now();

    @Column(name = "creation_date")
    private LocalDate creationDate = LocalDate.now();
}