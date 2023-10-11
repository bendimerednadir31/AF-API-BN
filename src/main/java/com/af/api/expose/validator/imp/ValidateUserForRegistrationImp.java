package com.af.api.expose.validator.imp;

import com.af.api.expose.annotation.ApiAfAnnotation;
import com.af.api.expose.exception.BadEntityRequestException;
import com.af.api.expose.exception.ErrorCodes;
import com.af.api.expose.model.AfUser;
import com.af.api.expose.validator.IValidateUserForRegistration;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.Period;

import static com.af.api.expose.utils.Constants.VALIDATOR_AGE;

@Component
@AllArgsConstructor
@RequiredArgsConstructor
public class ValidateUserForRegistrationImp implements IValidateUserForRegistration {

    @Value("${af.attributeEmpty}")
    private String notEmptyEntityAttribute;
    @Value("${af.attributeNull}")
    private String notNullEntityAttribute;
    @Value("${af.countryName}")
    private String countryName;
    @Value("${af.user.noValidErrorMessage}")
    private String invalidUserMessage;

    @ApiAfAnnotation
    public void checkIfValidateUser(AfUser afUser) {
        if (afUser.getAfUserName() == null
                || afUser.getResidenceCountryName() == null
                || afUser.getBirthDate() == null
        ) {
            throw new BadEntityRequestException(notNullEntityAttribute, ErrorCodes.ENTITY_ATTRIBUTE_NULL);
        }
        if (afUser.getAfUserName().isBlank()
                || afUser.getResidenceCountryName().isBlank()
        ) {
            throw new BadEntityRequestException(notEmptyEntityAttribute, ErrorCodes.ENTITY_ATTRIBUTE_EMPTY);
        }
        if (!checkUserCountry(afUser) || !isAdulte(afUser)) {
            throw new BadEntityRequestException(invalidUserMessage, ErrorCodes.ENTITY_ATTRIBUTE_NOT_VALID);
        }
    }

    private Boolean checkUserCountry(AfUser afUser) {
        return afUser.getResidenceCountryName().equalsIgnoreCase(countryName);
    }

    private boolean isAdulte(AfUser afUser) {
        LocalDate birthDate = afUser.getBirthDate();
        return birthDate != null && Period.between(birthDate, LocalDate.now()).getYears() >= VALIDATOR_AGE;
    }
}