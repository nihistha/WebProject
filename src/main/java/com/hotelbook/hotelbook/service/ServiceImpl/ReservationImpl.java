package com.hotelbook.hotelbook.service.ServiceImpl;

import com.hotelbook.hotelbook.dto.ReservationDto;
import com.hotelbook.hotelbook.dto.UpdateResDto;
import com.hotelbook.hotelbook.entity.Reservation;
import com.hotelbook.hotelbook.entity.User;
import com.hotelbook.hotelbook.repo.AuthUserRepo;
import com.hotelbook.hotelbook.repo.ReservationRepo;
import com.hotelbook.hotelbook.service.ReservationService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor

public class ReservationImpl implements ReservationService {
    private final AuthUserRepo userRepository;
    private final ReservationRepo reservationRepo;

    @Override
    public void addReservation(ReservationDto newReservation) {
        Reservation res = new Reservation();
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        User user = userRepository.findByUsername(username).get();
        System.out.println(user.getName());
        Integer total = newReservation.getDays()* 5000;
        res.setPersons(newReservation.getPersons());
        res.setDays(newReservation.getDays());
        res.setCheckIndate(newReservation.getCheckindate());
        res.setCheckOutdate(newReservation.getCheckoutdate());
        res.setPrice(5000);
        res.setTotal(total);
        res.setUser(user);
        reservationRepo.save(res);
//        res.set
    }

    @Override
    public void updateReservation(UpdateResDto newReservation) {
        Reservation res = new Reservation();
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        User user = userRepository.findByUsername(username).get();
        Integer total = newReservation.getDays()* 5000;
        res.setId(newReservation.getId());
        res.setPersons(newReservation.getPersons());
        res.setDays(newReservation.getDays());
        res.setCheckIndate(newReservation.getCheckindate());
        res.setCheckOutdate(newReservation.getCheckoutdate());
        res.setPrice(5000);
        res.setTotal(total);
        res.setUser(user);
        reservationRepo.save(res);
    }

    @Override
    public void deleteRes(Integer id) {
        reservationRepo.deleteById(id);
    }
}
