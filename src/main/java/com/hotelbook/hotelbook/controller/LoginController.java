package com.hotelbook.hotelbook.controller;

import com.hotelbook.hotelbook.dto.RegisterDto;
import com.hotelbook.hotelbook.dto.ReservationDto;
import com.hotelbook.hotelbook.service.ReservationService;
import com.hotelbook.hotelbook.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@RequiredArgsConstructor
@Controller
public class LoginController {
    private final UserService userService;
    private final ReservationService reservationService;
    @GetMapping("/login")
    private String login(){

        return "login";
    }
    @GetMapping("/signup")
    private String signup(){
        return "signup";
    }
    @PostMapping("/signup")
    public String postUser(@ModelAttribute RegisterDto newUser){
        System.out.println("Signup controller hit");
//        System.out.println(newUser.getName());
//        System.out.println(newUser.getPassword());
        System.out.println(newUser.getPhone());
        userService.addUser(newUser);
        return "redirect:/login";
    }
    @GetMapping("/home")
    public String getHomepage(){
        return "index";
    }


    @PostMapping("/create")
    public String createReservation(@ModelAttribute ReservationDto newReservarion){
        System.out.println(newReservarion.getCheckindate());
        reservationService.addReservation(newReservarion);
        return "redirect:/home";
    }

}
