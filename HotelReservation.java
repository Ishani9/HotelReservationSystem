package com.bl.assignment;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;

@SuppressWarnings({ "unused" })
public class HotelReservation {
	
	public static HashMap<String, Hotel> hotelMap;

	public HotelReservation() {
		hotelMap = new HashMap<String, Hotel>();
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
	 * UC 2
	 * 
	 * @param fromDate
	 * @param toDate
	 * @return
	 */
	public String cheapestHotel(String fromDate, String toDate) {
		
		int numDays = numberOfDays( fromDate, toDate);
		int lakeWoodCost = 0;
        int bridgeWoodCost = 0;
        int ridgeWoodCost = 0;
        String cheapestHotel = null;
        
        lakeWoodCost = numDays * 110;
        bridgeWoodCost = numDays * 160;
        ridgeWoodCost = numDays * 220;
        
        int minCost = Math.min(lakeWoodCost, Math.min(bridgeWoodCost, ridgeWoodCost));
        if (minCost == lakeWoodCost) 
        	cheapestHotel = "Lakewood";
        if (minCost == bridgeWoodCost) 
        	cheapestHotel = "Bridgewood";   			
        if (minCost == ridgeWoodCost) 
        	cheapestHotel = "Ridgewood";
		System.out.println("Cheapest Hotel : " + cheapestHotel + "  Total Rent : " + minCost);
		System.out.println();
		return cheapestHotel;
	}


	
	public int numberOfDays(String fromDate, String toDate) {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd MMM yyyy");
		LocalDate date1 = LocalDate.parse(fromDate, dtf);
		LocalDate date2 = LocalDate.parse(toDate, dtf);
		int numOfDays = 0;
		//Long daysBetween = Duration.between(date1, date2).toDays();
		//int days = daysBetween.intValue();
		for (LocalDate date = date1; date.isBefore(date2); date = date.plusDays(1)) {
			numOfDays++;
		}
		numOfDays++;
		return numOfDays;
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
