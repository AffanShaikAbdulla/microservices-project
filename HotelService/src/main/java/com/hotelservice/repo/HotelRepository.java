package com.hotelservice.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hotelservice.entity.Hotel;

public interface HotelRepository extends JpaRepository<Hotel, String>{

}
