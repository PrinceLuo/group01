package com.enterprise.jdbc;

public class roomDTO {
	private int id;
	private int room_type_id;
	private int hotel_id;
	private int number;
	private String availability;
	private String roomtype;
	private detailDTO detail;
	
	public roomDTO(){
		
	}
	public roomDTO(int id, int room_type_id, int hotel_id, int number, String availability){
		this.id = id;
		this.room_type_id = room_type_id;
		this.hotel_id = hotel_id;
		this.number = number;
		this.availability = availability;
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
	public int getNumber(){
		return this.number;
	}
	public void setNumber(int number){
		this.number = number;
	}
	public String getAvailability(){
		return this.availability;
	}
	public void setAvailability(String availability){
		this.availability = availability;
	}
	public String getType(){
		return this.roomtype;
	}
	public void setType(String type){
		this.roomtype = type;
	}
	public detailDTO getDetail(){
		return this.detail;
	}
	public void setDetail(detailDTO detail){
		this.detail = detail;
	}
}
