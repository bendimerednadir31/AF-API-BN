package com.af.api.expose.auth;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.util.ReflectionTestUtils;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class JwtServiceTest {
    private static final String afUserName = "testAfUserName";
    @InjectMocks
    private JwtService jwtService;
    @Value("${af.secretKey}")
    private String secretKey;
    @Value("${af.security.jwt.expiration}")
    private long jwtExpiration;

    @BeforeEach
    void setUp() {
        ReflectionTestUtils.setField(jwtService, "SECRET_KEY", secretKey);
        ReflectionTestUtils.setField(jwtService, "jwtExpiration", jwtExpiration);
    }

    @Test
    void generateToken() {
        String afusername = afUserName;
        String token = jwtService.generateToken(afusername);
        assertNotNull(token);
    }

    @Test
    void extractUsername() {
        String afusername = afUserName;
        String token = jwtService.generateToken(afusername);
        String extractedUsername = jwtService.extractUsername(token);
        assertEquals(afusername, extractedUsername);
    }

    @Test
    void extractExpiration() {
        String afusername = afUserName;
        String token = jwtService.generateToken(afusername);
        LocalDate expiration = jwtService.extractExpiration(token);
        assertNotNull(expiration);
    }
}