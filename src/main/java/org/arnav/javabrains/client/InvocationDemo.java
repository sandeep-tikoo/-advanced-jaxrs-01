package org.arnav.javabrains.client;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

//Has 2 Steps
//1. To build the request
//2. To execute it

public class InvocationDemo {

	public static void main(String[] args) {
		
		InvocationDemo demo = new InvocationDemo();
		//Below will return the invocation object returned by 
		//prepareRequestForMessagesByYear functions implementation 
		Invocation invocation = demo.prepareRequestForMessagesByYear(2015);
		//below will actuall send the HTTP request by send the invocation object over HTTP
		Response response = invocation.invoke(); 
		
		System.out.println("Response Status: " + response.getStatus());

	}
	
	public Invocation prepareRequestForMessagesByYear(int year)	{
//Idea here is just to build the whole message GET object and execute is somewhere else.
//This way we hid the logic from the class which actually does GET, to make that generic.
		Client client = ClientBuilder.newClient();
		return client.target("http://localhost:8080/advanced-jaxrs-01/newrest/")
								.path("messages")
								.queryParam("year", year)
								.request(MediaType.APPLICATION_JSON)
								.buildGet();
	}

}
