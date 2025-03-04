package com.tsswebapps.lapinformatica.whatslap.api.local.controller;

import com.tsswebapps.lapinformatica.whatslap.api.local.dto.AuthRequest;
import com.tsswebapps.lapinformatica.whatslap.api.local.dto.AuthResponse;
import com.tsswebapps.lapinformatica.whatslap.api.local.dto.UserRequest;
import com.tsswebapps.lapinformatica.whatslap.config.JwtUtils;
import com.tsswebapps.lapinformatica.whatslap.domain.model.User;
import com.tsswebapps.lapinformatica.whatslap.domain.service.UserService;
import com.tsswebapps.lapinformatica.whatslap.mappers.UserMapper;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final JwtUtils jwtUtils;
    private final UserService userService;
    private final UserMapper userMapper;

    public AuthController(JwtUtils jwtUtils, UserService userService, UserMapper userMapper) {
        this.jwtUtils = jwtUtils;
        this.userService = userService;
        this.userMapper = userMapper;
    }

    @PostMapping("/register")
    public ResponseEntity<?> register (@Valid @RequestBody UserRequest userRequest) {
        try {
            userService.register(userMapper.toEntity(userRequest));
            return ResponseEntity.status(HttpStatus.CREATED).body(userRequest);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body("Invalid username or password - register");
        }
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody AuthRequest authRequest) {
        try {
            User authenticateded = userService.authenticatedUser(authRequest.username(), authRequest.password());

            String token = JwtUtils.generateToken(authenticateded);
            return ResponseEntity.ok(new AuthResponse(token));
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid username or password");
        }
    }
}

