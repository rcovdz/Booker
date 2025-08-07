package com.cova.controllers;

import com.cova.modals.User;
import com.cova.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("api/users")
    public User createUser(@RequestBody User user) {
        return userRepository.save(user);
    }

    @GetMapping("/api/users")
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    @GetMapping("/api/users/{id}")
    public User getUserById(@PathVariable Long id) throws Exception {
        Optional<User> otp=userRepository.findById(id);
        if(otp.isPresent()) {
            return otp.get();
        }
        throw new Exception("USER NOT FOUND...");
    }

    @PutMapping("/api/users/{id}")
    public User updateUser(@RequestBody User user, @PathVariable Long id) throws Exception {
        Optional<User> otp=userRepository.findById(id);
        if(otp.isPresent()) {
            User existingUser = otp.get();

            existingUser.setFirstName(user.getFirstName());
            existingUser.setLastName(user.getLastName());
            existingUser.setUsername(user.getUsername());
            existingUser.setEmail(user.getEmail());
            existingUser.setPhone(user.getPhone());
            existingUser.setRole(user.getRole());

            return userRepository.save(existingUser);
        }
        throw new Exception("USER NOT FOUND...");

    }

    @DeleteMapping("/api/users/{id}")
    public String deleteUser(@PathVariable Long id) throws Exception {
        Optional<User> otp=userRepository.findById(id);
        if(otp.isPresent()) {
            userRepository.deleteById(otp.get().getId());
            return "USER DELETED";
        }
        throw new Exception("USER NOT FOUND...");
    }
}
