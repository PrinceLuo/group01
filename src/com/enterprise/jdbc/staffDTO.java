package com.enterprise.jdbc;

public class staffDTO {
	private int id;
	private String username;
	private String password;
	private String type;
	
	public staffDTO(){
		
	}
	
	public staffDTO(int id, String name, String psd, String type){
		this.id = id;
		this.username = name;
		this.password = psd;
		this.type = type;
	}
	
	public int getID(){
		return this.id;
	}
	public String getUsername(){
		return this.username;
	}
	public String getPassword(){
		return this.password;
	}
	public String getType(){
		return this.type;
	}
}
