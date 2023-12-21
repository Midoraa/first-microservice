package com.example.userservice.service;

import com.example.userservice.Entity.User;
import com.example.userservice.dto.UserDTO;
import com.example.userservice.feign.UserFeign;
import com.example.userservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserFeign userFeign;

    public List<UserDTO> getAllUserDetailsWithUserAndDepartment() {
        List<UserDTO> userDTOList = new ArrayList<>();
        List<User> userList = userRepository.getAll();

        userList.forEach(user -> {
            List<User> allUser = userFeign.getAllUser();
            UserDTO userDepartmentDTO = UserDTO.builder()
                    .user(user)
                    .build();
            userDTOList.add(userDepartmentDTO);
        });
        return userDTOList;
    }
}
