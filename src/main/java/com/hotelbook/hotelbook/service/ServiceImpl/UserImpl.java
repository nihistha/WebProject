package com.hotelbook.hotelbook.service.ServiceImpl;

import com.hotelbook.hotelbook.dto.RegisterDto;
import com.hotelbook.hotelbook.dto.UpdateProfileDto;
import com.hotelbook.hotelbook.entity.User;
import com.hotelbook.hotelbook.repo.AuthUserRepo;
import com.hotelbook.hotelbook.service.UserService;
import com.hotelbook.hotelbook.utils.PasswordEncoderUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor

public class UserImpl implements UserService {
    private final AuthUserRepo authUserRepo;
    @Override
    public void addUser(RegisterDto newUser) {
        User user = new User();
        String userRole = newUser.getUsername().equals("nihirashrestha")
                ? "ROLE_ADMIN" : "ROLE_USER";
        user.setRole(userRole);
        user.setName(newUser.getName());
        user.setCust_location(newUser.getLocation());
        user.setUsername(newUser.getUsername());
        user.setCust_number(newUser.getPhone());
        user.setPassword(PasswordEncoderUtil.getInstance().encode(newUser.getPassword()));
        authUserRepo.save(user);
    }

    @Override
    public User findByUsername(String username) {
        return authUserRepo.findByUsername(username).get();
    }

    @Override
    public void updateUser(UpdateProfileDto newUser) {
        User user = new User();
        String userRole = newUser.getUsername().equals("nihirashrestha")
                ? "ROLE_ADMIN" : "ROLE_USER";
        user.setRole(userRole);
        user.setId(newUser.getId());
        user.setName(newUser.getName());
        user.setCust_location(newUser.getLocation());
        user.setUsername(newUser.getUsername());
        user.setCust_number(newUser.getPhone());
        user.setPassword(PasswordEncoderUtil.getInstance().encode(newUser.getPassword()));
        authUserRepo.save(user);
    }
}
