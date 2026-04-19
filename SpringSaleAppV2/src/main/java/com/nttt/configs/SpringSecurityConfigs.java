/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nttt.configs;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.handler.HandlerMappingIntrospector;

/**
 *
 * @author MY PC
 */
@Configuration
@EnableWebSecurity
@EnableTransactionManagement
@ComponentScan(
        basePackages = {
            "com.nttt.controllers",
            "com.nttt.repositories",
            "com.nttt.services"
        }
)
public class SpringSecurityConfigs{
    private UserDetailsService userDetailsService;
    @Bean
    public BCryptPasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
    
     @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf(c -> c.disable()).authorizeHttpRequests((requests) -> requests
                .requestMatchers("/", "/admin").hasRole("ADMIN")
                .requestMatchers("/api/**").permitAll()
        ).formLogin(form -> form.loginPage("/admin/login") // Đường dẫn tới trang đăng nhập
                .loginProcessingUrl("/admin/login") // Đường dẫn xử lý POST
                .defaultSuccessUrl("/", true) // Chuyển hướng khi thành công
                .failureUrl("/admin/login?error=true") // Chuyển hướng khi thất bại
                .permitAll()//Quan trọng vì login ai cũng vô được 
        ).logout((logout) -> logout.logoutSuccessUrl("/admin/login").permitAll());

        return http.build();
    }
    
    @Bean
    public Cloudinary cloudinary() {
        Cloudinary cloudinary
                = new Cloudinary(ObjectUtils.asMap(
                        "cloud_name", "dxxwcby8l",
                        "api_key", "792844686918347",
                        "api_secret", "T8ys_Z9zaKSqmKWa4K1RY6DXUJg",
                        "secure", true));
        return cloudinary;
    }

    @Bean
    public HandlerMappingIntrospector mvcHandlerMappingIntrospector() {
        return new HandlerMappingIntrospector();
    }
}
