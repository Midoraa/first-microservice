package com.example.userservice.feign;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(name = "USER-SERVICE/user")
public interface UserFeign {

    @GetMapping("/users")
    public List getAllUser();
}
