package com.phase1.data;

import com.phase1.api.dto.Users;

public interface UserDAO {

	public void create(Users user);
	
	public Users update(Users user);
	
	public Users read(Users user);
}
