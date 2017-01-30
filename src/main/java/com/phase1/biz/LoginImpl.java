package com.phase1.biz;

import com.phase1.api.bizInterface.Login;
import com.phase1.api.dto.Users;
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
		return user;
	}

	@Override
	public Users getUserById(Users user) {
		user = userDAO.readById(user);
		return user;
	}

}
