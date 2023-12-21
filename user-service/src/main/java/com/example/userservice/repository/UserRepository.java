package com.example.userservice.repository;

import com.example.userservice.Entity.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
@Repository
public class UserRepository {
    public List<User> getAll() {
        User user = new User(1, "bao", "nguyen", "bin@gmail.com" );
        List<User> list = new ArrayList<>();
        list.add(user);
        return list;
    }
}
