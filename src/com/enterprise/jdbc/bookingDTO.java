package com.enterprise.jdbc;

import java.util.List;

public class bookingDTO {
	private int id;
	private int customer_id;
	private String pin;
	private String url;
	private List<detailDTO> detaillist;
	
	public bookingDTO(int id, int customer_id, String pin, String url){
		this.id = id;
		this.customer_id = customer_id;
		this.pin = pin;
		this.url = url;
	}
}
