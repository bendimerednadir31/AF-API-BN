package com.af.api.expose.service;

import com.af.api.expose.auth.IJwtService;
import com.af.api.expose.dto.RegisterRequest;
import com.af.api.expose.dto.UserDetailsResponse;
import com.af.api.expose.repository.controller.IAfUserRepository;
import com.af.api.expose.dto.AuthenticationResponse;
import com.af.api.expose.exception.UserNotFoundException;
import com.af.api.expose.exception.ErrorCodes;
import com.af.api.expose.model.AfUser;
import com.af.api.expose.token.Token;
import com.af.api.expose.repository.token.ITokenRepository;
import com.af.api.expose.token.TokenType;
import com.af.api.expose.validator.IValidateUserForRegistration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class AfUserServiceImp implements IAfUserService {

    @Autowired
    private IAfUserRepository _afUserRepository;
    @Autowired
    private ITokenRepository iTokenRepository;
    @Autowired
    private IJwtService iJwtService;

    @Autowired
    private IValidateUserForRegistration _validateUserForRegistration;
    @Value("${af.userById.notFoundErrorMessage}")
    private String userIdNotFound;

    public AuthenticationResponse registerAfUser(RegisterRequest request)
    {
        var afUser = AfUser.builder()
                .afUserName(request.getAfUserName())
                .birthDate(request.getBirthDate())
                .residenceCountryName(request.getResidenceCountryName())
                .phoneNumber(request.getPhoneNumber())
                .gender(request.getGender())
                .build();

        _validateUserForRegistration.checkIfValidateUser(afUser);

        var savedUser = _afUserRepository.save(afUser);
        var jwtToken = iJwtService.generateToken(afUser.getAfUserName());
        saveUserToken(savedUser, jwtToken);
        return  AuthenticationResponse.builder()
                .accessToken(jwtToken)
                .build();
    }
    public UserDetailsResponse getUserById(int id) {
        AfUser afUser =_afUserRepository.findById(id)
                .orElseThrow(() -> {
                    return new UserNotFoundException(userIdNotFound +" "+ id, ErrorCodes.USER_NOT_EXSIST_ON_DATA_BASE);
                });
        return UserDetailsResponse.builder()
                .afUserName(afUser.getAfUserName())
                .birthDate(afUser.getBirthDate())
                .residenceCountryName(afUser.getResidenceCountryName())
                .phoneNumber(afUser.getPhoneNumber())
                .gender(afUser.getGender())
                .build();
    }
    private void saveUserToken(AfUser afUser, String jwtToken) {
        var token = Token.builder()
                .afUser(afUser)
                .token(jwtToken)
                .tokenType(TokenType.BEARER)
                .build();
        iTokenRepository.save(token);
    }
}