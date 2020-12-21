package com.oms.components.parking.controller;

import java.util.List;
import java.util.Map;

import com.oms.bean.Cost;
import com.oms.components.parking.gui.CostSearchPane;
import com.oms.components.parking.gui.CostSingelPane;
import com.oms.serverapi.CostApi;



public class AdminCostPageController extends AdminPPageController{
	@Override
	public List<? extends Cost> search(Map<String, String> searchParams) {
		return new CostApi().getCost(searchParams);
	}
	
	@Override
	public CostSingelPane createSinglePane() {
		return new CostSingelPane();
	}
	
	@Override
	public CostSearchPane createSearchPane() {
		return new CostSearchPane();
	}
	
	@Override
	public Cost updateCost(Cost cost) {
		return new CostApi().updateCost((Cost) cost);
	}
	
	public Cost addCost(Cost cost) {
		return new CostApi().addCost((Cost) cost);
	}

	public Cost deleteCost(Cost cost) {
		return new CostApi().deleteCost((Cost) cost);
	}

	
	
}
