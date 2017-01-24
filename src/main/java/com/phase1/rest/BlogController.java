package com.phase1.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/blog")
public class BlogController {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/blog/{id}")
	public Response read(@PathParam("id") int number) {
		return Response.ok().build();
	}

	
}
