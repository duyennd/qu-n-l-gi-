package com.oms.bean;


import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type")
@JsonTypeName("cost")
@JsonSubTypes({ @Type(value = Cost.class, name = "cost") })
public class Cost {
	private String id;
	private String name;
	private float tienCoc;
	private float gia30pDau;
	private float giaTang;
	
	public Cost() {
		super();
	}
	public Cost(String id,String name,float tienCoc,float gia30pDau, float giaTang
			) {
		this.id = id;
		this.name=name;
		this.tienCoc=tienCoc;
		this.gia30pDau=gia30pDau;
		this.giaTang=giaTang;
		
	}
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
	public float getGia30pDau() {
		return gia30pDau;
	}

	public void setGia30pDau(float gia30pDau) {
		this.gia30pDau = gia30pDau;
	}
	public float getTienCoc() {
		return tienCoc;
	}

	public void setTienCoc(float tienCoc) {
		this.tienCoc = tienCoc;
	}
	public float getGiaTang() {
		return giaTang;
	}

	public void setGiaTang(float giaTang) {
		this.giaTang = giaTang;
	}
	
	@Override
	public String toString() {
		return "id: " + this.id + ", name: " + this.name + 
				  ", tienCoc: " +this.tienCoc +", gia30pDau: " + this.gia30pDau +", giaTang: " + this.giaTang ;
	}
	public boolean match(Cost cost) {
		if (cost == null)
			return true;
		
		
		if (cost.id != null && !cost.id.equals("") && !this.id.contains(cost.id)) {
			return false;
		}
		if (cost.name != null && !cost.name.equals("") && !this.name.contains(cost.name)) {
			return false;
		}
		
		if (cost.gia30pDau != 0 && this.gia30pDau != cost.gia30pDau) {
			return false;
		}
		if (cost.tienCoc != 0 && this.tienCoc != cost.tienCoc) {
			return false;
		}
		if (cost.giaTang != 0 && this.giaTang != cost.giaTang) {
			return false;
		}
		
		
		return true;
	}
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Cost) {
			return this.id.equals(((Cost) obj).id);
		}
		return false;
	}
}