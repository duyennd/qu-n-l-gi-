package com.oms.db;

import java.util.ArrayList;

import com.oms.bean.Cost;

public interface IMediaDatabase {
	public ArrayList<Cost> searchCost(Cost cost);
	public Cost updateCost(Cost cost);
	public Cost addCost(Cost cost);
	public Cost deleteCost(Cost cost);

}
