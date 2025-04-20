package com.example.codesnippetmanager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    // 新增: 配置CORS支持
    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**") // 允许所有路径
                        .allowedOrigins("http://localhost:8081") // 允许前端访问的域名
                        .allowedMethods("GET", "POST", "PUT", "DELETE") // 允许的HTTP方法
                        .allowedHeaders("*") // 允许的请求头
                        .allowCredentials(true); // 是否允许发送Cookie
            }
        };
    }
}