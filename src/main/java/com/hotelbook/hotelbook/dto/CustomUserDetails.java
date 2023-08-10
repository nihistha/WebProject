package com.hotelbook.hotelbook.dto;
import com.hotelbook.hotelbook.entity.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.*;

public class CustomUserDetails implements UserDetails {

        private final User authUser;

        public CustomUserDetails(User authUser){
            this.authUser = authUser;
        }

        @Override
        public Collection<? extends GrantedAuthority> getAuthorities() {
//            List<SimpleGrantedAuthority> rolesList = new ArrayList<>();
//            rolesList.add(new SimpleGrantedAuthority(this.authUser.getRole()));
            return null;
        }

        @Override
        public String getPassword() {
            return this.getPassword();
        }

        @Override
        public String getUsername() {
            return this.getUsername();
        }

        @Override
        public boolean isAccountNonExpired() {
            return true;
        }

        @Override
        public boolean isAccountNonLocked() {
            return true;
        }

        @Override
        public boolean isCredentialsNonExpired() {
            return true;
        }

        @Override
        public boolean isEnabled() {
            return true;
        }
    }
