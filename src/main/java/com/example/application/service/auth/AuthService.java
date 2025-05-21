package com.example.application.service.auth;

import com.example.application.dto.auth.PasswordChangeRequest;
import com.example.application.dto.auth.RegisterRequest;
import com.example.domain.user.entity.Role;
import com.example.domain.user.entity.User;
import com.example.domain.user.repository.UserRepository;
import com.example.domain.user.service.PasswordEncoder;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    public User registerUser(RegisterRequest request) {
        if (userRepository.existsByUsername(request.getUsername())) {
            throw new IllegalArgumentException("Username already exists");
        }

        if (userRepository.existsByEmail(request.getEmail())) {
            throw new IllegalArgumentException("Email already exists");
        }

        User user = User.builder()
                .username(request.getUsername())
                .password(passwordEncoder.encode(request.getPassword()))
                .email(request.getEmail())
                .role(Role.ROLE_USER)
                .build();

        return userRepository.save(user);
    }

    @Transactional
    public void changePassword(PasswordChangeRequest request) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User currentUser = (User) authentication.getPrincipal();

        User user = userRepository.findByUsername(currentUser.getUsername())
                .orElseThrow(() -> new IllegalStateException("User not found"));

        user.updatePassword(request.getCurrentPassword(), request.getNewPassword(), passwordEncoder);
}
}
