package fr.wash.services;

import java.util.Date;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import fr.wash.dao.WashDaoImpl;
import fr.wash.entities.Contact;
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
	public Response getUsers(){
		
		return Response.ok().entity(dao.getAllObject("User")).build();
	}
	
	@GET
	@Path("/user/{id}")
	public User getUserById(@PathParam("id")int id){
		User user = new User();
		return (User) dao.findById(user, id);
	}
	
	@POST
	@Path("/user")
	public Response addUser(User user){
		dao = new WashDaoImpl();
		user.setDateCreate(new Date());
		dao.addObject(user);
		return Response.ok().entity(user).build();
	}
	
	@PUT
	@Path("/user")
	public User updateUser(User user){
		System.err.println("update");
		user.setDateUpdate(new Date());
		dao = new WashDaoImpl();
		return (User) dao.updateObject(user);
	}
	
	@POST
	@Path("/login")
	public Response login(User user){
		return Response.ok().entity(dao.login(user)).build();
	}
	
	//Contact
	@POST
	@Path("/contact")
	public Response addContact(Contact contact){
		System.out.println(contact.toString());
		contact.setDateCreate(new Date());
		contact.setStatus(0);
		dao = new WashDaoImpl();
		dao.addObject(contact);
		return Response.ok().entity(contact).build();
	}
	
	
	

}
