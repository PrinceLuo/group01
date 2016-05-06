package com.enterprise.jdbc;

import java.math.BigDecimal;
import java.util.List;

public class roomtypeDTO {
	private int id;
	private String room_type;
	private BigDecimal price;
	private int available_num;
	private int hotel_id; //may be not used
	private List<roomDTO> room;
	private discountDTO discount;
	private detailDTO detail; //used for update available_num in DB
	
	public roomtypeDTO(int id, String room_type, BigDecimal price, int available_num, int hotel_id){
		this.id = id;
		this.room_type = room_type;
		this.price = price;
		this.available_num = available_num;
		this.hotel_id = hotel_id;
	}
}
