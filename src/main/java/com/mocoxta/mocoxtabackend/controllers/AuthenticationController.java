package com.mocoxta.mocoxtabackend.controllers;

import com.mocoxta.mocoxtabackend.models.AuthenticationResponse;
import com.mocoxta.mocoxtabackend.models.SignInRequest;
import com.mocoxta.mocoxtabackend.models.SignUpRequest;
import com.mocoxta.mocoxtabackend.models.Token;
import com.mocoxta.mocoxtabackend.services.AuthenticationService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping(path = "/api/v1/authentication")
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationService authenticationService;

    @PostMapping("/sign_up")
    public ResponseEntity<AuthenticationResponse> signUp(
            @RequestBody SignUpRequest request
    ) {
        return ResponseEntity.ok(authenticationService.signUp(request));
    }
    @PostMapping("/sign_in")
    public ResponseEntity<AuthenticationResponse> signIn(
            @RequestBody SignInRequest request
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
    @PostMapping("/log_out")
    public ResponseEntity<Token.LogOutResponse> logOut(
            @RequestBody Token.LogOutRequest request
    ) {
        return ResponseEntity.ok(authenticationService.logOut(request));
    }
}