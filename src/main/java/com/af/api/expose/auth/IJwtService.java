package com.af.api.expose.auth;

import io.jsonwebtoken.Claims;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDate;
import java.util.function.Function;

public interface IJwtService {

    /**
     * Method to generate token
     *
     * @param afUserName
     * @return token
     */
    String generateToken(String afUserName);

    /**
     * Method to check a token validation
     *
     * @param token, userDetails
     * @return boolean response
     */
    Boolean validateToken(String token, UserDetails userDetails);

    /**
     * Method extract user name from token
     *
     * @param token
     * @return user name
     */
    String extractUsername(String token);

    /**
     * Method extract token expiration time
     *
     * @param token
     * @return date time
     */
    LocalDate extractExpiration(String token);

    /**
     * Method extract claim
     *
     * @param token, claimsResolver
     * @return generic object
     */
    <T> T extractClaim(String token, Function<Claims, T> claimsResolver);
}