package com.hotelbook.hotelbook.service.ServiceImpl;

import com.hotelbook.hotelbook.dto.CustomUserDetails;
import com.hotelbook.hotelbook.entity.User;
import com.hotelbook.hotelbook.repo.AuthUserRepo;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {
    private final AuthUserRepo authUserRepo;


    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return this.authUserRepo.findByUsername(username).orElseThrow(() -> new EntityNotFoundException("User not found."));
    }
}