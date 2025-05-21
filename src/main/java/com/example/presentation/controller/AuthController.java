package com.example.presentation.controller;

import com.example.application.dto.auth.AuthResponse;
import com.example.application.dto.auth.PasswordChangeRequest;
import com.example.application.dto.auth.RegisterRequest;
import com.example.application.service.auth.AuthService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<AuthResponse> register(@Valid @RequestBody RegisterRequest request) {
        authService.registerUser(request);

        return ResponseEntity.ok(AuthResponse.builder()
                .message("User registered successfully")
                .success(true)
                .build());
    }
    
    @PostMapping("/change-password")
    public ResponseEntity<AuthResponse> changePassword(@Valid @RequestBody PasswordChangeRequest request) {
        authService.changePassword(request);

        return ResponseEntity.ok(AuthResponse.builder()
                .message("Password changed successfully")
                .success(true)
                .build());
    }

    @GetMapping("/login")
    public String loginPage() {
        // 템플릿 엔진 사용 시 템플릿 이름 반환
        return "login";
}
}
