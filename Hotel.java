package com.bl.assignment;

public class Hotel {
	
	public String name;
	public int regularWeekday;
	public int regularWeekEnd;
	public int rewardWeekDay;
	public int rewardWeekEnd;
	public int ratings;
	

	public Hotel(String name, int regularWeekday, int regularWeekEnd, int ratings, int rewardWeekDay, int rewardWeekEnd) {
		this.name = name;
		this.regularWeekday = regularWeekday;
		this.regularWeekEnd = regularWeekEnd;
		this.ratings = ratings;
		this.rewardWeekDay = rewardWeekDay;
		this.rewardWeekEnd = rewardWeekEnd;
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
		this.ratings = ratings;
	}
	
	public int getRewardWeekDay() {
		return rewardWeekDay;
	}

	public void setRewardWeekDay(int rewardWeekDay) {
		this.rewardWeekDay = rewardWeekDay;
	}
	
	public int getRewardWeekEnd() {
		return rewardWeekEnd;
	}

	public void setRewardWeekEnd(int rewardWeekEnd) {
		this.rewardWeekEnd = rewardWeekEnd;
	}
	

}
