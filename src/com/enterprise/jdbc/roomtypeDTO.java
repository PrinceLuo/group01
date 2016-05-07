package com.enterprise.jdbc;

import java.math.BigDecimal;
import java.util.List;

public class roomtypeDTO {
	private int id;
	private String room_type;
	private BigDecimal price;
	private int num;
	private int hotel_id;
	private List<roomDTO> room;
	private discountDTO discount;
	private detailDTO detail; //used for update available_num in DB
	
	public roomtypeDTO(){
		
	}
	public roomtypeDTO(int id, String room_type, BigDecimal price, int available_num, int hotel_id){
		this.id = id;
		this.room_type = room_type;
		this.price = price;
		this.num = available_num;
		this.hotel_id = hotel_id;
	}
	
	public int getID(){
		return this.id;
	}
	public void setID(int id){
		this.id = id;
	}
	public String getRoomtype(){
		return this.room_type;
	}
	public void setRoomtype(String room_type){
		this.room_type = room_type;
	}
	public BigDecimal getPrice(){
		return this.price;
	}
	public void setPrice(BigDecimal price){
		this.price = price;
	}
	public int getNum(){
		return this.num;
	}
	public void setNum(int available_num){
		this.num = available_num;
	}
	public int getHotelid(){
		return this.hotel_id;
	}
	public void setHotelid(int hotel_id){
		this.hotel_id = hotel_id;
	}
	public List<roomDTO> getRoomlist(){
		return this.room;
	}
	public void setRoomlist(List<roomDTO> room){
		this.room = room;
	}
	public discountDTO getDiscount(){
		return this.discount;
	}
	public void setDiscount(discountDTO discount){
		this.discount = discount;
	}
	public detailDTO getDetail(){
		return this.detail;
	}
	public void setDetail(detailDTO detail){
		this.detail = detail;
	}
}
