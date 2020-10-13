package com.darkonnen.app.ws.ui.controller;

import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.darkonnen.app.ws.exceptions.UserServiceException;
import com.darkonnen.app.ws.ui.models.request.UpdateUserDetailsRequestModel;
import com.darkonnen.app.ws.ui.models.request.UserDetailsRequestModel;
import com.darkonnen.app.ws.ui.models.response.UserRest;
import com.darkonnen.app.ws.userservice.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
	
//	STORE USERS TEMPORARILY
	Map<String, UserRest> users;
	
	@Autowired
	UserService userService;	
	
	@GetMapping("")
	public String getUsers(@RequestParam(value="page", defaultValue = "1") int page, 
			@RequestParam(value="limit", defaultValue = "50") int limit, 
			@RequestParam(value="sort", defaultValue = "desc", required = false) String sort) {

		return String.format("getUsers was called with page %s and limit %s and sort %s", page, limit, sort);
	}

	
//	@GetMapping(path="/{userId}", produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
//	public UserRest getUser(@PathVariable("userId") String userId) {
//		UserRest returnValue = new UserRest();		
//		returnValue.setFirstName("Sergey");
//		returnValue.setLastName("Kargopolov");
//		returnValue.setEmail("test@test.com");
//		return returnValue;
//	}
	@GetMapping(path="/{userId}", produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<UserRest> getUser(@PathVariable String userId){
//		UserRest returnValue = new UserRest();		
//		returnValue.setFirstName("Sergey");
//		returnValue.setLastName("Kargopolov");
//		returnValue.setEmail("test@test.com");
		
//		String firstName = null;		
//		int firstNameLength = firstName.length();
		
		if(true) throw new UserServiceException("A user service exception is thrown");
		
		if(users.containsKey(userId)) {
			return new ResponseEntity<>(users.get(userId),HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		
//		return new ResponseEntity<UserRest>(HttpStatus.BAD_REQUEST);

	} 
	
	@PostMapping(consumes = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE}, 
			produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<UserRest> createUser(@Valid @RequestBody UserDetailsRequestModel userDetails) {
//		UserRest returnValue = new UserRest();
//		returnValue.setFirstName(userDetails.getFirstName());
//		returnValue.setLastName(userDetails.getLastName());
//		returnValue.setEmail(userDetails.getEmail());
//		
//		String userId = UUID.randomUUID().toString();
//		returnValue.setUserID(userId);
//		
//		if(users == null) users = new HashMap<>();
//		users.put(userId, returnValue);
		
		UserRest returnValue =  userService.createUser(userDetails);
		
		return new ResponseEntity<UserRest>(returnValue,HttpStatus.OK);
	}
	
	@PutMapping(path="/{userId}", consumes = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE}, 
			produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
	public UserRest updateUser(@PathVariable("userId") String userId, @Valid @RequestBody UpdateUserDetailsRequestModel userDetails) {
		UserRest storedUserDetails = users.get(userId);
		storedUserDetails.setFirstName(userDetails.getFirstName());
		storedUserDetails.setLastName(userDetails.getLastName());
		users.put(userId, storedUserDetails);
		return storedUserDetails;
	}
	
	@DeleteMapping(path="/{userId}")
	public ResponseEntity<Void> deleteUser(@PathVariable("userId") String userId) {
		users.remove(userId);
		return ResponseEntity.noContent().build();
		
	}
	
}
