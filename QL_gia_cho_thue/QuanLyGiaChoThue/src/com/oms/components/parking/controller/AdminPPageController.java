package com.oms.components.parking.controller;




import com.oms.bean.Cost;
import com.oms.components.abstractdata.controller.ADataPageController;
import com.oms.components.abstractdata.gui.ADataAddPane;
import com.oms.components.abstractdata.gui.ADataListPane;
import com.oms.components.parking.gui.AdminCostListPane;
import com.oms.components.parking.gui.CostAddPane;


public abstract class AdminPPageController extends ADataPageController<Cost> {
	public AdminPPageController() {
		super();
	}
	
	@Override
	public ADataListPane<Cost> createListPane() {
		return new AdminCostListPane(this);
	}
	
	public abstract Cost updateCost(Cost cost);
	
	@Override
	public ADataAddPane<Cost> createAddPane() {
		return new CostAddPane(this);
	}
}
