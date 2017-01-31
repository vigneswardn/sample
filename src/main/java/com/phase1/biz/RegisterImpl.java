package com.phase1.biz;

import javax.persistence.NoResultException;

import com.phase1.api.bizInterface.Register;
import com.phase1.api.dto.Users;
import com.phase1.api.exception.DuplicateUserNameException;
import com.phase1.api.exception.RegisterException;
import com.phase1.api.exception.UserNotFoundException;
import com.phase1.data.UserDAO;
import com.phase1.data.UserDAOImpl;

public class RegisterImpl implements Register {

	private UserDAO userDAO;
	public RegisterImpl() {
		userDAO = new UserDAOImpl();
	}

	public void addUser(Users user) throws DuplicateUserNameException, RegisterException {
		try{
			Users dbUser = userDAO.readByName(user);
			if(dbUser != null) {
				throw new DuplicateUserNameException("User Name already exists");
			}
		}catch (NoResultException nre) {
			//ignore
		}
		userDAO.create(user);
	}

	public Users updateUser(Users user) throws UserNotFoundException, RegisterException {
		//Users dbUser = userDAO.readById(user);
		/*if(dbUser == null) {
			throw new UserNotFoundException("Unable to find User");
		}*/
		user = userDAO.update(user);
		return user;
	}

}
