package com.enterprise.jdbc;

public class staffDTO {
	private int id;
	private String username;
	private String password;
	private String type;
	private int hotelid;
	
	public staffDTO(){
		
	}
	
	public staffDTO(int id, String name, String psd, String type,int hid){
		this.id = id;
		this.username = name;
		this.password = psd;
		this.type = type;
		this.hotelid=hid;
	}
	
	public void setHotelid(int id){
		this.hotelid=id;
	}
	public int getHotelid(){
		return this.hotelid;
	}

	public void setID(int id){
		this.id = id;
	}
	public int getID(){
		return this.id;
	}
	
	public void setUsername(String username){
		this.username = username;
	}
	public String getUsername(){
		return this.username;
	}
	
	public void setPassword(String password){
		this.password = password;
	}
	public String getPassword(){
		return this.password;
	}
	
	public void setType(String type){
		this.type = type;
	}
	public String getType(){
		return this.type;
	}
}
