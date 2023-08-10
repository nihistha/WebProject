package com.hotelbook.hotelbook.controller;

import com.hotelbook.hotelbook.dto.UpdateResDto;
import com.hotelbook.hotelbook.entity.Reservation;
import com.hotelbook.hotelbook.entity.User;
import com.hotelbook.hotelbook.repo.ReservationRepo;
import com.hotelbook.hotelbook.service.ReservationService;
import com.hotelbook.hotelbook.service.UserService;
import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class ReservationController {
    private final ReservationService reservationService;
    private final UserService userService;
    private final ReservationRepo reservationRepo;
    @GetMapping("/admin")
        public String getReservation(Model model){
        List<Reservation> reservationList=reservationRepo.findAll();
        model.addAttribute("reservations",reservationList);
        return "adminreservations";
        }

        @GetMapping("/myreservation")
        public String getUserReservation(Model model){
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            String username = authentication.getName();
            User user = userService.findByUsername(username);
            model.addAttribute("user", getUser(getCurrentUser()));
            model.addAttribute("reservations",user.getResId());
//            System.out.println(user.getResId().);
            return "userreservations";
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

    @PostMapping("/editreservation")
    public String updateReservation(@ModelAttribute UpdateResDto updateResDto){
        reservationService.updateReservation(updateResDto);
        return "redirect:/myreservation";
    }


    @GetMapping("/deleteRes/{id}")
    public String deleteRservation(@PathVariable ("id")Integer id){
        reservationService.deleteRes(id);
        return "redirect:/myreservation";
    }

}
