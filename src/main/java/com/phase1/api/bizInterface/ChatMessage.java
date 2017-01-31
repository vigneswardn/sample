package com.phase1.api.bizInterface;

import java.util.List;

import com.phase1.api.dto.Chat;

public interface ChatMessage {

	public List<Chat> getChatMessages();
	
	public List<Chat> addChatMessages(Chat chatMsg);
}
