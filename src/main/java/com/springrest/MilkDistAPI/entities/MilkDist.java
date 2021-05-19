package com.springrest.MilkDistAPI.entities;

public class MilkDist {
	
	private String type_of_milk; // Cow/Buffalo
	private String price;
	private String unit;
	private String time_of_delivery;
	
	public MilkDist(String type_of_milk, String price, String unit, String time_of_delivery) {
		super();
		this.type_of_milk = type_of_milk;
		this.price = price;
		this.unit = unit;
		this.time_of_delivery = time_of_delivery;
	}
	public MilkDist() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getType_of_milk() {
		return type_of_milk;
	}
	public void setType_of_milk(String type_of_milk) {
		this.type_of_milk = type_of_milk;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	public String getTime_of_delivery() {
		return time_of_delivery;
	}
	public void setTime_of_delivery(String time_of_delivery) {
		this.time_of_delivery = time_of_delivery;
	}
	@Override
	public String toString() {
		return "MilkDist [type_of_milk=" + type_of_milk + ", price=" + price + ", unit=" + unit + ", time_of_delivery="
				+ time_of_delivery + "]";
	}
	
	
}
