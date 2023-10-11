package com.af.api.expose.repository.controller;

import com.af.api.expose.model.AfUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IAfUserRepository extends JpaRepository<AfUser, Integer> {
    Optional<AfUser> findByAfUserName(String username);
}
