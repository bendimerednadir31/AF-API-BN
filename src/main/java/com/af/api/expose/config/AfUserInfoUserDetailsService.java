package com.af.api.expose.config;

import com.af.api.expose.exception.UserNotFoundException;
import com.af.api.expose.model.AfUser;
import com.af.api.expose.repository.controller.IAfUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.Optional;

@Configuration
@RequiredArgsConstructor
public class AfUserInfoUserDetailsService implements IAfUserInfoUserDetailsService, UserDetailsService {

    @Autowired
    private IAfUserRepository afUserRepository;

    @Value("${af.user.notFoundErrorMessage}")
    private String userNameError;

    @Override
    public UserDetails loadUserByUsername(String userName) {
        Optional<AfUser> userInfo = afUserRepository.findByAfUserName(userName);
        return userInfo.map(AfUserInfoUserDetails::new)
                .orElseThrow(() -> new UserNotFoundException(userNameError + userName));
    }

}
