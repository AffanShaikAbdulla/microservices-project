package com.hotelservice.service;

import java.util.List;

import com.hotelservice.entity.Hotel;

public interface HotelService {
	//create, getall ,  getsingle 
	Hotel createHotel(Hotel hotel);
	List<Hotel> getAll();
	Hotel getSingle(String id);

}
