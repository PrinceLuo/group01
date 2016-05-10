package com.enterprise.beans;

public class OccupancyBean {
	private String hotel_name;
	private String room_type;
	private int available_num;
	private int occupied_num;
	public OccupancyBean(){
		
	}
	public OccupancyBean(String hotel_name, String room_type, int available_num, int occupied_num){
		this.hotel_name = hotel_name;
		this.room_type = room_type;
		this.available_num = available_num;
		this.occupied_num = occupied_num;
	}
	
	public String getHotelName(){
		return this.hotel_name;
	}

	public String getRotelType(){
		return this.room_type;
	}
	
	public int getAvailable(){
		return this.available_num;
	}
	
	public int getOccupancy(){
		return this.occupied_num;
	}
}
