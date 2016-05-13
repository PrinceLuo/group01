package com.enterprise.jdbc;

import java.util.List;

public class hotelDTO {
	private int id;
	private String name;
	private String location;
	private int manager_id;
	private List<roomtypeDTO> roomtype;
	private List<roomDTO> rooms;
	private int occ;
	private int ava;
	public hotelDTO(){
		
	}
	public hotelDTO(int id, String name, String location, int manager_id){
		this.id = id;
		this.name = name;
		this.location = location;
		this.manager_id = manager_id;
	}
	
	public int getID(){
		return this.id;
	}
	public void setID(int id){
		this.id = id;
	}
	public String getName(){
		return this.name;
	}
	public void setName(String name){
		this.name = name;
	}
	public String getLocation(){
		return this.location;
	}
	public void setLocation(String location){
		this.location = location;
	}
	public int getManagerid(){
		return this.manager_id;
	}
	public void setManagerid(int manager_id){
		this.manager_id = manager_id;
	}
	public List<roomtypeDTO> getRoomtypelist(){
		return this.roomtype;
	}
	public void setRoomtypelist(List<roomtypeDTO> roomtype){
		this.roomtype = roomtype;
	}
	public List<roomDTO> getRoomlist(){
		return this.rooms;
	}
	public void setRoomlist(List<roomDTO> room){
		this.rooms = room;
	}
	public int getOcc(){
		return this.occ;
	}
	public void setOcc(int occ){
		this.occ = occ;
	}
	public int getAva(){
		return this.ava;
	}
	public void setAva(int ava){
		this.ava = ava;
	}
}
