package com.example.hotelreservation.service;

import com.example.hotelreservation.dto.request.LoginRequestDto;
import com.example.hotelreservation.dto.request.RefreshTokenRequestDto;
import com.example.hotelreservation.dto.request.RegisterRequestDto;
import com.example.hotelreservation.dto.response.LoginResponseDto;
import com.example.hotelreservation.dto.response.RegisterRespnseDto;
import org.springframework.stereotype.Service;

public interface AuthService {

    LoginResponseDto login(LoginRequestDto loginRequestDto);

    RegisterRespnseDto register(RegisterRequestDto registerRequestDto);

    LoginResponseDto refreshToken(RefreshTokenRequestDto refreshTokenRequestDto);
}