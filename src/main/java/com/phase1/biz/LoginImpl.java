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
		user = userDAO.readByName(user);
		if(user == null) {
			throw new InvalidUserNameException("Invalid user name");
		}
		return user;
	}

	@Override
	public Users getUserById(Users user) {
		user = userDAO.readById(user);
		if(user == null) {
			throw new UserNotFoundException();
		}
		return user;
	}

}
