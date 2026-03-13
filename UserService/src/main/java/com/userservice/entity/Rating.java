package com.userservice.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Rating {
	//ratingId, which user?, which hotelId, how much rating?,anything about rating 
	private String ratingId;
	private String userId;
	private String hotelId;
	private int rating;
	private String ramark;
	private Hotel hotel;
	

}
