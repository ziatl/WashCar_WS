package fr.wash.services;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import fr.wash.dao.WashDaoImpl;
import fr.wash.entities.User;

@Path("/rest")
@Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
public class WashService {
	
	WashDaoImpl dao;
	public WashService() {
		// TODO Auto-generated constructor stub
		dao = new WashDaoImpl();
	}
	@GET
	@Path("/test")
	public String test(){	
		return "Ok Ok";
	}
	
	@GET
	@Path("/user")
	public List<Object> getUsers(){
		
		return dao.getAllObject("User");
	}
	
	@GET
	@Path("/user/{id}")
	public User getUserById(@PathParam("id")int id){
		User user = new User();
		return (User) dao.findById(user, id);
	}
	
	@POST
	@Path("/user")
	public User addUser(User user){
		dao = new WashDaoImpl();
		dao.addObject(user);
		return user;
	}
	
	@PUT
	@Path("/user")
	public User updateUser(User user){		
		dao = new WashDaoImpl();
		return (User) dao.updateObject(user);
	}
	
	
	

}
