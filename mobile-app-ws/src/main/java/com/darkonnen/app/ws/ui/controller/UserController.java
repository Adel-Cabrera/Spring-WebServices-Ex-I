package com.darkonnen.app.ws.ui.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.darkonnen.app.ws.ui.models.request.UserDetailsRequestModel;
import com.darkonnen.app.ws.ui.models.response.UserRest;

@RestController
@RequestMapping("/users")
public class UserController {
	
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
	public ResponseEntity<UserRest> getUser(){
		UserRest returnValue = new UserRest();		
		returnValue.setFirstName("Sergey");
		returnValue.setLastName("Kargopolov");
		returnValue.setEmail("test@test.com");
		return new ResponseEntity<UserRest>(returnValue,HttpStatus.OK);
//		return new ResponseEntity<UserRest>(HttpStatus.BAD_REQUEST);

	} 
	
	@PostMapping(consumes = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE}, 
			produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<UserRest> createUser(@RequestBody UserDetailsRequestModel userDetails) {
		UserRest returnValue = new UserRest();		
		returnValue.setFirstName(userDetails.getFirstName());
		returnValue.setLastName(userDetails.getLastName());
		returnValue.setEmail(userDetails.getEmail());
		return new ResponseEntity<UserRest>(returnValue,HttpStatus.OK);
	}
	
	@PutMapping("")
	public String updateUser() {
		return "updateUser was called";
	}
	
	@DeleteMapping("")
	public String deleteUser() {
		return "deleteUser was called";
	}
	
}
