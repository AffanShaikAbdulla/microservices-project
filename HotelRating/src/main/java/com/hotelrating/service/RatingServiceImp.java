package com.hotelrating.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotelrating.entity.Rating;
import com.hotelrating.repo.RatingRepository;

@Service
public class RatingServiceImp implements RatingService{
   @Autowired
	private RatingRepository ratingRepository;
	@Override
	public Rating create(Rating rating) {
		// TODO Auto-generated method stub
		String ratingId=UUID.randomUUID().toString();
		rating.setRatingId(ratingId);
		return ratingRepository.save(rating);
	}

	@Override
	public List<Rating> getRatingByUserId(String userId) {
		// TODO Auto-generated method stub
		return ratingRepository.findByUserId(userId);
		
	}

	@Override
	public List<Rating> getRatingByHotelId(String hotelId) {
		// TODO Auto-generated method stub
		return ratingRepository.findByHotelId(hotelId);
	}

}
