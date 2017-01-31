package com.phase1.api.bizInterface;

import com.phase1.api.dto.Users;
import com.phase1.api.exception.DuplicateUserNameException;
import com.phase1.api.exception.RegisterException;
import com.phase1.api.exception.UserNotFoundException;

public interface Register {

	public void addUser(Users user) throws InvalidUserDetailsException, DuplicateUserNameException, RegisterException;

	public Users updateUser(Users user) throws UserNotFoundException, RegisterException;
	
}
