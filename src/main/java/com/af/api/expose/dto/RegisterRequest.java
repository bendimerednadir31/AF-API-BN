package com.af.api.expose.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

import static com.af.api.expose.utils.Constants.JSON_FORMAT_PATTERN;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {
    private String afUserName;
    @JsonFormat(pattern = JSON_FORMAT_PATTERN)
    @JsonSerialize(using = LocalDateSerializer.class)
    private LocalDate birthDate;
    private String residenceCountryName;
    private String phoneNumber;
    private String gender;
}
