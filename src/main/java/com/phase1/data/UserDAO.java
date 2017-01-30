package com.phase1.data;

import com.phase1.api.dto.Users;

public interface UserDAO {

	public void create(Users user);
	
	public Users update(Users user);
	
	public Users readById(Users user);
	
	public Users readByName(Users user);
}
