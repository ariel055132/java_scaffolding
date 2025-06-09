package org.example.service.user.checker;

import org.example.entity.User;
import org.example.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

/**
 * UserServiceBaseChecker
 * <p>
 * This class provides a base checker for user-related services, allowing for common user validation checks.
 * It is designed to be extended by specific user service checkers.
 */

public abstract class UserServiceBaseChecker {
    @Autowired
    private UserRepository userRepository;

    /**
     * Checks if a user exists by their username.
     *
     * @param username
     * @return Boolean
     */
    protected Boolean getUserByUserName(String username) {
        Optional<User> user = userRepository.findUserByUsername(username);
        if (user.isPresent()) {
            return true;
        }
        return false;
    }
}
