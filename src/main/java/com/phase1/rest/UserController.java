package com.phase1.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.phase1.api.bizInterface.InvalidUserDetailsException;
import com.phase1.api.dto.Users;
import com.phase1.api.exception.InvalidUserIdException;
import com.phase1.api.exception.InvalidUserNameException;
import com.phase1.biz.LoginImpl;
import com.phase1.biz.RegisterImpl;

@Path("/user")
public class UserController {
	
	/**
	 * To get User information based on user id
	 * 
	 * @param userId
	 * @return {@link Users}
	 */
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/getUser/{userId}")
	public Response getUser(@PathParam("userId") String userId) {
		if(userId == null) {
			throw new InvalidUserIdException("Please provide user id");
		}
		LoginImpl impl = new LoginImpl();
		Users user = new Users();
		user.setUserId(Integer.valueOf(userId));
		user = impl.getUserById(user);
		return Response.ok().entity(user).build();
	}
	
	/**
	 * To get user based on username and password
	 * 
	 * @param user
	 * @return {@link Users}
	 */
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/getUser/")
	public Response getUser(Users user) {
		if(user == null || user.getUserName() == null || user.getPassword() == null) {
			throw new InvalidUserNameException("Please provide user name");
		}
		LoginImpl impl = new LoginImpl();
		user = impl.getUserByName(user);
		return Response.ok().entity(user).build();
	}
	
	/**
	 * To add users
	 * 
	 * @param user
	 * @return
	 */
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/addUser/")
	public Response addUser(Users user) {
		if(user == null || user.getUserName() == null || user.getEmail() == null || user.getFirstName() == null) {
			throw new InvalidUserDetailsException("Please provide all mandatory fields.");
		}
		RegisterImpl impl = new RegisterImpl();
		impl.addUser(user);
		return Response.ok().entity(user).build();
	}
	
	/**
	 * To update User
	 * 
	 * @param user
	 * @return
	 */
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/updateUser/")
	public Response updateUser(Users user) {
		if(user == null || user.getUserId() == null) {
			throw new InvalidUserIdException("Invalid user id");
		}
		RegisterImpl impl = new RegisterImpl();
		user = impl.updateUser(user);
		return Response.ok().entity(user).build();
	}
	
}
