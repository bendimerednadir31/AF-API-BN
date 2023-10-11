package com.af.api.expose.repository.token;

import com.af.api.expose.token.Token;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ITokenRepository extends JpaRepository<Token, Integer> {

}
