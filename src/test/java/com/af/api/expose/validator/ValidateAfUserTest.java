package com.af.api.expose.validator;

import com.af.api.expose.exception.BadEntityRequestException;
import com.af.api.expose.exception.ErrorCodes;
import com.af.api.expose.model.AfUser;
import com.af.api.expose.validator.imp.ValidateUserForRegistrationImp;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class ValidateAfUserTest {

    @InjectMocks
    private ValidateUserForRegistrationImp validateUserForRegistrationImp;

    @Value("${af.attributeEmpty}")
    private String notEmptyEntityAttribute;

    private static String afUserNameTest ="test_user";
    private static String birthDatetest ="1993-06-02";
    private static String residenceCountryNameTest ="France";
    private static String notFrenchCountryTest ="Cuba";
    private static String phoneNumberTest ="0760128003";
    private static String genderTest ="Masculin";
    private AfUser afUserValide;
    private AfUser afUserNullAttribute;
    private AfUser afUserEmptyAttribute;
    private AfUser afUserNotValide;
    @BeforeEach
    public void init(){
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
        afUserNotValide =  AfUser
                .builder()
                .afUserName(afUserNameTest)
                .birthDate(LocalDate.parse(birthDatetest))
                .residenceCountryName(notFrenchCountryTest)
                .phoneNumber(phoneNumberTest)
                .gender(genderTest)
                .build();
    }
    @Test
    public void checkUserInformations()throws Exception{
        //assertT(() -> validateUserForRegistrationImp.checkIfValidateUser(user));
        /*assertThrows(new BadEntityRequestException(
                            notEmptyEntityAttribute , ErrorCodes.ENTITY_ATTRIBUTE_NULL)
                            , () -> validateUserForRegistrationImp
                            .checkIfValidateUser(afUserNullAttribute)
        );*/


    }

}
