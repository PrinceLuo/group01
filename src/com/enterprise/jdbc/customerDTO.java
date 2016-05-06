package com.enterprise.jdbc;

import java.util.List;

public class customerDTO {
	private int id;
	private String username;
	private String password;
	private String nickname;
	private String firstname;
	private String lastname;
	private String email;
	private String address;
	private List<creditcardDTO> creditcardlist;
	private List<bookingDTO> bookinglist;
	
	public customerDTO(String username, String password, String email){
		this.username = username;
		this.password = password;
		this.email = email;
	}
	
	public customerDTO(int id, String username, String password, String email){
		this.id = id;
		this.username = username;
		this.password = password;
		this.email = email;
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
	public String getEmail(){
		return this.email;
	}
	
	public void setPassword(String password){
		this.password = password;
	}
	
	public void setNickname(String nickname){
		this.nickname = nickname;
	}
	
	public String getNickname(){
		return this.nickname;
	}
	
	public void setFirstname(String firstname){
		this.firstname = firstname;
	}	

	public String getFirstname(){
		return this.firstname;
	}

	public void setLastname(String lastname){
		this.lastname = lastname;
	}
	
	public String getLastname(){
		return this.lastname;
	}
	
	public void setAdd(String add){
		this.address = add;
	}
	
	public String getAdd(){
		return this.address;
	}
	
	public void setCreditcardlist(List<creditcardDTO> creditcardlist){
		this.creditcardlist = creditcardlist;
	}
	
	public List<creditcardDTO> getCreditcardlist(){
		return this.creditcardlist;
	}
	
	public void setBookinglist(List<bookingDTO> bookinglist){
		this.bookinglist = bookinglist;
	}
	public List<bookingDTO> getBookinglist(){
		return this.bookinglist;
	}
}
