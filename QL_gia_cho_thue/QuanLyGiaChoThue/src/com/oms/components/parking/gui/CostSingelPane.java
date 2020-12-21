
package com.oms.components.parking.gui;
import javax.swing.JLabel;

import com.oms.bean.Cost;
import com.oms.components.abstractdata.gui.ADataSinglePane;


@SuppressWarnings("serial")
public class CostSingelPane extends ADataSinglePane<Cost>{
	private JLabel labelName;
	private JLabel labelTienCoc;
	private JLabel labelGia30pDau;
	private JLabel labelGiaTang;
	
	
	public CostSingelPane() {
		super();
	}
		
	
	public CostSingelPane(Cost cost) {
		this();
		this.t = cost;
		
		displayData();
	}

	@Override
	public void buildControls() {
		super.buildControls();
		
	int row = getLastRowIndex();
	c.gridx = 0;
	c.gridy = row;
	labelName = new JLabel();
	add(labelName, c);
	
	row = getLastRowIndex();
	c.gridx = 0;
	c.gridy = row;
	labelTienCoc = new JLabel();
	add(labelTienCoc, c);
	
	row = getLastRowIndex();
	c.gridx = 0;
	c.gridy = row;
	labelGia30pDau = new JLabel();
	add(labelGia30pDau, c);
	
	row = getLastRowIndex();
	c.gridx = 0;
	c.gridy = row;
	labelGiaTang= new JLabel();
	add(labelGiaTang, c);
	
	

	}
	
	
	@Override
	public void displayData() {
		labelName.setText("Loại xe: " + t.getName());
		labelTienCoc.setText("Tiền cọc: " + t.getTienCoc()+" đồng");
		labelGia30pDau.setText("giá tiền 30 p đầu : " + t.getGia30pDau()+ " đồng");
		labelGiaTang.setText("giá tăng: " + t.getGiaTang()+ " đồng "+" mỗi 15 phút tiếp theo");

	}
}
