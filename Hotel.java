package com.bl.assignment;

public class Hotel {
	
	public String name;
	public int regularWeekday;
	public int regularWeekEnd;
	public int ratings;
	

	public Hotel(String name, int regularWeekday, int regularWeekEnd, int ratings) {
		this.name = name;
		this.regularWeekday = regularWeekday;
		this.regularWeekEnd = regularWeekEnd;
		this.ratings = ratings;
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

	public int getRatings() {
		return ratings;
	}

	public void setRatings(int ratings) {
		this.regularWeekEnd = ratings;
	}
	

}
