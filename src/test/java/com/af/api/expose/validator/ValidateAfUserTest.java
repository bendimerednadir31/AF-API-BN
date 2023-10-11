package com.af.api.expose.validator;

import com.af.api.expose.exception.BadEntityRequestException;
import com.af.api.expose.model.AfUser;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class ValidateAfUserTest {
    @InjectMocks
    private ValidateUserForRegistrationImp validateUserForRegistrationImp;
    @Value("${af.attributeEmpty}")
    private String notEmptyEntityAttribute;

    private static final String afUserNameTest = "test_user";
    private static final String birthDatetest = "1993-06-02";
    private static final String residenceCountryNameTest = "France";
    private static final String notFrenchCountryTest = "Cuba";
    private static final String phoneNumberTest = "0760128003";
    private static final String genderTest = "Masculin";

    private AfUser afUserValide;
    private AfUser afUserNullAttribute;
    private AfUser afUserEmptyAttribute;
    private AfUser afUserNotValide;

    @BeforeEach
    public void init() {
        afUserValide = AfUser
                .builder()
                .afUserName(afUserNameTest)
                .birthDate(LocalDate.parse(birthDatetest))
                .residenceCountryName(residenceCountryNameTest)
                .phoneNumber(phoneNumberTest)
                .gender(genderTest)
                .build();
        afUserNullAttribute = AfUser
                .builder()
                .afUserName(null)
                .birthDate(LocalDate.parse(birthDatetest))
                .residenceCountryName(residenceCountryNameTest)
                .phoneNumber(phoneNumberTest)
                .gender(genderTest)
                .build();
        afUserEmptyAttribute = AfUser
                .builder()
                .afUserName(afUserNameTest)
                .birthDate(LocalDate.parse(birthDatetest))
                .residenceCountryName(" ")
                .phoneNumber(phoneNumberTest)
                .gender(genderTest)
                .build();
        afUserNotValide = AfUser
                .builder()
                .afUserName(afUserNameTest)
                .birthDate(LocalDate.parse(birthDatetest))
                .residenceCountryName(notFrenchCountryTest)
                .phoneNumber(phoneNumberTest)
                .gender(genderTest)
                .build();
    }

    @Test
    public void afUserInformationsIsValid() throws Exception {
        ValidateUserForRegistrationImp mockedValidator = mock(ValidateUserForRegistrationImp.class);
        mockedValidator.checkIfValidateUser(afUserValide);
        Assertions.assertDoesNotThrow(() -> mockedValidator.checkIfValidateUser(afUserValide));
    }
    @Test
    public void afUserInformationsNotValid() throws Exception {
        assertThrows(BadEntityRequestException.class, () ->
                validateUserForRegistrationImp.checkIfValidateUser(afUserNotValide));
    }
    @Test
    public void userAttributeIsNull() throws Exception {
        assertThrows(BadEntityRequestException.class, () ->
                validateUserForRegistrationImp.checkIfValidateUser(afUserNullAttribute));
    }

    @Test
    public void userInformationsNotEmpty() throws Exception {
        assertThrows(BadEntityRequestException.class, () ->
                validateUserForRegistrationImp.checkIfValidateUser(afUserEmptyAttribute));
    }
}
