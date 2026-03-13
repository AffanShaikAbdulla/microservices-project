package com.hotelrating.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hotelrating.entity.Rating;
import com.hotelrating.service.RatingService;

@RestController
@RequestMapping("/ratings")
public class RatingController {
	@Autowired
	private RatingService ratingService;

	@PostMapping("/create")
	public ResponseEntity<Rating> create(@RequestBody Rating rating) {
		return ResponseEntity.status(HttpStatus.CREATED).body(ratingService.create(rating));
	}

	@GetMapping("/users/{userId}")
	public ResponseEntity<List<Rating>> getRatingsByUserId(@PathVariable String userId) {
		System.out.println("Rating controller for userId"+userId);
		return ResponseEntity.ok(ratingService.getRatingByUserId(userId));
	}
	 @GetMapping("/hotels/{hotelId}")
	public ResponseEntity<List<Rating>> getRatingHotelById(@PathVariable String hotelId) {
		return ResponseEntity.ok(ratingService.getRatingByHotelId(hotelId));

	}

}
