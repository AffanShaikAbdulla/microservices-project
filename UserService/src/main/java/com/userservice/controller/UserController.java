package com.userservice.controller;

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

import com.userservice.entity.User;
import com.userservice.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
	@Autowired
	private UserService userService;
	// create, single user get, multiple users, 
	@PostMapping("/create")
	public ResponseEntity<User> createUser(@RequestBody User user){
		System.out.println("userdetails"+user);
	User user1=userService.saveUser(user);
	return ResponseEntity.status(HttpStatus.CREATED).body(user1);
	}
  //single
	@GetMapping("/{userId}")
	public ResponseEntity<User> getSingleUser(@PathVariable String userId){
	User user =userService.getUser(userId);
	return ResponseEntity.ok(user);
	}
	//list of users
	@GetMapping
	public ResponseEntity<List<User>> getAllUsers(){
	List<User> allUsers=userService.getAllUsers();
	return ResponseEntity.ok(allUsers);
	}

}
