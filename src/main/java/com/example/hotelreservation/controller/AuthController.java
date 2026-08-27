package com.example.hotelreservation.controller;

import com.example.hotelreservation.dto.request.LoginRequestDto;
import com.example.hotelreservation.dto.request.RefreshTokenRequestDto;
import com.example.hotelreservation.dto.request.RegisterRequestDto;
import com.example.hotelreservation.dto.response.LoginResponseDto;
import com.example.hotelreservation.dto.response.RegisterRespnseDto;
import com.example.hotelreservation.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/login")
    public LoginResponseDto login(
            @RequestBody LoginRequestDto loginRequestDto) {

        return authService.login(loginRequestDto);
    }

    @PostMapping("/register")
    public RegisterRespnseDto register(
            @RequestBody RegisterRequestDto registerRequestDto) {

        return authService.register(registerRequestDto);
    }

    @PostMapping("/refresh-token")
    public LoginResponseDto refreshToken(
            @RequestBody RefreshTokenRequestDto refreshTokenRequestDto) {

        return authService.refreshToken(refreshTokenRequestDto);
    }
}