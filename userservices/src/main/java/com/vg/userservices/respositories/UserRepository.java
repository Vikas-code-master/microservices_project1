package com.vg.userservices.respositories;

import com.vg.userservices.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {

        //if u want to implement customer query

}
