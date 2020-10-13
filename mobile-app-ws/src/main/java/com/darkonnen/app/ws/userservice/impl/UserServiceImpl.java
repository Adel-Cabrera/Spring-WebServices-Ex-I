package com.darkonnen.app.ws.userservice.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.darkonnen.app.ws.shared.Utils;
import com.darkonnen.app.ws.ui.models.request.UserDetailsRequestModel;
import com.darkonnen.app.ws.ui.models.response.UserRest;
import com.darkonnen.app.ws.userservice.UserService;

@Service
public class UserServiceImpl implements UserService{
	
	Map<String, UserRest> users;
	Utils utils;
	
	public UserServiceImpl() {
		
	}
	
	@Autowired
	public UserServiceImpl(Utils utils) {
		this.utils = utils;
	}

	@Override
	public UserRest createUser(UserDetailsRequestModel userDetails) {
		
		UserRest returnValue = new UserRest();
		returnValue.setFirstName(userDetails.getFirstName());
		returnValue.setLastName(userDetails.getLastName());
		returnValue.setEmail(userDetails.getEmail());
		
		String userId = utils.generateUserId();
		returnValue.setUserID(userId);
		
		if(users == null) users = new HashMap<>();
		users.put(userId, returnValue);
		
		return returnValue;
	}

}
