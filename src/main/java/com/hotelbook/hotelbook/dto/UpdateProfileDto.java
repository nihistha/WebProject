package com.hotelbook.hotelbook.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UpdateProfileDto {
    private Integer id;
    private String Name;
    private String role;
    private String username;
    private Integer phone;
    private String password;
    private String location;
}
