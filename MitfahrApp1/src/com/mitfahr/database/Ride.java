package com.mitfahr.database;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Ride {

	java.text.SimpleDateFormat date_format = new java.text.SimpleDateFormat("yyyy-MM-dd");
	java.text.SimpleDateFormat time_format = new java.text.SimpleDateFormat("HH:mm");
	private int ID;
	private String from = null;
	private String to = null;
	private String date = null;
	private int costs = 0;
	private String aso = null;
	private String phone = null;
	private String name = null;
	private String email = null;
	private String time = null;
	
	
	
	
	
	public Ride(String from, String to, int year, int month, int day, int costs, String aso,
			String phone, String name, String email, int hour, int minute) {
		super();
		this.date = date_format.format(new Date(year-1900, month-1, day));
		this.from = from;
		this.to = to;
		this.costs = costs;
		this.aso = aso;
		this.phone = phone;
		this.name = name;
		this.email = email;
		this.time = new String(hour + ":" + minute);
	}
	
	public Ride()
	{};
	
	public Ride(int ID,String from, String to, int year, int month, int day, int costs, String aso,
			String phone, String name, String email, int hour, int minute) {
		super();
		this.ID = ID;
		this.date = date_format.format(new Date(year-1900, month-1, day));
		this.from = from;
		this.to = to;
		this.costs = costs;
		this.aso = aso;
		this.phone = phone;
		this.name = name;
		this.email = email;
		this.time = new String(hour + ":" + minute);
	}





	public String getFrom() {
		return from;
	}
	
	public void setID(int value){
		this.ID = value;
	}





	public void setFrom(String from) {
		this.from = from;
	}





	public String getTo() {
		return to;
	}





	public void setTo(String to) {
		this.to = to;
	}





	public String getDate() {
		return date;
	}





	public void setDate(int year, int month, int day) {
		this.date = date_format.format(new Date(year-1900, month-1, day));
	}





	public int getCosts() {
		return costs;
	}





	public void setCosts(int costs) {
		this.costs = costs;
	}





	public String getAso() {
		return aso;
	}





	public void setAso(String aso) {
		this.aso = aso;
	}





	public String getPhone() {
		return phone;
	}





	public void setPhone(String phone) {
		this.phone = phone;
	}





	public String getName() {
		return name;
	}





	public void setName(String name) {
		this.name = name;
	}





	public String getEmail() {
		return email;
	}





	public void setEmail(String email) {
		this.email = email;
	}





	public String getTime() {
		return time;
	}





	public void setTime(int hour, int minute) {
		this.time = new String(hour + ":" + minute);
		}




	
}
