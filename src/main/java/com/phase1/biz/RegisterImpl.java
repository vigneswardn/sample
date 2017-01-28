package com.phase1.biz;

import com.phase1.api.bizInterface.Register;
import com.phase1.api.dto.Users;
import com.phase1.api.exception.DuplicateUserNameException;
import com.phase1.api.exception.InvalidEmailException;
import com.phase1.api.exception.InvalidPasswordException;
import com.phase1.api.exception.InvalidPhoneNumberException;
import com.phase1.api.exception.PasswordNotMatchingException;
import com.phase1.api.exception.RegisterException;
import com.phase1.api.exception.UserNotFoundException;
import com.phase1.data.UserDAO;
import com.phase1.data.UserDAOImpl;

public class RegisterImpl implements Register {

	private UserDAO userDAO;
	public RegisterImpl() {
		userDAO = new UserDAOImpl();
	}

	public void addUser(Users user) throws DuplicateUserNameException, InvalidPasswordException,
			PasswordNotMatchingException, InvalidPhoneNumberException, InvalidEmailException, RegisterException {
		// validations
		userDAO.create(user);
	}

	public Users updateUser(Users user) throws UserNotFoundException, InvalidPasswordException,
			PasswordNotMatchingException, InvalidPhoneNumberException, InvalidEmailException, RegisterException {
		// validations
		user = userDAO.update(user);
		return user;
	}

}
