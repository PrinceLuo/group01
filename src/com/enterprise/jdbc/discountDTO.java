package com.enterprise.jdbc;

import java.math.BigDecimal;
import java.util.Date;


public class discountDTO {
	private int id;
	private int room_type_id;
	private int hotel_id;
	private String current_date;
	private String start_date;
	private String end_date;
	private int rate;
	private String location;
	private String name;
	private String roomtype;
	
	public discountDTO(){
		
	}
	public discountDTO(int id, int room_type_id, int hotel_id, String current, String start, String end, int rate){
		this.id = id;
		this.room_type_id = room_type_id;
		this.hotel_id = hotel_id;
		this.current_date = current;
		this.start_date = start;
		this.end_date = end;
		this.rate = rate;
	}
	public int getID(){
		return this.id;
	}
	public void setID(int id){
		this.id = id;
	}
	
	public int getRoomtypeid(){
		return this.room_type_id;
	}
	public void setRoomtypeid(int room_type_id){
		this.room_type_id = room_type_id;
	}
	
	public int getHotelid(){
		return this.hotel_id;
	}
	public void setHotelid(int hotel_id){
		this.hotel_id = hotel_id;
	}
	public String getCurrentdate(){
		return this.current_date;
	}
	public void setCurrentdate(String start_date){
		this.current_date = start_date;
	}
	public String getStartdate(){
		return this.start_date;
	}
	public void setStartdate(String start_date){
		this.start_date = start_date;
	}
	public String getEnddate(){
		return this.end_date;
	}
	public void setEnddate(String end_date){
		this.end_date = end_date;
	}
	public int getRate(){
		return this.rate;
	}
	public void setRate(int rate){
		this.rate = rate;
	}
	
	public String getLocation(){
			return this.location;
		}
		public void setLocation(String l){
			this.location = l;
		}
		public String getName(){
			return this.name;
		}
		public void setName(String n){
			this.name = n;
		}
		public String getType(){
			return this.roomtype;
		}
		public void setType(String t){
			this.roomtype = t;
		}
}
