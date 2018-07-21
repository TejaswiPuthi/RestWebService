package com.howtodoinjava.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;


@Path("/show-off-screen")
public class Sample
{
	@GET
	@Path("/{message}")
	public Response getMsg(@PathParam("message") String msg)
	{
		String output = "Samplemessage : " + msg;
		//Simply return the parameter passed as message
		return Response.status(200).entity(output).build();
	}
}
