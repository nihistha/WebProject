package com.hotelbook.hotelbook.controller;

import com.hotelbook.hotelbook.dto.UpdateProfileDto;
import com.hotelbook.hotelbook.entity.User;
import com.hotelbook.hotelbook.repo.AuthUserRepo;
import com.hotelbook.hotelbook.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Base64;

@Controller
@RequiredArgsConstructor

public class UpdateProfileController {

    private final UserService userService;
    @GetMapping("/profile")
    public String getProfile(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        User user = userService.findByUsername(username);
        model.addAttribute("user", getUser(getCurrentUser()));
        model.addAttribute("edit", User.builder()
                        .cust_location(user.getCust_location())
                        .name(user.getName())
                        .username(user.getUsername())
                        .password(user.getPassword())
                        .id(user.getId())
                .build());
        return "UpdateProfile.html";
    }

    @PostMapping("/editprofile")
    public String updateProfile(@ModelAttribute UpdateProfileDto updateProfileDto){
        userService.updateUser(updateProfileDto);
        return "redirect:/profile";
    }
    public String getCurrentUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentemail = authentication.getName();
        return currentemail;
    }

    public User getUser(String username){
        User u = userService.findByUsername(username);
        return u;
    }


}