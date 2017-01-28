package com.phase1.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.phase1.api.dto.Users;
import com.phase1.biz.LoginImpl;
import com.phase1.biz.RegisterImpl;

@Path("/user")
public class UserController {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("getUser/{userId}")
	public Response getUser(@PathParam("userId") String userId) {
		LoginImpl impl = new LoginImpl();
		Users user = new Users();
		user.setUserId(Integer.valueOf(userId));
		user = impl.getUser(user);
		return Response.ok().entity(user).build();
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/addUser/")
	public Response addUser(Users user) {
		RegisterImpl impl = new RegisterImpl();
		impl.addUser(user);
		return Response.ok().entity(user).build();
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/updateUser/")
	public Response updateUser(Users user) {
		RegisterImpl impl = new RegisterImpl();
		user = impl.updateUser(user);
		return Response.ok().entity(user).build();
	}
	
}