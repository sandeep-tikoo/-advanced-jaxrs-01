package org.arnav.javabrains.rest;

import javax.inject.Singleton;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;
import javax.xml.bind.annotation.XmlRootElement;

@Path ("test")
@XmlRootElement
@Produces(MediaType.APPLICATION_JSON)
//@Singleton
//If the @Singleton annotation is used, each time when the resource is hitted, 
//it will not initialize, means on each request a new instance of the class is not created. 
public class MyResource {
		
	public static Integer Count = 0;
	@QueryParam("name") private String queryParam; 
//	private int Count;
//when use use static in the variable declaration, the value will not be initialised when the class is called, 
//it will keep the last session's value
//	
//	public static List<Long> addCallCount()	{
//		return CallCount;
//	}
		
    	@GET
//		public TestObject testMethod(@Context UriInfo uriInfo)	{
//    	Since now this method conditionally returns two different types of object, so changed return type of method to <Object>
    	public Object testMethod(@Context UriInfo uriInfo)	{
    		
    		System.out.println("queryParam: " + queryParam);
    		
			String passLink = uriInfo.getAbsolutePath().toString();

			// Call constructor, Pass link and last Counter to it and 
			//it will return with setted values in the object fields.
			TestObject testObjectIns = new TestObject(passLink, Count ); 
			Count = testObjectIns.getCallCounter(); //Store Call counter in the sesssion
			if (Count > 20)	{
				ErrorMessage error = new ErrorMessage("Too many calls", 999, "Please restart the server", passLink);
				return error;
			}
			return testObjectIns; // Return setted java object, which will later be converted into JSON
		}
}