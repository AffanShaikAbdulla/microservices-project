package com.hotelrating.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.hotelrating.entity.Rating;
import com.hotelrating.repo.RatingRepository;


public interface RatingService {
	//create , getRatings 
	Rating create(Rating rating);
	//rating by id
	List<Rating> getRatingByUserId(String userId);
	//get all by hotel
	List<Rating> getRatingByHotelId(String hotelId);
	

}
