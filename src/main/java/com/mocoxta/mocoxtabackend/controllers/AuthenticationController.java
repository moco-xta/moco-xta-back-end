package com.mocoxta.mocoxtabackend.controllers;

import com.mocoxta.mocoxtabackend.models.Token;
import com.mocoxta.mocoxtabackend.services.AuthenticationService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping(path = "/api/v1/authentication")
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationService authenticationService;

    @PostMapping("/sign_up")
    public ResponseEntity<Token.AuthenticationResponse> signUp(
            @RequestBody com.mocoxta.mocoxtabackend.models.SignInRequest request
    ) {
        return ResponseEntity.ok(authenticationService.signUp(request));
    }
    @PostMapping("/sign_in")
    public ResponseEntity<Token.AuthenticationResponse> signIn(
            @RequestBody Token.SignInRequest request
    ) {
        return ResponseEntity.ok(authenticationService.authenticate(request));
    }

    @PostMapping("/refresh-token")
    public void refreshToken(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws IOException {
        authenticationService.refreshToken(request, response);
    }
}