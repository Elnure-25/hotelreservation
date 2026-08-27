package com.example.hotelreservation.service.impl;

import com.example.hotelreservation.dto.request.LoginRequestDto;
import com.example.hotelreservation.dto.request.RefreshTokenRequestDto;
import com.example.hotelreservation.dto.request.RegisterRequestDto;
import com.example.hotelreservation.dto.response.LoginResponseDto;
import com.example.hotelreservation.dto.response.RegisterRespnseDto;
import com.example.hotelreservation.exception.InvalidRefreshTokenException;
import com.example.hotelreservation.model.User;
import com.example.hotelreservation.repository.UserRepository;
import com.example.hotelreservation.security.CustomUserDetailsService;
import com.example.hotelreservation.security.JwtService;
import com.example.hotelreservation.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;
    private final CustomUserDetailsService userDetailsService;

    @Override
    public LoginResponseDto login(LoginRequestDto loginRequestDto) {

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequestDto.getUsername(),
                        loginRequestDto.getPassword()
                )
        );

        UserDetails userDetails = (UserDetails) authentication.getPrincipal();

        String accessToken = jwtService.generateAccessToken(userDetails);
        String refreshToken = jwtService.generateRefreshToken(userDetails);

        return new LoginResponseDto(
                accessToken,
                refreshToken,
                "Bearer"
        );
    }

    @Override
    public RegisterRespnseDto register(RegisterRequestDto registerRequestDto) {

        User user = new User();

        user.setUsername(registerRequestDto.getUsername());
        user.setPassword(
                passwordEncoder.encode(registerRequestDto.getPassword())
        );
        user.setRole("ROLE_USER");

        userRepository.save(user);

        return new RegisterRespnseDto(
                user.getUsername(),
                user.getRole()
        );
    }

    @Override
    public LoginResponseDto refreshToken(
            RefreshTokenRequestDto refreshTokenRequestDto) {

        String refreshToken = refreshTokenRequestDto.getRefreshToken();

        try {

            String username = jwtService.extractUsername(refreshToken);

            UserDetails userDetails =
                    userDetailsService.loadUserByUsername(username);

            if (!jwtService.isTokenValid(refreshToken, userDetails)) {
                throw new InvalidRefreshTokenException(
                        "Invalid Refresh Token"
                );
            }

            String newAccessToken =
                    jwtService.generateAccessToken(userDetails);

            return new LoginResponseDto(
                    newAccessToken,
                    refreshToken,
                    "Bearer"
            );

        } catch (InvalidRefreshTokenException e) {
            throw e;

        } catch (Exception e) {
            throw new InvalidRefreshTokenException(
                    "Invalid Refresh Token"
            );
        }
    }
}