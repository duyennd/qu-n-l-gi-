package com.oms.serverapi.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import com.oms.bean.Cost;
import com.oms.serverapi.CostApi;

@RunWith(Parameterized.class)

public class ParameterizedCostApiTest {
	private String parkingName;
	private String expectedResult;
	
	private CostApi api = new CostApi();
	
	
	public ParameterizedCostApiTest(String parkingName, String expectedResult) {
		super();
		this.parkingName = parkingName;
		this.expectedResult = expectedResult;
	}
	

	@Parameterized.Parameters
	public static Collection<Object[]> primeNumbers() {
		return Arrays.asList(new Object[][] { 
			{ "A", "A bãi đỗ xe tạ quang bửu" },
			{ "B", "B bãi đỗ xe bách khoa" }, 
			{ "C", "C bãi đỗ xe hoàng hà" },
			{ "D", "D bãi đỗ xe thống nhất" },
			{ "E", "E bãi đỗ xe giáp bát" },
			{ "F", "F bãi đỗ xe mỹ đình" }
		});
	}
	
	@Test
	public void testGetCost() {
		HashMap<String, String> params = new HashMap<String, String>();
		params.put("name", parkingName);
		
		ArrayList<Cost> list= api.getCost(params);
		assertTrue("No data", list.size() > 0);
		
		
		Cost cost = list.get(0);
		assertEquals("Eror in getBooks API!", cost.getName(), expectedResult);
	}

}
