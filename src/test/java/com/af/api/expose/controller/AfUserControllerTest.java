package com.af.api.expose.controller;

import com.af.api.expose.auth.IJwtService;
import com.af.api.expose.dto.AuthenticationResponse;
import com.af.api.expose.dto.RegisterRequest;
import com.af.api.expose.dto.UserDetailsResponse;
import com.af.api.expose.service.IAfUserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.time.LocalDate;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@SpringBootTest
@AutoConfigureMockMvc(addFilters = false)
public class AfUserControllerTest {
    private static final String afUserNameTest = "test_user";
    private static final String birthDate = "1993-06-02";
    private static final String residenceCountryName = "France";
    private static final String phoneNumber = "0760128003";
    private static final String gender = "Masculin";
    private static final String POST_BASE_URL = "/api/v1/auth/register";
    private static final String GET_BASE_URL = "/api/v1/auth/afUser/1";
    private static final String hederName = "Authorization";
    private static final String hederFristPartToken = "Bearer ";
    private static final String afUserNameJson = "afUserName";
    private static final String residenceCountryNameJson = "residenceCountryName";
    private static final String accesTokenJson = "access_token";
    private final Integer id = 1;
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private IAfUserService _afUserService;
    @Mock
    private IJwtService iJwtService;
    private RegisterRequest registerRequest;
    private UserDetailsResponse userDetailsResponse;
    private AuthenticationResponse authResponse;

    @BeforeEach
    public void init() {
        registerRequest = RegisterRequest
                .builder()
                .afUserName(afUserNameTest)
                .birthDate(LocalDate.parse(birthDate))
                .residenceCountryName(residenceCountryName)
                .phoneNumber(phoneNumber)
                .gender(gender)
                .build();
        authResponse = AuthenticationResponse
                .builder()
                .accessToken(iJwtService.generateToken(registerRequest.getAfUserName()))
                .build();
        userDetailsResponse = UserDetailsResponse
                .builder()
                .afUserName(afUserNameTest)
                .birthDate(LocalDate.parse(birthDate))
                .residenceCountryName(residenceCountryName)
                .phoneNumber(phoneNumber)
                .gender(gender)
                .build();
    }

    @Test
    public void registerNewAfUser() throws Exception {

        given(_afUserService.registerAfUser(Mockito.any(RegisterRequest.class))).willReturn(authResponse);

        String requestJson = new ObjectMapper().writeValueAsString(authResponse);

        ResultActions response = mockMvc.perform(post(POST_BASE_URL)
                .contentType(MediaType.APPLICATION_JSON)
                .content(requestJson)
        );
        response.andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath(accesTokenJson, CoreMatchers.is(authResponse.getAccessToken())));
    }

    @Test
    public void testGetAfUserById() throws Exception {
        when(_afUserService.getUserById(id)).thenReturn(userDetailsResponse);
        String responseJson = new ObjectMapper().writeValueAsString(userDetailsResponse);
        String token = iJwtService.generateToken(userDetailsResponse.getAfUserName());
        ResultActions response = mockMvc.perform(get(GET_BASE_URL)
                .contentType(MediaType.APPLICATION_JSON)
                .header(hederName, hederFristPartToken + token)
                .content(responseJson)
        );
        response.andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath(afUserNameJson, CoreMatchers.is(userDetailsResponse.getAfUserName())))
                .andExpect(MockMvcResultMatchers.jsonPath(residenceCountryNameJson, CoreMatchers.is(userDetailsResponse.getResidenceCountryName())));
    }
}