package de.fhws.mobileapps.vorlesung5.backend;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Path("rest")
public class Resource 
{
	@GET
	@Produces( "text/html" )
	public String printHelloWorld( )
	{
		return "Hello World";
	}
}
