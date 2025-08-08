package com.cova.service.impl;

import com.cova.exceptions.UserException;
import com.cova.modal.User;
import com.cova.repository.UserRepository;
import com.cova.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User getUserById(Long id) throws UserException {
        Optional<User> otp=userRepository.findById(id);
        if(otp.isPresent()) {
            return otp.get();
        }
        throw new UserException("USER NOT FOUND...");
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public void deleteUser(Long id) throws UserException {
        Optional<User> otp=userRepository.findById(id);
        if(otp.isPresent()) {
            userRepository.deleteById(otp.get().getId());
            return;
        }
        throw new UserException("USER NOT FOUND...");
    }

    @Override
    public User updateUser(Long id, User user) throws UserException {
        Optional<User> otp=userRepository.findById(id);
        if(otp.isPresent()) {
            User existingUser = otp.get();

            existingUser.setFirstName(user.getFirstName());
            existingUser.setLastName(user.getLastName());
            existingUser.setUsername(user.getUsername());
            existingUser.setEmail(user.getEmail());
            existingUser.setPassword(user.getPassword());
            existingUser.setPhone(user.getPhone());
            existingUser.setRole(user.getRole());

            return userRepository.save(existingUser);
        }
        throw new UserException("USER NOT FOUND...");
    }
}
