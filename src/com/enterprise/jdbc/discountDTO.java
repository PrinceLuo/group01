package com.enterprise.jdbc;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.Calendar;

public class discountDTO {
	private int id;
	private int room_type_id;
	private int hotel_id;
	private Date start_date;
	private Date end_date;
	private BigDecimal rate;
	
	public discountDTO(int id, int room_type_id, int hotel_id, Date start, Date end, BigDecimal rate){
		this.id = id;
		this.room_type_id = room_type_id;
		this.hotel_id = hotel_id;
		this.start_date = start;
		this.end_date = end;
		this.rate = rate;
	}
}
