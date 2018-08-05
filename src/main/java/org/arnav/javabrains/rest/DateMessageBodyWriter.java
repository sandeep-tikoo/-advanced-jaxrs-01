package org.arnav.javabrains.rest;

import java.io.IOException;
import java.io.OutputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.Date;

import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.MessageBodyWriter;
import javax.ws.rs.ext.Provider;

@Provider
@Produces(MediaType.TEXT_PLAIN)
public class DateMessageBodyWriter implements MessageBodyWriter<Date>{

	@Override
	public boolean isWriteable(Class<?> type, Type genericType, Annotation[] annotations, MediaType mediaType) {
		// Checks the Type if the type that is passed is a Date, then returns true else false
		System.out.println("In Long Date isWriteable");
		return Date.class.isAssignableFrom(type);
	}

	@Override
	public void writeTo(Date date, Class<?> type, Type genericType, Annotation[] annotations, MediaType mediaType,
			MultivaluedMap<String, Object> httpHeaders, OutputStream entityStream)
			throws IOException, WebApplicationException {
		// Here we have control to write to HTTP stream by ourselves, Guess we can always use this to write our customem types
		// and control headers, etc.
//		mediaType.APPLICATION_JSON;
		System.out.println("In Long Date writeTo");
		httpHeaders.add("responseFrom", "Deepu");
		entityStream.write(date.toString().getBytes());
	}
}
