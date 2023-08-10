package com.hotelbook.hotelbook.entity;

//import jakarta.persistence.*;
//import lombok.AllArgsConstructor;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import lombok.Setter;
//import java.util.*;
//
//@Entity
//@Table(name = "Rooms")
//@Getter
//@Setter
//@NoArgsConstructor
//@AllArgsConstructor
//public class Rooms {
//
//    @Id
//    @SequenceGenerator(name = "sequence_rooms", allocationSize = 1,sequenceName ="gen_sequence_rooms" )
//    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "gen_sequence_rooms")
//    @Column(name = "room_id")
//    private String id;
//
//    @Column(name = "room_name")
//    private String room_name;
//
//    @Column(name = "Price")
//    private Integer price;
//
//    @OneToMany(mappedBy = "rooms" ,cascade=CascadeType.REMOVE)
//    private List<Reservation> resId;
//
//}
