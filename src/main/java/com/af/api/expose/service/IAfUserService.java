package com.af.api.expose.service;

import com.af.api.expose.dto.AuthenticationResponse;
import com.af.api.expose.dto.RegisterRequest;
import com.af.api.expose.dto.UserDetailsResponse;

public interface IAfUserService {

    /**
     * Method to register new user
     *
     * @param request
     * @return token
     */
    AuthenticationResponse registerAfUser(RegisterRequest request);

    /**
     * Method to get user by id
     *
     * @param id
     * @return user details
     */
    UserDetailsResponse getUserById(int id);
}
