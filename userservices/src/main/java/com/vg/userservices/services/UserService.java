package com.vg.userservices.services;

import com.vg.userservices.entities.User;

import java.util.List;

public interface UserService {

    //user operation

    User saveUser(User user);

    List<User> getAllUser();

    User getUser(String userId);
}
