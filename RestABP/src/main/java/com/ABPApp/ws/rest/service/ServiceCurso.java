package com.ABPApp.ws.rest.service;

import javax.json.Json;
import javax.json.JsonObject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.ABPApp.ws.rest.dao.DAOCurso;
import com.ABPApp.ws.rest.vo.VOCurso;

@Path("/ABPApp")
public class ServiceCurso {
	
	@POST
	@Path("/AddCurso")
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
	public Response AddCurso(VOCurso curso) {
		DAOCurso dac = new DAOCurso();
		if(dac.addCurso(curso)) {
			JsonObject jsob = (JsonObject) Json.createObjectBuilder()
					.add("Status", "hecho");
			return Response.status(Response.Status.CREATED).entity(jsob).build();
		}
		JsonObject jsob = (JsonObject) Json.createObjectBuilder()
				.add("status", "Error");
		return Response.status(Response.Status.CREATED).entity(jsob).build();
	}
	
	@POST
	@Path("/BuscarCurso")
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
	public Response BuscarCurso(String curso) {
		DAOCurso dac = new DAOCurso();
		if(dac.isCursoName(curso)!=null) {
			JsonObject jsob = (JsonObject) Json.createObjectBuilder()
					.add("Status", "hecho");
			return Response.status(Response.Status.CREATED).entity(jsob).build();
		}
		JsonObject jsob = (JsonObject) Json.createObjectBuilder()
				.add("status", "Error");
		return Response.status(Response.Status.CREATED).entity(jsob).build();
	}
	
}