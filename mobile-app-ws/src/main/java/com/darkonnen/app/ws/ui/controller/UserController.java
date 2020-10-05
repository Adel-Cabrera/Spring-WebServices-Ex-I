package com.darkonnen.app.ws.ui.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {
	
	@GetMapping("")
	public String getUsers(@RequestParam(value="page", defaultValue = "1") int page, 
			@RequestParam(value="limit", defaultValue = "50") int limit, 
			@RequestParam(value="sort", defaultValue = "desc", required = false) String sort) {

		return String.format("getUsers was called with page %s and limit %s and sort %s", page, limit, sort);
	}

	
	@GetMapping(path="/{userId}")
	public String getUser(@PathVariable("userId") String userId) {
		return "getUser was called with userId = " + userId;
	}
	
	@PostMapping("")
	public String createUser() {
		return "createUser was called";
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
