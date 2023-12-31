package com.af.api.expose.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

import static com.af.api.expose.utils.Constants.ENTITY_AF_USER_TABLE_NAME;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = ENTITY_AF_USER_TABLE_NAME)
public class AfUser {
    @Id
    @GeneratedValue
    private Integer id;
    @Column(unique = true)
    private String afUserName;
    private LocalDate birthDate;
    private String residenceCountryName;
    @Column(nullable = true)
    private String phoneNumber;
    @Column(nullable = true)
    private String gender;
}