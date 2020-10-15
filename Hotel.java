package com.bl.assignment;

public class Hotel {
	
	public String name;
	public int regularWeekday;
	public int regularWeekEnd;

	public Hotel(String name, int regularWeekday, int regularWeekEnd) {
		this.name = name;
		this.regularWeekday = regularWeekday;
		this.regularWeekEnd = regularWeekEnd;
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
	
	public int getRegularWeekEnd() {
		return regularWeekEnd;
	}

	public void setRegularWeekEnd(int regularWeekEnd) {
		this.regularWeekEnd = regularWeekEnd;
	}

}
