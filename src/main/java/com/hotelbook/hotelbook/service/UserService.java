package com.hotelbook.hotelbook.service;

import com.hotelbook.hotelbook.dto.RegisterDto;
import com.hotelbook.hotelbook.dto.UpdateProfileDto;
import com.hotelbook.hotelbook.entity.User;

public interface UserService {
    void addUser(RegisterDto newUser);
    User findByUsername(String Username);
    void updateUser(UpdateProfileDto updateProfileDto);
}
