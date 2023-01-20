package com.vg.hotelservices.controller;


import com.vg.hotelservices.entities.Hotel;
import com.vg.hotelservices.services.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/hotel")
public class HotelController {

    @Autowired
    private HotelService hotelService;


    @PostMapping("/add")
    public ResponseEntity<Hotel> add(@RequestBody Hotel hotel){

        Hotel hotel1 = hotelService.add(hotel);
        return ResponseEntity.status(HttpStatus.CREATED).body(hotel1);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Hotel>> get(){

        List<Hotel> list = hotelService.getAll();
        return ResponseEntity.ok(list);
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<Hotel> getById(@PathVariable String id) throws Throwable {

        Hotel hotel = hotelService.getById(id);

        return ResponseEntity.ok(hotel);

    }
}
