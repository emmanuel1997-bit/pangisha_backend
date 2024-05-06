package com.pangisha.pangisha_backend.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.pangisha.pangisha_backend.exception.ResourceNotFoundException;
import com.pangisha.pangisha_backend.model.User;
import com.pangisha.pangisha_backend.repository.UserRepository;
import com.pangisha.pangisha_backend.service.UserService;

@Service
public class UserserviceImplement implements UserService {
    @Autowired
    private UserRepository UserRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public User saveUsers(User Users) {
        // String password = passwordEncoder.encode(Users.getPassword());
        // User user = Users;
        // user.setPassword(password);
        return UserRepository.save(Users);
    }

    @Override
    public List<User> getAllUsers() {

        return UserRepository.findAll();
    }

    @Override
    public User getUserbyId(Long id) {

        return UserRepository.getUserId(id);
    }

    @Override
    public String login(String username, String password) {
        User user = UserRepository.findByUsername(username);

        if (user == null) {
            return "There is no user with that email";
        } else if (user != null && passwordEncoder.matches(password, user.getPassword())) {
            var id = user.getUser_id();
            return String.valueOf(id);
        } else {
            return "invalid Password";
        }

    }

    @Override
    public User updateUserbyId(Long id, User Users) {
        User existingUser = UserRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Users", "id", id));

        existingUser.setPassword(passwordEncoder.encode(Users.getPassword()));
        existingUser.setEmail(Users.getEmail());
        existingUser.setFirst_name(Users.getFirst_name());
        existingUser.setEmail(Users.getEmail());

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

    @Override
    public String findByUsername(User user) {
        User existingUser = UserRepository.findByUsername(user.getEmail());
        User existingUserphone = UserRepository.findByPhoneNo(user.getPhone_no());
        if (existingUser != null) {
            return "Email already exists";
        } else if (existingUserphone != null) {
            return "Phone number alredy Exist";
        }
        User newuser = new User();
        newuser.setFirst_name(user.getFirst_name());
        newuser.setLast_name(user.getLast_name());
        newuser.setEmail(user.getEmail());
        newuser.setPhoto_url(user.getPhoto_url());
        newuser.setPhone_no(user.getPhone_no());
        newuser.setFirst_name(user.getFirst_name());
        newuser.setPassword(passwordEncoder.encode(user.getPassword()));
        var currentUser = UserRepository.save(newuser);
        return String.valueOf(currentUser.getUser_id());
    }

}
