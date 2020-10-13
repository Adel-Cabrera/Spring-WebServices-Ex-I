package com.darkonnen.app.ws.userservice;

import com.darkonnen.app.ws.ui.models.request.UserDetailsRequestModel;
import com.darkonnen.app.ws.ui.models.response.UserRest;

public interface UserService {
	
	UserRest createUser(UserDetailsRequestModel userDetails);

}
