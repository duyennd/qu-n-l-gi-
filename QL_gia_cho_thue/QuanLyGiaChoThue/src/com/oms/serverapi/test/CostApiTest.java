package com.oms.serverapi.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.HashMap;

import org.junit.Test;

import com.oms.bean.Cost;
import com.oms.serverapi.CostApi;


public class CostApiTest {
	private CostApi api = new CostApi();
	@Test
	public void testGetAllCost() {
		ArrayList<Cost> list= api.getCost(null);
		assertEquals("Error in getParking API!", list.size(), 6);
	}
	
	@Test(timeout = 1000)
	public void testResponse() {
		api.getCost(null);
	}
	
	@Test
	public void testUpdateCost() {
		ArrayList<Cost> list= api.getCost(null);
		assertTrue("No data", list.size() > 0);
		Cost cost = list.get(0);
		String newName= "O'Reilly";
		cost.setName(newName);
		api.updateCost(cost);
		
		HashMap<String, String> params = new HashMap<String, String>();
		params.put("Name", newName);
		list = api.getCost(params);
		assertTrue("Eror in updateBook API!", list.size() > 0);
		Cost newParking = api.getCost(params).get(0);
		assertEquals("Eror in updateParking API!", newParking.getName(), newName);
	}

}
