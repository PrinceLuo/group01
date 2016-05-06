package com.enterprise.jdbc;

import java.sql.Date;
import java.util.Calendar;

public class detailDTO {
	private int id;
	private int booking_id;
	private Date start_date;
	private Date end_date;
	private int hotel_id;
	private int room_type_id;
	private int extra_bed;
	private int num_rooms;
	
	public detailDTO(){

	}	
	public detailDTO(int id, int booking_id, Date start_date, Date end_date, int hotel_id, int room_type_id, int extra_bed, int num_rooms){
		this.id = id;
		this.booking_id = booking_id;
		this.start_date = start_date;
		this.end_date = end_date;
		this.hotel_id = hotel_id;
		this.room_type_id = room_type_id;
		this.extra_bed = extra_bed;
		this.num_rooms = num_rooms;
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
	public Date getStartdate(){
		return this.start_date;
	}
	public void setStartdate(Date start_date){
		this.start_date = start_date;
	}
	public Date getEnddate(){
		return this.end_date;
	}
	public void setEnddate(Date end_date){
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
}
