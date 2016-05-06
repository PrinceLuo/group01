package com.enterprise.jdbc;

import java.util.List;

public class hotelDTO {
	private int id;
	private String name;
	private String location;
	private int manager_id;
	private List<roomtypeDTO> roomtype;
	
	public hotelDTO(int id, String name, String location, int manager_id){
		this.id = id;
		this.name = name;
		this.location = location;
		this.manager_id = manager_id;
	}
	
	
}
