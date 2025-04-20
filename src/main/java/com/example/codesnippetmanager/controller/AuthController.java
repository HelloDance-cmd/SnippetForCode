package com.example.codesnippetmanager.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.codesnippetmanager.repository.UserRepository;
import com.example.codesnippetmanager.entity.User;
import com.example.codesnippetmanager.util.JwtUtil;

@RestController
public class AuthController {
    @Autowired
    private UserRepository userRepository;

    @PostMapping("/api/login")
    public LoginResponse login(@RequestBody LoginRequest request) {
        // 从数据库中查询用户信息
        User user = userRepository.findByUsername(request.getUsername());
        if (user != null && user.getPassword().equals(request.getPassword())) {
            // 生成 JWT Token
            String token = JwtUtil.generateToken(user.getUsername());
            // 返回登录成功的响应，包含 token
            return new LoginResponse(true, "Login successful", token);
        } else {
            // 返回登录失败的响应
            return new LoginResponse(false, "Invalid username or password", null);
        }
    }

    // 新增注册接口
    @PostMapping("/api/register")
    public RegisterResponse register(@RequestBody RegisterRequest request) {
        // 检查用户名是否已存在
        if (userRepository.existsByUsername(request.getUsername())) {
            return new RegisterResponse(false, "Username already exists");
        }

        // 创建新用户并保存到数据库
        User user = new User();
        user.setUsername(request.getUsername());
        user.setPassword(request.getPassword()); // 实际项目中应加密存储密码
        userRepository.save(user);

        return new RegisterResponse(true, "Registration successful");
    }

    // 请求体类
    public static class LoginRequest {
        private String username;
        private String password;

        // Getters and Setters
        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }
    }

    // 响应体类
    public static class LoginResponse {
        private boolean success;
        private String message;
        private String token;

        public LoginResponse(boolean success, String message, String token) {
            this.success = success;
            this.message = message;
            this.token = token;
        }

        // Getters and Setters
        public boolean isSuccess() {
            return success;
        }

        public void setSuccess(boolean success) {
            this.success = success;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }

        public String getToken() {
            return token;
        }

        public void setToken(String token) {
            this.token = token;
        }
    }

    // 注册请求体类
    public static class RegisterRequest {
        private String username;
        private String password;

        // Getters and Setters
        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }
    }

    // 注册响应体类
    public static class RegisterResponse {
        private boolean success;
        private String message;

        public RegisterResponse(boolean success, String message) {
            this.success = success;
            this.message = message;
        }

        // Getters and Setters
        public boolean isSuccess() {
            return success;
        }

        public void setSuccess(boolean success) {
            this.success = success;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }
    }
}