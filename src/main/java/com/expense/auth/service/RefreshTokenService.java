package com.expense.auth.service;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.expense.auth.entities.RefreshToken;
import com.expense.auth.entities.UserInfo;
import com.expense.auth.repository.RefreshTokenRepository;
import com.expense.auth.repository.UserRepository;

import java.time.Duration;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Optional;
import java.util.UUID;

@Service
public class RefreshTokenService {

    @Autowired
    RefreshTokenRepository refreshTokenRepository;

    @Autowired
    UserRepository userRepository;

    public RefreshTokenService(RefreshTokenRepository repo, UserRepository userRepo) {
        this.refreshTokenRepository = repo;
        this.userRepository = userRepo;
    }

    @Transactional
    public RefreshToken createRefreshToken(String username){
//        UserInfo userInfoExtracted = userRepository.findByUsername(username);
//        refreshTokenRepository.deleteByUserInfo(userInfoExtracted);
//        RefreshToken refreshToken = RefreshToken.builder()
//                    .userInfo(userInfoExtracted)
//                    .token(UUID.randomUUID().toString())
//                    .expiryDate(Instant.now().plusMillis(604800000))
//                    .build();
//        return refreshTokenRepository.save(refreshToken);

        UserInfo userInfoExtracted = userRepository.findByUsername(username);

        // delete old token if it exists and force flush
        refreshTokenRepository.deleteByUserInfo(userInfoExtracted);
        refreshTokenRepository.flush();

        RefreshToken refreshToken = RefreshToken.builder()
                .userInfo(userInfoExtracted)
                .token(UUID.randomUUID().toString())
                .expiryDate(Instant.now().plus(7, ChronoUnit.DAYS))
                .build();

        return refreshTokenRepository.saveAndFlush(refreshToken);

    }

    public Optional<RefreshToken> findByToken(String token){
        return refreshTokenRepository.findByToken(token);
    }

    public RefreshToken verifyExpiration(RefreshToken token){
        if(token.getExpiryDate().compareTo(Instant.now()) < 0){
            refreshTokenRepository.delete(token);
            throw new RuntimeException(token.getToken() + " Refresh token is expired. Please make a new login..!");
        }
        return token;
    }

}