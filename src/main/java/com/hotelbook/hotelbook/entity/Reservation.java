package com.hotelbook.hotelbook.entity;


import jakarta.persistence.*;
import lombok.*;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.*;
//import java.sql.date;

@Entity
@Table (name = "Reservation")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class Reservation {
    @Id
    @SequenceGenerator(name = "sequence_reservation", allocationSize = 1,sequenceName ="gen_sequence_reservation" )
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "gen_sequence_reservation")
    @Column(name = "reservation_id")
    private Integer id;
    @Column(name = "Persons")
    private Integer persons;
    @Column(name = "days")
    private Integer days;
    @Column(name = "CheckIndate")
    private String CheckIndate;

    @Column(name = "CheckOutdate")
    private String CheckOutdate;

    @Column(name = "Total")
    private Integer total;

    @Column(name = "Price")
    private Integer price;
    @ManyToOne
    @JoinColumn(name ="user_id")
    private User user;
}
