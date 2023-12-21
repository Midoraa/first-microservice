package com.example.userservice.dto;

import com.example.userservice.Entity.User;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserDTO {
    private User user;
}
