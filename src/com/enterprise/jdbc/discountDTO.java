package com.enterprise.jdbc;

import java.math.BigDecimal;
import java.sql.Date;


public class discountDTO {
	private int id;
	private int room_type_id;
	private int hotel_id;
	private Date current_date;
	private Date start_date;
	private Date end_date;
	private BigDecimal rate;
	
	public discountDTO(){
		
	}
	public discountDTO(int id, int room_type_id, int hotel_id, Date current, Date start, Date end, BigDecimal rate){
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
	public Date getCurrentdate(){
		return this.current_date;
	}
	public void setCurrentdate(Date start_date){
		this.current_date = start_date;
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
	public BigDecimal getRate(){
		return this.rate;
	}
	public void setRate(BigDecimal rate){
		this.rate = rate;
	}
}
