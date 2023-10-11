package com.af.api.expose.security;

import com.af.api.expose.annotation.ApiAfAnnotation;
import com.af.api.expose.auth.JwtAuthenticationFilter;
import com.af.api.expose.utils.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import com.af.api.expose.config.AfUserInfoUserDetailsService;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {
    @Autowired
    private JwtAuthenticationFilter jwtAuthFilter;

    @Bean
    public UserDetailsService userDetailsService() {
        return new AfUserInfoUserDetailsService();
    }

    @ApiAfAnnotation
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
       return http
                .csrf().disable()
                .authorizeHttpRequests(req ->
                        req.requestMatchers(AntPathRequestMatcher.antMatcher(Constants.SECURITY_CONF_H2)).permitAll()
                                .requestMatchers(AntPathRequestMatcher.antMatcher(Constants.SECURITY_CONF_POST_REGISTER)).permitAll()
                                .requestMatchers(AntPathRequestMatcher.antMatcher(Constants.SECURITY_CONF_GET_USER_BY_ID)).authenticated()
                                .requestMatchers(AntPathRequestMatcher.antMatcher(Constants.SECURITY_CONF_SWAGGER_UI)).permitAll()
                                .requestMatchers(AntPathRequestMatcher.antMatcher(Constants.SECURITY_CONF_SWAGGER_UI_HTML)).permitAll()
                                .requestMatchers(AntPathRequestMatcher.antMatcher(Constants.SECURITY_CONF_API_DOCS_1 )).permitAll()
                                .requestMatchers(AntPathRequestMatcher.antMatcher(Constants.SECURITY_CONF_API_DOCS_2 )).permitAll()
                                .requestMatchers(AntPathRequestMatcher.antMatcher(Constants.SECURITY_CONF_ERROR)).permitAll()
                                .anyRequest().permitAll()
                )
                .httpBasic().disable()
                .headers().frameOptions().disable()
                .and()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authenticationProvider(authenticationProvider())
                .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class)
                .build();
    }

    @Bean
    public AuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(userDetailsService());
        return authenticationProvider;
    }
}
