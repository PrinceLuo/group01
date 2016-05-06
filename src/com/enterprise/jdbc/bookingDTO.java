package com.enterprise.jdbc;

import java.util.List;

public class bookingDTO {
	private int id;
	private int customer_id;
	private String pin;
	private String url;
	private List<detailDTO> detaillist;
	
	public bookingDTO(){
		
	}
	
	public bookingDTO(int id, int customer_id, String pin, String url){
		this.id = id;
		this.customer_id = customer_id;
		this.pin = pin;
		this.url = url;
	}
	
	public int getID(){
		return this.id;
	}
	public void setID(int id){
		this.id = id;
	}
	public int getCustomerid(){
		return this.customer_id;
	}
	public void setCustomerid(int customer_id){
		this.customer_id = customer_id;
	}
	public String getPin(){
		return this.pin;
	}
	public void setPin(String pin){
		this.pin = pin;
	}
	
	public String getUrl(){
		return this.url;
	}
	public void setUrl(String url){
		this.url = url;
	}
	public List<detailDTO> getDetaillist(){
		return this.detaillist;
	}
	public void setDetaillist(List<detailDTO> detaillist){
		this.detaillist = detaillist;
	}
}
