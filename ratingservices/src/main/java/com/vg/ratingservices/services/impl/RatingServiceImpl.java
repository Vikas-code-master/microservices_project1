package com.vg.ratingservices.services.impl;

import com.vg.ratingservices.entities.Rating;
import com.vg.ratingservices.respositories.RatingRepo;
import com.vg.ratingservices.services.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RatingServiceImpl implements RatingService {

    @Autowired
    private RatingRepo ratingRepo;
    @Override
    public Rating add(Rating rating) {
        return ratingRepo.save(rating);
    }

    @Override
    public List<Rating> getAll() {
        return ratingRepo.findAll();
    }
    @Override
    public List<Rating> getByUserId(String userId) {
        return ratingRepo.findByUserId(userId);
    }
    @Override
    public List<Rating> getByHotelId(String hotelId) {
        return ratingRepo.findByHotelId(hotelId);
    }

}
