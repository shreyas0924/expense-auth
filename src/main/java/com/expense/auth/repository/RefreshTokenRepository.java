package com.expense.auth.repository;

import com.expense.auth.entities.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.expense.auth.entities.RefreshToken;

import java.util.Optional;

@Repository
public interface RefreshTokenRepository extends JpaRepository<RefreshToken, Long> {
     Optional<RefreshToken> findByToken(String token);
     void deleteByUserInfo(UserInfo userInfo);
     Optional<RefreshToken> findByUserInfo(UserInfo userInfo);
}
