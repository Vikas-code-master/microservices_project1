package com.vg.hotelservices.services;

import com.vg.hotelservices.entities.Hotel;

import java.util.List;
import java.util.Optional;

public interface HotelService {

    public Hotel add(Hotel hotel);

    public List<Hotel> getAll();

    public Hotel getById(String id);

}
