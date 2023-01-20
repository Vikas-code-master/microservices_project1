package com.vg.ratingservices.services;

import com.vg.ratingservices.entities.Rating;

import java.util.List;

public interface RatingService {

    public Rating add(Rating rating);
    public List<Rating> getAll();
    public List<Rating> getByHotelId(String id);
    public List<Rating> getByUserId(String Id);
}
