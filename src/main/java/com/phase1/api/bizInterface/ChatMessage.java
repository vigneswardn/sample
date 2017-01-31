package com.phase1.api.bizInterface;

import java.util.List;

import com.phase1.api.dto.Chat;
import com.phase1.api.exception.ChatException;

public interface ChatMessage {

	public List<Chat> getChatMessages() throws ChatException;
	
	public List<Chat> addChatMessages(Chat chatMsg) throws ChatException;
}
