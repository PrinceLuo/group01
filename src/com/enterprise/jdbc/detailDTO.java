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
}
