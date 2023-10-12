package com.af.api.expose.repository;

import com.af.api.expose.repository.token.ITokenRepository;
import com.af.api.expose.token.Token;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
public class TokenRepositoryTest {

    private static final String saveTokenValueTest = "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ0dHQiLCJpYXQiOjE2OTcwNTc5NjgsImV4cCI6MTY5NzY2Mjc2OH0.GN-5JdybcNL3i87FgZpefsH-BV8io8qSf1-wDq_JIzg";
    private static final String updatedTokenValueTest = "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ0dHQiLCJpYXQiOjE2OTcwNTc5NjgsImV4cCI6MTY5NzY2Mjc2OH0.GN-5JdybcNL3i87FgZpefsH-BV8io8qSf1-wDq_zlsjer";
    @Autowired
    private ITokenRepository tokenRepository;

    @Test
    public void testTokenCrudOperations() {
        Token token = new Token();
        token.setToken(saveTokenValueTest);
        tokenRepository.save(token);

        Optional<Token> foundToken = tokenRepository.findById(token.getId());
        Optional<Token> notFoundToken = tokenRepository.findById(-1); // Non-existing ID

        assertTrue(foundToken.isPresent());
        assertFalse(notFoundToken.isPresent());

        assertEquals(saveTokenValueTest, foundToken.get().getToken());

        foundToken.ifPresent(t -> {
            t.setToken(updatedTokenValueTest);
            tokenRepository.save(t);
        });

        Optional<Token> updatedToken = tokenRepository.findById(token.getId());
        assertTrue(updatedToken.isPresent());
        assertEquals(updatedTokenValueTest, updatedToken.get().getToken());

        tokenRepository.delete(updatedToken.get());

        Optional<Token> deletedToken = tokenRepository.findById(token.getId());
        assertFalse(deletedToken.isPresent());
    }
}
