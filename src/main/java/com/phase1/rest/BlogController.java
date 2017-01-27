package com.phase1.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.phase1.api.dto.Blog;
import com.phase1.biz.BloggerImpl;

@Path("/blog")
public class BlogController {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("getBlog/{blogId}")
	public Response getBlog(@PathParam("blogId") String blogId) {
		BloggerImpl impl = new BloggerImpl();
		Blog blog = new Blog();
		blog.setBlogId(Integer.valueOf(blogId));
		impl.getBlog(blog);
		return Response.ok().entity(blog).build();
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
	@Path("/updateBlog/")
	public Response updateBlog(Blog blog) {
		BloggerImpl impl = new BloggerImpl();
		impl.updateBlog(blog);
		return Response.ok().entity(blog).build();
	}
}
