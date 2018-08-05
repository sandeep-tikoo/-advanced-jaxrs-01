package org.arnav.javabrains.rest;

import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import javax.enterprise.inject.Produces;
import javax.ws.rs.GET;

@Path("date")
public class DataResource {

	@GET
//	@Produces(MediaType.TEXT_PLAIN)
	@Path("{dateString}")
	public String getRequestedDate(@PathParam("dateString") MyDate myDate) {
		return "Today: " + myDate.toString();
	}
}
