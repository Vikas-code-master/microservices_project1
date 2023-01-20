package com.vg.userservices.controller;


import com.vg.userservices.entities.User;
import com.vg.userservices.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/getById/{id}")
    public ResponseEntity<User> getByIdUser(@PathVariable String id){
        User user = userService.getUser(id);
        return ResponseEntity.ok(user);
    }
    @GetMapping("/get")
    public ResponseEntity<List<User>> getAllUser(){
       List<User> allUser =  userService.getAllUser();
       return ResponseEntity.ok(allUser);
    }

    @PostMapping("/add")
    public ResponseEntity<User> createUser(@RequestBody User user){
        User user1 = userService.saveUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(user1);
    }

}
