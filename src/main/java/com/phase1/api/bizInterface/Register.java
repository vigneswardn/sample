package com.phase1.api.bizInterface;

import com.phase1.api.dto.Users;
import com.phase1.api.exception.DuplicateUserNameException;
import com.phase1.api.exception.InvalidEmailException;
import com.phase1.api.exception.InvalidPasswordException;
import com.phase1.api.exception.InvalidPhoneNumberException;
import com.phase1.api.exception.PasswordNotMatchingException;
import com.phase1.api.exception.RegisterException;
import com.phase1.api.exception.UserNotFoundException;

public interface Register {

	public void addUser(Users user) throws DuplicateUserNameException, InvalidPasswordException, PasswordNotMatchingException,InvalidPhoneNumberException,InvalidEmailException, RegisterException;

	public Users updateUser(Users user) throws UserNotFoundException, InvalidPasswordException, PasswordNotMatchingException,InvalidPhoneNumberException,InvalidEmailException, RegisterException;
	
}
