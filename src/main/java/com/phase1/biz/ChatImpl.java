package com.phase1.biz;

import java.util.List;

import com.phase1.api.bizInterface.ChatMessage;
import com.phase1.api.dto.Chat;
import com.phase1.api.exception.ChatException;
import com.phase1.data.ChatDAO;
import com.phase1.data.ChatDAOImpl;

public class ChatImpl implements ChatMessage {

	ChatDAO chatDAO;
	
	public ChatImpl() {
		chatDAO = new ChatDAOImpl();
	}

	@Override
	public List<Chat> getChatMessages() {
		List<Chat> chats = chatDAO.getChats();
		return chats;
	}

	@Override
	public List<Chat> addChatMessages(Chat chatMsg) {
		try {
			chatDAO.create(chatMsg);	
		} catch(Exception e) {
			throw new ChatException("In add chat messages : "+e.getMessage());
		}
		
		return getChatMessages();
	}

}
