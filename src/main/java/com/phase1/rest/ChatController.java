package com.phase1.rest;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.phase1.api.dto.Chat;
import com.phase1.api.exception.ChatException;
import com.phase1.biz.ChatImpl;

@Path("/chat")
public class ChatController {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/getChats/")
	public Response getChats() {
		ChatImpl impl = new ChatImpl();
		List<Chat> chats = impl.getChatMessages();
		return Response.ok().entity(chats).build();
	}

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/addChat/")
	public Response addChat(Chat chatMsg) {
		if(chatMsg == null || chatMsg.getMessage() == null) {
			throw new ChatException("Please provide chat details");
		}
		ChatImpl impl = new ChatImpl();
		List<Chat> chats = impl.addChatMessages(chatMsg);
		return Response.ok().entity(chats).build();
	}
}
