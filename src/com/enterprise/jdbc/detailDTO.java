package com.enterprise.jdbc;

import java.sql.Date;


public class detailDTO {
	private int id;
	private int booking_id;
	private String pin;
	private String cur_date;
	private String start_date;
	private String end_date;
	private int hotel_id;
	private int room_type_id;
	private int extra_bed;
	private int num_rooms;
	private String level;
	
	public detailDTO(){

	}	
	public detailDTO(int id, int booking_id,String pin, String start_date, String end_date, int hotel_id, int room_type_id, int extra_bed, int num_rooms, String level){
		this.id = id;
		this.booking_id = booking_id;
		this.pin=pin;
		this.start_date = start_date;
		this.end_date = end_date;
		this.hotel_id = hotel_id;
		this.room_type_id = room_type_id;
		this.extra_bed = extra_bed;
		this.num_rooms = num_rooms;
		this.level = level;
	}
	
	public int getID(){
		return this.id;
	}
	public void setID(int id){
		this.id = id;
	}
	public int getBookingid(){
		return this.booking_id;
	}
	public void setBookingid(int booking_id){
		this.booking_id = booking_id;
	}
	public String getPin(){
		return this.pin;
	}
	public void setPin(String pin){
		this.pin=pin;
	}
	public String getCurdate(){
		return this.cur_date;
	}
	public void setCurdate(String cur_date){
		this.cur_date = cur_date;
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
	public int getHotelid(){
		return this.hotel_id;
	}
	public void setHotelid(int hotel_id){
		this.hotel_id = hotel_id;
	}
	public int getRoomtypeid(){
		return this.room_type_id;
	}
	public void setRoomtypeid(int room_type_id){
		this.room_type_id = room_type_id;
	}
	public int getExtrabed(){
		return this.extra_bed;
	}
	public void setExtrabed(int extra_bed){
		this.extra_bed = extra_bed;
	}
	public int getNumrooms(){
		return this.num_rooms;
	}
	public void setNumrooms(int num_rooms){
		this.num_rooms = num_rooms;
	}
	public String getLevel(){
		return this.level;
	}
	public void setLevel(String level){
		this.level = level;
	}
}
