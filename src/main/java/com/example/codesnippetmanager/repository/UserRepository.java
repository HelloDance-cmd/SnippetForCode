package com.example.codesnippetmanager.repository;

import com.example.codesnippetmanager.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    boolean existsByUsername(String username);
    User findByUsername(String username); // 新增方法
}