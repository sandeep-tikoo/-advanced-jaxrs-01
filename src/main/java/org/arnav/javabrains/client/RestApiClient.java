package org.arnav.javabrains.client;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.arnav.javabrains.messenger.model.Message;

public class RestApiClient {

	public static void main(String[] args) {
		
		//We can use low level network methods/classes to do an HTTP call.
//		But jersey framework has some good methods which makes job easy
		Client client = ClientBuilder.newClient();
		
		
		//first thing is to tell client the targer, the url
//		String message = client.target("http://localhost:8080/advanced-jaxrs-01/newrest/messages/1")
//								  .request(MediaType.APPLICATION_JSON)
//								  .get(String.class);
//								  .get(Message.class) //Actually we have to return of this type, 
													  //but were to display we will return String for sisplay purposes
		//below code is to unwrap a message object from response wrapper. WRight now client does not know what sort of objwect is returned.
		// So we need to kinda map it to Message Object class, like copy-book concept :)
//		Message message = response.readEntity(Message.class);
//		System.out.println(message.getAuthor() + " , " + message.getCreated().toString() + " , " + message.getMessage());
		
		
		//Best Practice way of doing above is 
		WebTarget baseTarget = client.target("http://localhost:8080/advanced-jaxrs-01/newrest/");
		WebTarget messagesTarget = baseTarget.path("messages");
		WebTarget singleMessageTarget = messagesTarget.path("{messageId}");
		
		Message message1 = singleMessageTarget
				  .resolveTemplate("messageId", "1")
				  .request(MediaType.APPLICATION_JSON)
				  .get(Message.class);
		System.out.println(message1.getMessage());
		
		Message message2 = singleMessageTarget
				  .resolveTemplate("messageId", "5")
				  .request(MediaType.APPLICATION_JSON)
				  .get(Message.class);
		System.out.println(message2.getMessage());
		
//		Creating a POST request
		Message newMessage = new Message(5,"Message created by JAX-RS Client", "Hi Implementation there");
		Response postResponse = messagesTarget
		.request()
		.post(Entity.json(newMessage));
		//Above is to wrap the message in entity like we did when we got the object in GET (Read Entity).
		System.out.println("HTTP Status: " + postResponse.getStatus());
		if (postResponse.getStatus() != 201)	{
			
			System.out.println("Posting failed");
		}
		System.out.println(postResponse.readEntity(String.class));
				

	}

}
