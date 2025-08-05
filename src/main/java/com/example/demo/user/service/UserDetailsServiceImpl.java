package com.example.demo.user.service;

import com.example.demo.user.model.UserEntity;
import com.example.demo.user.repository.UserRepositoryJpa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private UserRepositoryJpa userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        System.out.println("-- 내가 만든 로그인 기능 --");

        Optional<UserEntity> result = userRepository.findByEmail(email);
        UserEntity entity = result.get();

        if(email.equals(entity.getEmail())) {
            return new User(
                    entity.getEmail(),
                    "{noop}"+entity.getPassword(), //비밀번호 인코딩 안함 (테스트용)
                    List.of(new SimpleGrantedAuthority("ROLE_USER"))
            );
        }

        return null;
    }
}
