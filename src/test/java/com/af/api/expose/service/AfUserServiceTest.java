package com.af.api.expose.service;

import com.af.api.expose.auth.IJwtService;
import com.af.api.expose.dto.AuthenticationResponse;
import com.af.api.expose.dto.RegisterRequest;
import com.af.api.expose.dto.UserDetailsResponse;
import com.af.api.expose.model.AfUser;
import com.af.api.expose.repository.controller.IAfUserRepository;
import com.af.api.expose.repository.token.ITokenRepository;
import com.af.api.expose.token.Token;
import com.af.api.expose.validator.IValidateUserForRegistration;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
public class AfUserServiceTest {

    @Mock
    private IAfUserRepository iAfUserRepository;

    @Mock
    private ITokenRepository iTokenRepository;

    @Mock
    private IValidateUserForRegistration validateUserForRegistrationImp;

    @Mock
    private IJwtService iJwtService;

    @InjectMocks
    private AfUserServiceImp _afUSerService;

    private static String afUserNameTest ="test_user";
    private static String birthDatetest ="1993-06-02";
    private static String residenceCountryNameTest ="France";
    private static String phoneNumberTest ="0760128003";
    private static String genderTest ="Masculin";
    private static Integer idTest = 1;
    private RegisterRequest registerRequest;
    private AfUser afUser;
    private UserDetailsResponse userDetailsResponse;
    private AuthenticationResponse authResponse;

    @BeforeEach
    public void init(){
        registerRequest = RegisterRequest
                .builder()
                .afUserName(afUserNameTest)
                .birthDate(LocalDate.parse(birthDatetest))
                .residenceCountryName(residenceCountryNameTest)
                .phoneNumber(phoneNumberTest)
                .gender(genderTest)
                .build();
        afUser = AfUser
                .builder()
                .afUserName(registerRequest.getAfUserName())
                .birthDate(registerRequest.getBirthDate())
                .residenceCountryName(registerRequest.getResidenceCountryName())
                .phoneNumber(registerRequest.getPhoneNumber())
                .gender(registerRequest.getGender())
                .build();

        userDetailsResponse = UserDetailsResponse
                .builder()
                .afUserName(afUserNameTest)
                .birthDate(LocalDate.parse(birthDatetest))
                .residenceCountryName(residenceCountryNameTest)
                .phoneNumber(phoneNumberTest)
                .gender(genderTest)
                .build();
    }

    @Test
    public void registerNewAfUser() throws Exception{
        doNothing().when(validateUserForRegistrationImp).checkIfValidateUser(afUser);
        when(iAfUserRepository.save(Mockito.any(AfUser.class))).thenReturn(afUser);
        when(iJwtService.generateToken(afUser.getAfUserName())).thenReturn("token");
        when(iTokenRepository.save(any(Token.class))).thenAnswer(invocation -> {
            Token savedToken = invocation.getArgument(0);
            savedToken.setId(1);
            return savedToken;
        });
        AuthenticationResponse authResponse = _afUSerService.registerAfUser(registerRequest);
        assertNotNull(authResponse);
    }

    @Test
    public void getAfUserById() throws Exception{
        when(iAfUserRepository.findById(idTest)).thenReturn(Optional.of(afUser));
        UserDetailsResponse response = _afUSerService.getUserById(idTest);
        assertNotNull(response);
        assertEquals(response, userDetailsResponse);
    }
}