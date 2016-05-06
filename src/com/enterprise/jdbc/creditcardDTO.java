package com.enterprise.jdbc;

public class creditcardDTO {
	private int id;
	private String card_type;
	private String card_num;
	private int customer_id;
	
	public creditcardDTO(String card_type, String card_num){
		this.card_type = card_type;
		this.card_num = card_num;
	}
	
	public creditcardDTO(int id, String card_type, String card_num, int customer_id){
		this.id = id;
		this.card_type = card_type;
		this.card_num = card_num;
		this.customer_id = customer_id;
	}
	
	public int getID(){
		return this.id;
	}
	
	public String getCardtype(){
		return this.card_type;
	}
	
	public String getCardnum(){
		return this.card_num;
	}
	public int getCustomerid(){
		return this.customer_id;
	}
}
