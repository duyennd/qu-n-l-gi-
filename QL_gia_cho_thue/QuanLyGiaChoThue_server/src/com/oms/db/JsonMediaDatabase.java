package com.oms.db;

import java.util.ArrayList;
import com.oms.bean.Cost;
import com.oms.db.seed.Seed;

public class JsonMediaDatabase implements IMediaDatabase{
	private static IMediaDatabase singleton = new JsonMediaDatabase();
	private ArrayList<Cost> costs = Seed.singleton().getCost();
	
	private JsonMediaDatabase() {
	}
	
	public static IMediaDatabase singleton() {
		return singleton;
	}

	@Override
	public ArrayList<Cost> searchCost(Cost cost) {
		ArrayList<Cost> res = new ArrayList<Cost>();
		for (Cost b: costs) {
			if (b.match(cost)) {
				res.add(b);
			}
		}
		return res;
	}

	@Override
	public Cost addCost(Cost cost) {
		for (Cost m: costs) {
			if (m.equals(cost)) {
				return null;
			}
		}
		
		costs.add(cost);
		return cost;
	}
	
	@Override
	public Cost updateCost(Cost cost) {
		for (Cost m: costs) {
			if (m.equals(cost)) {
				costs.remove(m);
				costs.add(cost);
				return cost;
			}
		}
		return null;
	}

	@Override
	public Cost deleteCost(Cost cost) {
		for (Cost m: costs) {
			if (m.equals(cost)) {
				costs.remove(m);
				return cost;
			}
		}
		return null;
	}
}
