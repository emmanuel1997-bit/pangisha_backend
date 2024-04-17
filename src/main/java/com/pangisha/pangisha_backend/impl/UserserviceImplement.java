package com.pangisha.pangisha_backend.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.pangisha.pangisha_backend.exception.ResourceNotFoundException;
import com.pangisha.pangisha_backend.model.User;
import com.pangisha.pangisha_backend.repository.UserRepository;
import com.pangisha.pangisha_backend.service.UserService;

@Service
public class UserserviceImplement implements UserService {

    private UserRepository UserRepository;

    public UserserviceImplement(UserRepository userRepository) {
        super();
        this.UserRepository = userRepository;
    }

    @Override
    public User saveUsers(User Users) {
        return UserRepository.save(Users);
    }

    @Override
    public List<User> getAllUsers() {
        return UserRepository.findAll();
    }

    @Override
    public User getUserbyId(Long id) {

        return UserRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Users", "id", id));

    }

    @Override
    public User updateUserbyId(Long id, User Users) {
        User existingUser = UserRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Users", "id", id));

        existingUser.setPassword(Users.getPassword());
        existingUser.setEmail(Users.getEmail());
        existingUser.setFirst_name(Users.getFirst_name());
        existingUser.setLast_name(Users.getLast_name());
        existingUser.setPhone_no(Users.getPhone_no());
        existingUser.setPhoto_url(Users.getPhoto_url());
        UserRepository.save(existingUser);
        return existingUser;
    }

    @Override
    public void deleteById(Long id) {
        UserRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Users", "id", id));
        UserRepository.deleteById(id);
    }

}
