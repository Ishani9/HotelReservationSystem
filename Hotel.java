package com.bl.assignment;

public class Hotel {
	
	public String name;
	public int regularWeekday;
	public int regularWeekEnd;

	public Hotel(String name, int regularWeekday) {
		this.name = name;
		this.regularWeekday = regularWeekday;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getRegularWeekday() {
		return regularWeekday;
	}

	public void setRegularWeekday(int regularWeekday) {
		this.regularWeekday = regularWeekday;
	}
	
	

}
