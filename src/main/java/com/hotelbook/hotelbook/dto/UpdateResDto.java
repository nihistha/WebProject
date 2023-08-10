package com.hotelbook.hotelbook.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UpdateResDto {
    private Integer id;
    private Integer userid;
    private Integer persons;
    private Integer days;
    private String checkindate;
    private String checkoutdate;
    private Integer price;
    private Integer total;
}
