package com.af.api.expose.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import static com.af.api.expose.utils.Constants.JSON_PROPERTY_ACCES_TOKEN;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AuthenticationResponse {
    @JsonProperty(JSON_PROPERTY_ACCES_TOKEN)
    private String accessToken;
}
