package com.oms.service;
import java.util.ArrayList;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import com.oms.bean.Cost;
import com.oms.db.IMediaDatabase;
import com.oms.db.JsonMediaDatabase;

@Path("/cost")
public class CostService {

	private IMediaDatabase mediaDatabase;

	public CostService() {
		mediaDatabase = JsonMediaDatabase.singleton();
	}

	@GET
	@Path("")
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<Cost> getCost(@QueryParam("id") String id, @QueryParam("name") String name,
		@QueryParam("tienCoc") float tienCoc
			
			) {
		Cost cost = new Cost(id, name,tienCoc,0,0);
		cost.setName(name);
		cost.setTienCoc(tienCoc);
		ArrayList<Cost> res = mediaDatabase.searchCost(cost);
		return res;
	}
	

	@POST
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Cost updateCost(@PathParam("id") String id, Cost cost) {
		return mediaDatabase.updateCost(cost);
	}
	//
	@POST
	@Path("/add")
	@Produces(MediaType.APPLICATION_JSON)
	public Cost addCost(Cost cost) {
		Cost res = mediaDatabase.addCost(cost);
		return res;
	}
	
	@POST
	@Path("/delete")
	@Produces(MediaType.APPLICATION_JSON)
	public Cost deleteCost(Cost cost) {
		Cost res = mediaDatabase.deleteCost(cost);
		return res;
	}
}