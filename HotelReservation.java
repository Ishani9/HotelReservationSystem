package com.bl.assignment;

import java.time.DayOfWeek;
import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
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
	public void addHotel(String name, int regularWeekday, int regularWeekEnd, int ratings) {
		Hotel hotel = new Hotel(name, regularWeekday, regularWeekEnd, ratings);
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
		
		int[] numDays = numberOfDays( fromDate, toDate);
		int lakeWoodCost = 0;
        int bridgeWoodCost = 0;
        int ridgeWoodCost = 0;
        String cheapestHotel = null;
        
        lakeWoodCost = (numDays[0] * hotelMap.get("Lakewood").getRegularWeekday()) + (numDays[1] * hotelMap.get("Lakewood").getRegularWeekEnd());
        bridgeWoodCost = (numDays[0] * hotelMap.get("Bridgewood").getRegularWeekday()) + (numDays[1] * hotelMap.get("Bridgewood").getRegularWeekEnd());
        ridgeWoodCost = (numDays[0] * hotelMap.get("Ridgewood").getRegularWeekday()) + (numDays[1] * hotelMap.get("Ridgewood").getRegularWeekEnd());
        int minCost = Math.min(lakeWoodCost, Math.min(bridgeWoodCost, ridgeWoodCost));
        if (minCost == lakeWoodCost) 
        	cheapestHotel = "Lakewood";
        if (minCost == bridgeWoodCost) 
        	cheapestHotel = "Bridgewood";   			
        if (minCost == ridgeWoodCost) 
        	cheapestHotel = "Ridgewood";
		System.out.println("Cheapest Hotel : " + cheapestHotel + "\nTotal Rent : " + minCost);
		System.out.println();
		
		return cheapestHotel;
	}


	
	public int[] numberOfDays(String fromDate, String toDate) {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd MMM yyyy");
		LocalDate date1 = LocalDate.parse(fromDate, dtf);
		LocalDate date2 = LocalDate.parse(toDate, dtf);
		int numOfWeekDays = 0;
		int numOfWeekEnds = 0;
		int[] numOfDays = new int[2];
		for (LocalDate date = date1; date.isBefore(date2); date = date.plusDays(1)) {
			DayOfWeek day = DayOfWeek.of(date.get(ChronoField.DAY_OF_WEEK));
			switch (day) {
			case SATURDAY:
				numOfWeekEnds++;
				break;
			case SUNDAY:
				numOfWeekEnds++;
				break;
			default:
				numOfWeekDays++;
				break;
			}
		}
		if (numOfWeekEnds >= 1 && numOfWeekDays <= 1)
			numOfWeekEnds++;
		if(numOfWeekDays >= 1 && numOfWeekEnds <= 1)
			numOfWeekDays++;
		numOfDays[0] = numOfWeekDays;
		numOfDays[1] = numOfWeekEnds;
		return numOfDays;
	}


	/**
	 * PRINT
	 * 
	 */
	public void printHotels() {
		for (HashMap.Entry<String, Hotel> entry : hotelMap.entrySet()) {
			System.out.println("Rate for Hotel " +entry.getKey() + " for regular customer \nfor weekday is : " 
									+ entry.getValue().getRegularWeekday() + " \nand for weekend is : " + entry.getValue().getRegularWeekEnd());
			System.out.println("Ratings : "+ entry.getValue().getRatings() + "\n");
			System.out.println();
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
	
	public Integer rating(String hotel) {
		return hotelMap.get(hotel).getRatings();
	}
	
}
