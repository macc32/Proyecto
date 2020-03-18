package com.ABPApp.ws.rest.service;
import javax.json.Json;
import javax.json.JsonObject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import com.ABPApp.ws.rest.dao.DAOUsuario;
import com.ABPApp.ws.rest.vo.VOUsuario;

@Path("/ABPApp")
public class ServiceRegister {
	@POST
	@Path("/RegistrarUsuario")
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
	public Response RegistrarUsuario(VOUsuario user) {
		DAOUsuario daou = new DAOUsuario();
		if(daou.addUser(user)!=false) {
			JsonObject jsob = (JsonObject) Json.createObjectBuilder()
					.add("Status", "hecho");
			return Response.status(Response.Status.CREATED).entity(jsob).build();
		}
		JsonObject jsob = (JsonObject) Json.createObjectBuilder()
				.add("status", "Error");
		return Response.status(Response.Status.CREATED).entity(jsob).build();
	}
}
