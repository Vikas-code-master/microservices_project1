package com.vg.userservices.services.impl;

import com.vg.userservices.entities.Hotel;
import com.vg.userservices.entities.Rating;
import com.vg.userservices.entities.User;
import com.vg.userservices.exception.ResourceNotFoundException;
import com.vg.userservices.respositories.UserRepository;
import com.vg.userservices.services.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.*;

@Service
public class UserServiceImpl implements UserService {

    private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
    @Autowired
    private UserRepository userRepository ;

    @Autowired
    private RestTemplate restTemplate;
    @Override
    public User saveUser(User user) {
        String randomuserId = UUID.randomUUID().toString();
        user.setUserId(randomuserId);
        return userRepository.save(user);
    }

    @Override
    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    @Override
    public User getUser(String userId) {

        User user = userRepository.findById(userId).orElseThrow(()->new ResourceNotFoundException("user with given id is not found"+ userId));

        Rating[] useRatingObj =  restTemplate.getForObject("http://ratingservice/rating/getByUserId/"+ userId, Rating[].class);
        List<Rating> useRatingList = Arrays.stream(useRatingObj).toList();
        logger.info("user object: {}", useRatingObj.toString());
        if(useRatingList!=null && !useRatingList.isEmpty()){
            user.setRatings(useRatingList);
            for(int i=0; i<useRatingList.size();i++){
                String hotelId =  useRatingList.get(i).getHotelId();
                Hotel userHotel  = restTemplate.getForObject("http://hotelservice/hotel/getById/"+ hotelId , Hotel.class);
                useRatingList.get(i).setHotel(userHotel);
                logger.info("user object: {}", userHotel.toString());
            }
        }

        return user;
    }
}
