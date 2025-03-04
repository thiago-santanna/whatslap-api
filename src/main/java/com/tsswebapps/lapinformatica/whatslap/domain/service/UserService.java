package com.tsswebapps.lapinformatica.whatslap.domain.service;

import com.tsswebapps.lapinformatica.whatslap.domain.model.TypeUser;
import com.tsswebapps.lapinformatica.whatslap.domain.model.User;
import com.tsswebapps.lapinformatica.whatslap.domain.repository.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, BCryptPasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;

        this.passwordEncoder = passwordEncoder;
    }

    public void register(User user) {
        if (user.getTypeUser() == null) {
            user.setTypeUser(TypeUser.USER);
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
    }

    public Optional<User> findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public User authenticatedUser(String username, String password) {
        User user = findByUsername(username).orElseThrow(RuntimeException::new);

        boolean isMatch = passwordEncoder.matches(password, user.getPassword());

        if (isMatch) {
            return user;
        } else {
            throw new RuntimeException("Invalid username or password");
        }
    }
}
