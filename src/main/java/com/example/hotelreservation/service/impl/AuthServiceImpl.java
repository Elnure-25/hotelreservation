package com.example.hotelreservation.service.impl;

import com.example.hotelreservation.dto.request.LoginRequestDto;
import com.example.hotelreservation.dto.request.RefreshTokenRequestDto;
import com.example.hotelreservation.dto.request.RegisterRequestDto;
import com.example.hotelreservation.dto.response.LoginResponseDto;
import com.example.hotelreservation.dto.response.RegisterRespnseDto;
import com.example.hotelreservation.model.User;
import com.example.hotelreservation.repository.UserRepository;
import com.example.hotelreservation.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public LoginResponseDto login(LoginRequestDto loginRequestDto) {
        return null;
    }

    @Override
    public RegisterRespnseDto register(RegisterRequestDto registerRequestDto) {

        User user = new User();

        user.setUsername(registerRequestDto.getUsername());
        user.setPassword(passwordEncoder.encode(registerRequestDto.getPassword()));
        user.setRole("USER");

        userRepository.save(user);

        return null;
    }

    @Override
    public LoginResponseDto refreshToken(RefreshTokenRequestDto refreshTokenRequestDto) {
        return null;
    }
}