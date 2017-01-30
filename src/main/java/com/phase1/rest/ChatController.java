package com.phase1.rest;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.phase1.api.dto.Chat;
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

	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/addChat/")
	public Response addChat(Chat chatMsg) {
		ChatImpl impl = new ChatImpl();
		impl.addChatMessages(chatMsg);
		return Response.ok().build();
	}
}
