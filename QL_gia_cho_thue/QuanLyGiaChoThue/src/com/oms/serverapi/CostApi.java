package com.oms.serverapi;

import java.util.ArrayList;
import java.util.Map;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.oms.bean.Cost;


public class CostApi {
	public static final String PATH = "http://localhost:8080/";
	
	private Client client;
	
	public CostApi() {
		client = ClientBuilder.newClient();
	}
	
	

	public ArrayList<Cost> getCost(Map<String, String> queryParams) {
		WebTarget webTarget = client.target(PATH).path("cost");
		
		
		if (queryParams != null) {
			for (String key : queryParams.keySet()) {
				String value = queryParams.get(key);
				webTarget = webTarget.queryParam(key, value);
			}
		}
		

		Invocation.Builder invocationBuilder = webTarget.request(MediaType.APPLICATION_JSON);
		Response response = invocationBuilder.get();
		ArrayList<Cost> res = response.readEntity(new GenericType<ArrayList<Cost>>() {});
		System.out.println(res);
		return res;
	}
	

	public Cost updateCost(Cost cost) {
		WebTarget webTarget = client.target(PATH).path("cost").path(cost.getId());
		
		Invocation.Builder invocationBuilder =  webTarget.request(MediaType.APPLICATION_JSON);
		Response response = invocationBuilder.post(Entity.entity(cost, MediaType.APPLICATION_JSON));
		
		Cost res = response.readEntity(Cost.class);
		return res;
	}
	//
	public Cost addCost(Cost cost) {
		WebTarget webTarget = client.target(PATH).path("cost").path("add");
		
		Invocation.Builder invocationBuilder =  webTarget.request(MediaType.APPLICATION_JSON);
		Response response = invocationBuilder.post(Entity.entity(cost, MediaType.APPLICATION_JSON));
		
		Cost res = response.readEntity(Cost.class);
		return res;
	}



	public Cost deleteCost(Cost cost) {
		WebTarget webTarget = client.target(PATH).path("cost").path("delete");
		
		Invocation.Builder invocationBuilder =  webTarget.request(MediaType.APPLICATION_JSON);
		Response response = invocationBuilder.post(Entity.entity(cost, MediaType.APPLICATION_JSON));
		
//		Parking res = response.readEntity(Parking.class);
		return null;
	}
	
	
	
	
	
}
