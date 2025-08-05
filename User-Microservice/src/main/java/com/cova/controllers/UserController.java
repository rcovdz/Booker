package com.cova.controllers;

import com.cova.modals.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @GetMapping("/api/users")
    public User getUser() {
        User user = new User();
        user.setId(1);
        user.setFirstName("Raúl");
        user.setLastName("Cova");
        user.setUsername("rcovdev");
        user.setEmail("rcovdev@gmail.com");
        user.setPhone("+52 5531999455");
        user.setRole("Admin");

        return user;
    }
}
