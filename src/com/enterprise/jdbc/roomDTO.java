package com.enterprise.jdbc;

public class roomDTO {
	private int id;
	private int room_type_id;
	private int hotel_id;
	private int number;
	private String availability;
	private detailDTO detail;//used for assign and update roomtype.available_num

	public roomDTO(int id, int room_type_id, int hotel_id, int number, String availability){
		this.id = id;
		this.room_type_id = room_type_id;
		this.hotel_id = hotel_id;
		this.number = number;
		this.availability = availability;
	}
}
