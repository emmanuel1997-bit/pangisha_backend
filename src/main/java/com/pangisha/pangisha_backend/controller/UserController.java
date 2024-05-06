package com.pangisha.pangisha_backend.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pangisha.pangisha_backend.model.User;
import com.pangisha.pangisha_backend.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
    private UserService UserServices;

    public UserController(UserService UserServices) {
        super();
        this.UserServices = UserServices;
    }

    // save data to a database API
    @PostMapping("/register")
    public ResponseEntity<String> saveUser(@RequestBody User User) {
        return new ResponseEntity<String>(UserServices.findByUsername(User),
                HttpStatus.CREATED);
        // finished
    }

    // Retrive data from databases
    @GetMapping()
    public List<User> getUser() {
        return UserServices.getAllUsers();
    }

    @PostMapping("/login/{email}/{password}")
    public ResponseEntity<String> Login(@PathVariable("email") String email,
            @PathVariable("password") String password) {

        return new ResponseEntity<String>(UserServices.login(email, password),
                HttpStatus.CREATED);
        // finished
    }

    // retrive by an id
    @GetMapping("{id}")
    public ResponseEntity<User> getUserById(@PathVariable("id") Long id) {
        return new ResponseEntity<User>(UserServices.getUserbyId(id), HttpStatus.OK);

    }

    // update data
    @PutMapping("/update/{id}")

    public ResponseEntity<User> updateUser(@PathVariable("id") Long id,
            @RequestBody User Users) {

        return new ResponseEntity<User>(UserServices.updateUserbyId(id, Users),
                HttpStatus.OK);
    }

    // delete by id
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteById(@PathVariable("id") Long id) {
        UserServices.deleteById(id);
        return new ResponseEntity<String>("ok it is deleted", HttpStatus.OK);
    }
}
