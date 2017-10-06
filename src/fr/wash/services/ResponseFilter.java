package fr.wash.services;

import java.io.IOException;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.ext.Provider;

@Provider
public class ResponseFilter implements ContainerResponseFilter {

	@Override
	public void filter(ContainerRequestContext requestContext, ContainerResponseContext responseContext)
			throws IOException {
		// TODO Auto-generated method stub
		responseContext.getHeaders().add("toto", "tttb");
		
		responseContext.getHeaders().add("Access-Control-Allow-Origin", "http://localhost:4200");
		responseContext.getHeaders().add("Access-Control-Allow-Headers","origin, content-type, accept, authorization,id");
		
		responseContext.getHeaders().add("Access-Control-Allow-Credentials","true");
		responseContext.getHeaders().add("Access-Control-Allow-Methods",
                "GET, POST, PUT, DELETE, OPTIONS, HEAD");
		
	}

}
