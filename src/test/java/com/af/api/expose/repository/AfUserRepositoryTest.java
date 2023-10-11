package com.af.api.expose.repository;

import com.af.api.expose.model.AfUser;
import com.af.api.expose.repository.controller.IAfUserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
public class AfUserRepositoryTest {

    private static final String afUserNameTest = "test_user";
    private static final String userNotExistTest = "nonexistentUser";
    @Autowired
    private IAfUserRepository afUserRepository;

    @Test
    public void testFindByAfUserName() {
        AfUser afUsername = new AfUser();

        afUsername.setAfUserName(afUserNameTest);
        afUserRepository.save(afUsername);

        Optional<AfUser> foundAfUser = afUserRepository.findByAfUserName(afUserNameTest);
        Optional<AfUser> notFoundAfUser = afUserRepository.findByAfUserName(userNotExistTest);

        assertTrue(foundAfUser.isPresent());
        assertFalse(notFoundAfUser.isPresent());

        assertEquals(afUserNameTest, foundAfUser.get().getAfUserName());
    }
}