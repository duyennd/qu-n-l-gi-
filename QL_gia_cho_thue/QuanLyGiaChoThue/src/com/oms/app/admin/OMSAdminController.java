package com.oms.app.admin;

import javax.swing.JPanel;
import com.oms.bean.Cost;
import com.oms.components.abstractdata.controller.ADataPageController;
import com.oms.components.parking.controller.AdminCostPageController;

public class OMSAdminController {
	public OMSAdminController() {
	}
	
	public JPanel getParkingPage() {
		ADataPageController<Cost> controller = new AdminCostPageController();
		return controller.getDataPagePane();
	}
}