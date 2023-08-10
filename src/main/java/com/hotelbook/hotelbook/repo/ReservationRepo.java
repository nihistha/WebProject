package com.hotelbook.hotelbook.repo;

import com.hotelbook.hotelbook.entity.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservationRepo extends JpaRepository <Reservation,Integer>{

}
