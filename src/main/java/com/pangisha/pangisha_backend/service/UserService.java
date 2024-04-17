package com.pangisha.pangisha_backend.service;

import java.util.List;

import com.pangisha.pangisha_backend.model.User;

public interface UserService {

    public User saveUsers(User Users);

    public List<User> getAllUsers();

    public User getUserbyId(Long id);

    public User updateUserbyId(Long id, User Users);

    public void deleteById(Long id);

}
