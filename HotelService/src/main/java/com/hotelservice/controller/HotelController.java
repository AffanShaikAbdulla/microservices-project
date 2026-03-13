package com.hotelservice.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hotelservice.entity.Hotel;
import com.hotelservice.service.HotelService;

@RestController
@RequestMapping("/hotels")
public class HotelController {
	@Autowired
	private HotelService hotelService;

	// create
	@PostMapping("/create")
	public ResponseEntity<Hotel> createHotel(@RequestBody Hotel hotel) {
    return ResponseEntity.status(HttpStatus.CREATED).body(hotelService.createHotel(hotel));
		
	}

	// gethotels
	@GetMapping("/{hotelId}")
	public ResponseEntity<Hotel> getHotel(@PathVariable String hotelId) {

		return ResponseEntity.status(HttpStatus.CREATED).body(hotelService.getSingle(hotelId));
	}
	@GetMapping("/all")
	public ResponseEntity<List<Hotel>> getAllHotels(){
		return ResponseEntity.status(HttpStatus.CREATED).body(hotelService.getAll());
	}

}
