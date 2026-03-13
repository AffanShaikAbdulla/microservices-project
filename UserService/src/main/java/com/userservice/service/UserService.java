package com.userservice.service;

import java.util.List;

import com.userservice.entity.User;

public interface UserService {
//user operations ,  saveuser, getAllUsers, list of users,get single user of given userId
	
	User saveUser(User user);
	//getall users 
	List<User> getAllUsers();
	//
	User getUser(String userId);
	User delete(String userId);
	User updateUser(String userId);
	
}
