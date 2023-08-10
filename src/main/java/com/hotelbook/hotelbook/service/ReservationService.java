package com.hotelbook.hotelbook.service;

import com.hotelbook.hotelbook.dto.ReservationDto;
import com.hotelbook.hotelbook.dto.UpdateResDto;

public interface ReservationService {
    void addReservation(ReservationDto newReservation);
    void updateReservation(UpdateResDto updateResDto);

    void deleteRes(Integer id);
}