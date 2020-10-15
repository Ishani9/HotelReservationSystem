package com.bl.assignment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class HotelReservation {
	public HashMap<String, Hotel> hotelMap;

	public HotelReservation() {
		hotelMap = new HashMap<>();
	}
	
	/**
	 * UC 1
	 * 
	 * @param name
	 * @param regularWeekday
	 */
	public void addHotel(String name, int regularWeekday) {
		Hotel hotel = new Hotel(name, regularWeekday);
		hotelMap.put(name, hotel);
	}
	
	
	/**
	 * PRINT
	 * 
	 */
	public void printHotels() {
		for (HashMap.Entry<String, Hotel> entry : hotelMap.entrySet()) {
			System.out.println("Rate for Hotel " +entry.getKey() + " for regular customer for weekday is : " 
									+ entry.getValue().getRegularWeekday());
			System.out.println("");
		}
	}
	
	/**
	 * SIZE
	 * 
	 * @return
	 */
	public Integer size() {
		return hotelMap.size();
	}
}
