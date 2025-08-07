package com.example.demo.user.model;

import lombok.Builder;
import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

public class UserDto {

    //요청 데이터
    @Getter
    @Builder
    public static class AuthUser implements UserDetails {
        private Integer idx;
        private String email;
        private String password;

        public static AuthUser from(User entity) {
            AuthUser dto = AuthUser.builder()
                    .idx(entity.getIdx())
                    .email(entity.getEmail())
                    .password(entity.getPassword())
                    .build();
            return dto;
        }

        //DB에서 불러온 권한
        @Override
        public Collection<? extends GrantedAuthority> getAuthorities() {
            return List.of(new SimpleGrantedAuthority("ROLE_USER"));
        }

        //user ID
        @Override
        public String getUsername() {
            return email;
        }

        //PW 인코딩
        public String getPassword() {
            return "{noop}" + password;
        }
    }

}
