package com.hs.mapp.ws;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.hs.mapp.model.User;
import com.hs.mapp.service.UserService;

@Component
@Path("/payment")
public class Print {

	@Autowired
	private UserService service;
	
	private Gson gson;
	
	@Autowired
	public void setGson(){
		gson = new GsonBuilder().setPrettyPrinting()
			    .disableHtmlEscaping()
			    .create();
	}
	
	@GET
	@Path("/test1")
	@Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
	public Response savePayment() {
		User user=new User();
		user.setUser_id("so don\u0027t try ");
		user.setPwd("so don't try ");
		return Response.status(200).entity(gson.toJson(user)).build();

	}
//	public static void main(String[] args) {
//		Gson gson = new Gson();
//		User user=new User();
//		user.setUser_id("so don\u0027t try ");
//		user.setPwd("so don't try ");
//		sýout
//	}

}