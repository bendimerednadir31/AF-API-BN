package com.af.api.expose.config;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public interface IAfUserInfoUserDetailsService {

    /**
     * Method to load user by name
     * @param userName
     * @return user details
     */
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException;
}
