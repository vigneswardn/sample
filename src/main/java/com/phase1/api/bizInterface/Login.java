package com.phase1.api.bizInterface;

import com.phase1.api.dto.Users;
import com.phase1.api.exception.InvalidPasswordException;
import com.phase1.api.exception.InvalidUserIdException;
import com.phase1.api.exception.InvalidUserNameException;
import com.phase1.api.exception.LoginException;
import com.phase1.api.exception.UserNotFoundException;

public interface Login {

	public Users getUserByName(Users user) throws InvalidUserIdException, InvalidUserNameException, InvalidPasswordException, LoginException ;
	
	public Users getUserById(Users user) throws UserNotFoundException, LoginException;
}
