package com.af.api.expose.validator;

import com.af.api.expose.model.AfUser;

public interface IValidateUserForRegistration {

    /**
     * Method to check af user information validation
     *
     * @param afUser
     */
    void checkIfValidateUser(AfUser afUser);
}
