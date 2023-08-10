package com.hotelbook.hotelbook.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RegisterDto {

    private String Name;
    private String username;
    private String role;
    private String location;
    private Integer phone;
    private String password;
}
