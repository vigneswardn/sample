package com.phase1.biz;

import com.phase1.api.bizInterface.Login;
import com.phase1.api.dto.Users;
import com.phase1.api.exception.InvalidUserNameException;
import com.phase1.api.exception.UserNotFoundException;
import com.phase1.data.UserDAO;
import com.phase1.data.UserDAOImpl;

public class LoginImpl implements Login {
	
	UserDAO userDAO;

	public LoginImpl() {
		userDAO = new UserDAOImpl();
	}
	
	@Override
	public Users getUserByName(Users user) {
		try {
			user = userDAO.readByName(user);	
		} catch(Exception nre) {
			throw new InvalidUserNameException(nre.getMessage());
		}
		
		return user;
	}

	@Override
	public Users getUserById(Users user) {
		try {
			user = userDAO.readById(user);
		} catch(Exception nre) {
			throw new UserNotFoundException(nre.getMessage());
		}
		return user;
	}

}
