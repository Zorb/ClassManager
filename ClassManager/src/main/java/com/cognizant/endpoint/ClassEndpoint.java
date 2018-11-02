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

	@Path("/jsontr")
	@GET
	@Produces({ "application/json" })
	public String getAllTrainees() {
		return service.getAllTrainees();
	}
	@Path("/json")
	@POST
	@Produces({ "application/json" })
	public String createClass(String classroom) {
		return service.createClass(classroom);
	}

	@Path("/jsontr")
	@POST
	@Produces({ "application/json" })
	public String createTrainee(String trainee) {
		return service.createTrainee(trainee);
	}

	@Path("/json/{id}")
	@PUT
	@Produces({ "application/json" })
	public String updateClass(@PathParam("id") Long id, String classroom) {
		return service.updateClass(id, classroom);
	}

	@Path("/jsontr/{id}")
	@PUT
	@Produces({ "application/json" })
	public String updateTrainee(@PathParam("id") Long id, String trainee) {
		return service.updateTrainee(id, trainee);
	}

	@Path("/jsontr/{id}")
	@DELETE
	@Produces({ "application/json" })
	public String deleteTrainee(@PathParam("id") Long id) {
		return service.deleteTrainee(id);

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
