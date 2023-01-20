package com.vg.hotelservices.repositories;

import com.vg.hotelservices.entities.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HotelRepo extends JpaRepository<Hotel, String> {

}
