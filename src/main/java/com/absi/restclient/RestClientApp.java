package com.absi.restclient;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class RestClientApp
{
	public static void main(String args[])
	{
		getMethod();
		postMethod();
	}


	static private void getMethod()
	{
		try
		{
			Client client = Client.create();

			WebResource webResource = client.resource("http://localhost:8080/restapp3/res/json/get");
		
			ClientResponse response = webResource.accept("application/json").get(ClientResponse.class);
		
			if(response.getStatus() != 200)
			{
				throw new RuntimeException("Failed : HTTP error code : " + response.getStatus());
			}	

			String output = response.getEntity(String.class);
			System.out.println("Output from server ... \n");
			System.out.println(output);
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
						
	}


	static private void postMethod()
	{
		try
		{
			Client client = Client.create();

			WebResource webResource = client.resource("http://localhost:8080/restapp3/res/json/post");

			String input = "{\"singer\":\"Metallica\",\"title\":\"Fade to black\"}";

			ClientResponse response = webResource.type("application/json").post(ClientResponse.class, input);

			if(response.getStatus() != 201)
				throw new RuntimeException("Failed : HTTP error code :" + response.getStatus());

			System.out.println("Output from server ... \n");
			String output = response.getEntity(String.class);
			System.out.println(output);	
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	} 
}