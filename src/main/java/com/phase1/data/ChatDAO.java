package com.phase1.data;

import java.util.List;

import com.phase1.api.dto.Chat;

public interface ChatDAO {

	public void create(Chat chatMsg);
	
	public List<Chat> getChats();
}
