package com.example.hotelreservation.service.impl;

import com.example.hotelreservation.dto.request.LoginRequestDto;
import com.example.hotelreservation.dto.request.RefreshTokenRequestDto;
import com.example.hotelreservation.dto.request.RegisterRequestDto;
import com.example.hotelreservation.dto.response.LoginResponseDto;
import com.example.hotelreservation.dto.response.RegisterRespnseDto;
import com.example.hotelreservation.service.AuthService;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

    @Override
    public LoginResponseDto login(LoginRequestDto loginRequestDto) {
        return null;
    }

    @Override
    public RegisterRespnseDto register(RegisterRequestDto registerRequestDto) {
        return null;
    }

    @Override
    public LoginResponseDto refreshToken(RefreshTokenRequestDto refreshTokenRequestDto) {
        return null;
    }
}