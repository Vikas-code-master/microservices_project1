package com.vg.ratingservices.controller;


import com.vg.ratingservices.entities.Rating;
import com.vg.ratingservices.services.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rating")
public class RatingController {

    @Autowired
    private RatingService ratingService;

    @PostMapping("/add")
    public ResponseEntity<Rating> add(@RequestBody Rating rating){

        Rating rating1 = ratingService.add(rating);
        return ResponseEntity.status(HttpStatus.CREATED).body(rating1);
    }
    @GetMapping("/getAll")
    public ResponseEntity<List<Rating>> getAll(){

        List<Rating> list = ratingService.getAll();
        return ResponseEntity.ok(list);
    }
    @GetMapping("/getByUserId/{id}")
    public ResponseEntity<List<Rating>> getByUserId(@PathVariable String id){

        List<Rating> list = ratingService.getByUserId(id);
        return ResponseEntity.ok(list);
    }
    @GetMapping("/getByHotelId/{id}")
    public ResponseEntity<List<Rating>> getByHotelId(@PathVariable String id){

        List<Rating> list = ratingService.getByHotelId(id);
        return ResponseEntity.ok(list);
    }
}
