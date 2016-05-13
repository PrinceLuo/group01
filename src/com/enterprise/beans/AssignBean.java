package com.enterprise.beans;

import java.util.List;

import com.enterprise.jdbc.detailDTO;

public class AssignBean {
	public detailDTO detail;
	public List<Integer> rooms;
		
	public AssignBean(detailDTO d,List<Integer> r){
		this.detail=d;
		this.rooms=r;
	}
			
}
