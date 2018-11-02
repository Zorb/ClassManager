package com.cognizant.endpoint;

import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.cognizant.service.ClassService;

@Path("/class")
public class ClassEndpoint {

	@Inject
	private ClassService service;

	@Path("/json")
	@GET
	@Produces({ "application/json" })
	public String getAllClasses() {
		return service.getAllClasses();
	}

	@Path("/json")
	@POST
	@Produces({ "application/json" })
	public String createClass(String classroom) {
		return service.createClass(classroom);
	}

	@Path("/json/{id}")
	@PUT
	@Produces({ "application/json" })
	public String updateClass(@PathParam("id") Long id, String classroom) {
		return service.updateClass(id, classroom);
	}

	@Path("/json/{id}")
	@DELETE
	@Produces({ "application/json" })
	public String deleteClass(@PathParam("id") Long id) {
		return service.deleteClass(id);

	}

	public void setService(ClassService service) {
		this.service = service;
	}

}
