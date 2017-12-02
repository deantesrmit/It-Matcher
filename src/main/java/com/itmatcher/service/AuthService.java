package com.itmatcher.service;

import com.itmatcher.domain.User;
import com.itmatcher.repository.UserRepository;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static com.google.common.base.Strings.isNullOrEmpty;

/**
 * AuthService Class - Repository for functions related to authentication
 *
 * @author dean, bede, melissa, john, mark and stephen
 * @version 1.0
 *
 */
@Service
public class AuthService {
    @Autowired
    UserRepository userRepository;

    public boolean authenticateUser(String username, String password) {
        if (isNullOrEmpty(username) || isNullOrEmpty(password)) {
            return false;
        }
        final Optional<User> maybeUser = userRepository.getUserByUserName(username);

        return maybeUser.isPresent() && validatePassword(password, maybeUser.get());
    }

    private boolean validatePassword(String password, User user) {
        String hashedPassword = BCrypt.hashpw(password, user.getSalt());
        return hashedPassword.equals(user.getPassword());
    }

    public User registerUser(User user, String password) {
        //Check if exists. Should return error when register page exists
        if(userRepository.getUserByUserName(user.getUsername()).isPresent()) return user;

        String salt = BCrypt.gensalt();
        user.setSalt(salt);
        user.setPassword(BCrypt.hashpw(password, salt));
        userRepository.registerUser(user);

        return userRepository.getUserByUserName(user.getUsername()).get();
    }
}
