package com.example.recipeapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.recipeapp.model.LoginObject;
import com.example.recipeapp.model.LongObject;
import com.example.recipeapp.model.StringObject;
import com.example.recipeapp.model.User;
import com.example.recipeapp.service.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/getAllUsers")
    @ResponseBody
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = userService.findAllUsers();
        return new ResponseEntity<>(users, HttpStatus.ACCEPTED);
    }

    @PostMapping("/signup")
    @ResponseBody
    public ResponseEntity<User> createUser(@RequestBody User user) {
        User savedUser = userService.saveUser(user);
        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }

    @PostMapping(path = "/deleteUser", consumes = {
            "application/json" })
    @ResponseBody
    public void deleteUser(@RequestBody LongObject idData) {
        userService.deleteUser(idData.getLong());
    }

    @PostMapping(path = "/login", consumes = { "application/json" })
    @ResponseBody
    public ResponseEntity<User> login(@RequestBody LoginObject login) {

        User user = userService.login(login.getEmail(), login.getPassword());
        System.out.println("Email or password is wrong");

        if (user == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(user, HttpStatus.ACCEPTED);

    }

    @PostMapping(path = "/editUserPassword", consumes = { "application/json" })
    @ResponseBody
    public ResponseEntity<User> editUserPassword(@RequestBody LongObject idData, @RequestBody StringObject pwData) {
        User user = userService.findByUserId(idData.getLong());
        user.setPassword(pwData.getString());
        return new ResponseEntity<>(user, HttpStatus.ACCEPTED);
    }

    @PostMapping(path = "/editUserEmail", consumes = {
            "application/json" })
    @ResponseBody
    public ResponseEntity<User> editUserEmail(@RequestBody LongObject id, @RequestBody StringObject email) {
        User user = userService.findByUserId(id.getLong());
        user.setEmail(email.getString());
        return new ResponseEntity<>(user, HttpStatus.ACCEPTED);
    }

    @PostMapping(path = "/findByEmail", consumes = {
            "application/json" })
    @ResponseBody
    public ResponseEntity<User> findByEmail(@RequestBody StringObject email) {
        System.out.println(email.getString());
        User user = userService.findByEmail(email.getString());
        return new ResponseEntity<>(user, HttpStatus.ACCEPTED);
    }
}
