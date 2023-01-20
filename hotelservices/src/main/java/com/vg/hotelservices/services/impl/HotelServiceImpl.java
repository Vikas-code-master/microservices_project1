package com.vg.hotelservices.services.impl;

import com.vg.hotelservices.entities.Hotel;
import com.vg.hotelservices.exception.ResourceNotFoundException;
import com.vg.hotelservices.repositories.HotelRepo;
import com.vg.hotelservices.services.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class HotelServiceImpl implements HotelService {

    @Autowired
    private HotelRepo hotelRepo;
    @Override
    public Hotel add(Hotel hotel) {
        String randomId = UUID.randomUUID().toString();
        hotel.setId(randomId);
        return (Hotel) hotelRepo.save(hotel);
    }

    @Override
    public List<Hotel> getAll() {

        return hotelRepo.findAll();
    }

    @Override
    public Hotel getById(String id) {
        return hotelRepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("Hotel with given id is not found"+ id));
    }
}
