package com.ABPApp.ws.rest.service;

import java.util.Date;

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

import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Path("/ABPApp")
public class ServiceLogin {
	
	private String key = "AdyQYdno}ka~]iXGzc+4";
	private long time;
	
	@POST
	@Path("/ValidarUsuario")
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
	public Response ValidarUsuario(VOUsuario user) {
		DAOUsuario daou = new DAOUsuario();
		VOUsuario stat = daou.isUserName(user.getUsuario());
		if(stat != null) {
			String jwt = Jwts.builder()
					.signWith(SignatureAlgorithm.HS256, key)
					.setSubject(stat.getUsuario())
					.setSubject(stat.getTipo())
					.setIssuedAt(new Date(time))
					.setExpiration(new Date(time+900000))
					.compact();
			JsonObject jsob = (JsonObject) Json.createObjectBuilder()
					.add("JWT", jwt);
			return Response.status(Response.Status.CREATED).entity(jsob).build();
		}
		return Response.status(Response.Status.UNAUTHORIZED).build();		
	}
	
}
