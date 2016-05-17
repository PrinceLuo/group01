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
	private String cardnum;
	private String cardtype;
	//private String cardexpirydate;
	private List<bookingDTO> bookinglist;
	
	public customerDTO(){
		
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
	public void setID(int id){
		this.id = id;
	}
	public String getUsername(){
		return this.username;
	}
	public void setUsername(String username){
		this.username = username;
	}
	public String getPassword(){
		return this.password;
	}
	public String getEmail(){
		return this.email;
	}
	public void setEmail(String email){
		this.email = email;
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
	
	
//	public void setCreditcardlist(List<creditcardDTO> creditcardlist){
//		this.creditcardlist = creditcardlist;
//	}
//	
//	public List<creditcardDTO> getCreditcardlist(){
//		return this.creditcardlist;
//	}

	public void setBookinglist(List<bookingDTO> bookinglist){
		this.bookinglist = bookinglist;
	}
	public List<bookingDTO> getBookinglist(){
		return this.bookinglist;
	}

	/**
	 * @return the cardnum
	 */
	public String getCardnum() {
		return cardnum;
	}

	/**
	 * @param cardnum the cardnum to set
	 */
	public void setCardnum(String cardnum) {
		this.cardnum = cardnum;
	}

	/**
	 * @return the cardtype
	 */
	public String getCardtype() {
		return cardtype;
	}

	/**
	 * @param cardtype the cardtype to set
	 */
	public void setCardtype(String cardtype) {
		this.cardtype = cardtype;
	}
	
	/**
	 * @param cardexpirydate the cardexpirydate to set
	 */
	//public void setcardexpirydate(String cardexpirydate) {
	//	this.cardexpirydate = cardexpirydate;
	//}

	
}
