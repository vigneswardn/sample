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
	public Users getUser(Users user) {
		user = userDAO.read(user);
		return user;
	}

}
