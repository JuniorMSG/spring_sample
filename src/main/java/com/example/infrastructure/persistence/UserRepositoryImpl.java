package com.example.infrastructure.persistence;

import com.example.domain.user.entity.User;
import com.example.domain.user.repository.UserRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepositoryImpl extends UserRepository, JpaRepository<User, Long> {
    // JpaRepository에서 이미 메서드들이 상속됨
}