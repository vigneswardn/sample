package com.phase1.rest;

import java.util.List;
import java.util.Set;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import com.phase1.api.dto.Blog;
import com.phase1.api.dto.Comments;
import com.phase1.api.dto.Invites;
import com.phase1.api.dto.Users;
import com.phase1.biz.BloggerImpl;

@Path("/blog")
public class BlogController {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/getBlog/{blogId}/")
	public Response getBlog(@PathParam("blogId") String blogId) {
		BloggerImpl impl = new BloggerImpl();
		Blog blog = new Blog();
		blog.setBlogId(Integer.valueOf(blogId));
		blog = impl.getBlog(blog);
		return Response.ok().entity(blog).build();
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/searchBlog/{searchContent}")
	public Response searchBlog(@PathParam("searchContent")String searchContent) {
		BloggerImpl impl = new BloggerImpl();
		List<Blog> blogs = impl.searchBlog(searchContent);
		return Response.ok().entity(blogs).build();
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/addBlog/")
	public Response addBlog(Blog blog) {
		BloggerImpl impl = new BloggerImpl();
		impl.addBlog(blog);
		return Response.ok().entity(blog).build();
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/addComments/")
	public Response addComments(Blog blog) {
		BloggerImpl impl = new BloggerImpl();
		impl.addComments(blog);
		return Response.ok().entity(blog.getComments()).build();
	}
	
	@GET
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/getComments/{blogId}")
	public Response getComments(@PathParam("blogId")Integer blogId) {
		BloggerImpl impl = new BloggerImpl();
		Blog blog = new Blog();
		blog.setBlogId(blogId);
		Set<Comments> comments = (Set<Comments>) impl.getComments(blog);
		return Response.ok().entity(comments).build();
	}
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/inviteUsers/")
	public Response updateUser(Invites invites) {
		BloggerImpl impl = new BloggerImpl();
		String message = impl.inviteUsers(invites);
		return Response.ok().build();
	}
	
	@GET
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/getFavourites/{userId}")
	public Response getFavourites(@PathParam("userId")String userId) {
		Users user = new Users();
		System.out.println("user id **** : "+userId);
		user.setUserId(Integer.valueOf(userId));
		BloggerImpl impl = new BloggerImpl();
		List<Blog> blogs = (List<Blog>) impl.getAllFavourites(user);
		return Response.ok().entity(blogs).build();
	}
}
