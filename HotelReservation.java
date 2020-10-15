package com.bl.assignment;

import java.util.ArrayList;
import java.util.List;

public class HotelReservation {
	
	List<Hotel> hotelList;
	
	public HotelReservation() {
		hotelList = new ArrayList<>();
	}
	
	/**
	 * UC 1
	 * 
	 * @param name
	 * @param regularWeekday
	 */
	public void addHotel(String name, int regularWeekday, int regularWeekEnd) {
		Hotel hotel = new Hotel(name, regularWeekday, regularWeekEnd);
		hotelList.add(hotel);
	}
	
	/**
	 * PRINT
	 * 
	 */
	public void printHotels() {
		for(Hotel hotel : hotelList) {
			System.out.println("Rate for Hotel " + hotel.getName() + " for regular customer for weekday is : " 
							+ hotel.getRegularWeekday() + " and for weekend is : " + hotel.getRegularWeekEnd());
			System.out.println("");
		}
	}
	
	/**
	 * SIZE
	 * 
	 * @return
	 */
	public Integer size() {
		return hotelList.size();
	}
}
