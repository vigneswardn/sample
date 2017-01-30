package com.phase1.api.bizInterface;

import com.phase1.api.dto.Users;

public interface Login {

	public Users getUserByName(Users user);
	
	public Users getUserById(Users user);
}
