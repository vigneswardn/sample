package com.phase1.rest;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.phase1.api.dto.Blog;
import com.phase1.api.dto.Comments;
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
		impl.getBlog(blog);
		return Response.ok().entity(blog).build();
	}
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/getBlog/")
	public Response getBlog() {
		BloggerImpl impl = new BloggerImpl();
		List<Blog> blogs = impl.searchBlog("searchContent");
		/*
		 * pending
		 */
		return Response.ok().entity(blogs).build();
	}
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/addBlog/")
	public Response addBlog(Blog blog) {
		BloggerImpl impl = new BloggerImpl();
		impl.addBlog(blog);
		return Response.ok().entity(blog).build();
	}
	
	@PUT
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
	@Path("/getComments/")
	public Response getComments(Blog blog) {
		BloggerImpl impl = new BloggerImpl();
		List<Comments> comments = (List<Comments>) impl.getComments(blog);
		return Response.ok().entity(comments).build();
	}
	
	
}
