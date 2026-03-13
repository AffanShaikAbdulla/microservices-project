package com.userservice.serviceimpl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.query.JpqlQueryBuilder.WhereStep;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.userservice.demo.repo.UserRepository;
import com.userservice.entity.Hotel;
import com.userservice.entity.Rating;
import com.userservice.entity.User;
import com.userservice.exception.ResourceNotFoundException;
import com.userservice.extendsservice.HotelService;
import com.userservice.service.UserService;
@Service
public class UserServiceImpl implements UserService{
    @Autowired
	private UserRepository userRepository;
    private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
   @Autowired
  private HotelService hotelService;
    @Autowired
    public RestTemplate restTemplate;
	@Override
	public User saveUser(User user) {
		// TODO Auto-generated method stub
		//generate uniqueuserId - 
		String randomUserId =UUID.randomUUID().toString();
		System.out.println("before setting id"+randomUserId);
		user.setUserId(randomUserId);
		System.out.println("After assigning Id"+randomUserId);
		
		
		return userRepository.save(user);
	}

	@Override
	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		return userRepository.findAll();
		
	}

	@Override
	public User getUser(String userId) {
		// get user from db 
		User user = userRepository.findById(userId).orElseThrow(()-> new ResourceNotFoundException("user with given id not found on server" +userId));
	     //call rating service 
		 Rating[] ratingOfUser = restTemplate.getForObject(
				 "http://HOTELRATING/ratings/users/" + userId,
		            Rating[].class);
		 if(ratingOfUser==null || ratingOfUser.length==0) {
			 user.setRatings(List.of());
			 return user; // user has no ratings yet
		 }
		//List<Rating> ratingList = Arrays.stream(ratingOfUser).toList();
		List<Rating> ratingList = Arrays.asList(ratingOfUser);
		 //call hotel servie for each rating 
		List<Rating> updatedRatings = ratingList.stream().map(rating -> {
            // Use service name of Hotel Service registered in Eureka
//            ResponseEntity<Hotel> hotelResponse = restTemplate.getForEntity(
//                    "http://HotelService/hotels/" + rating.getHotelId(),
//                    Hotel.class);
			logger.info("Fetching hotel for hotelId :{}"+rating.getHotelId());
			Hotel hotel = hotelService.getHotel(rating.getHotelId());
            // hotel = hotelResponse.getBody();
            rating.setHotel(hotel); // set hotel inside rating
            return rating;
        }).collect(Collectors.toList());
		//attcach rating to user 
		user.setRatings(updatedRatings);
		return user;
			
		
	}

	@Override
	public User delete(String userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User updateUser(String userId) {
		// TODO Auto-generated method stub
		return null;
	}

}
