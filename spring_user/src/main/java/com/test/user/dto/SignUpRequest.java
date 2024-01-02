package com.test.user.dto;

import lombok.Data;

import java.util.Set;

@Data
public class SignUpRequest {
    private int id;
    private String username;
    private String password;
    private String gmail;
    private String address;
    private String phoneNumber;
    private Set<String> role;
}

