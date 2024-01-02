package com.test.user.dto;

import lombok.*;

import java.util.Set;

@Data
public class UserDto {
    private int id;
    private String username;
    private String password;
    private String gmail;
    private String address;
    private String phoneNumber;
    private Set<String> role;

}
