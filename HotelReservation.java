package com.bl.assignment;

import java.time.DayOfWeek;
import java.awt.List;  
//import java.util.*;  
import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

@SuppressWarnings({ "unused" })
public class HotelReservation {
	
	public static HashMap<String, Hotel> hotelMap;
	public ArrayList<Hotel> hotelList = new ArrayList<Hotel>();

	public HotelReservation() {
		hotelMap = new HashMap<String, Hotel>();
	}
	
	/**
	 * UC 1
	 * 
	 * @param name
	 * @param regularWeekday
	 */
	public void addHotel(String name, int regularWeekday, int regularWeekEnd, int ratings, int rewardWeekDay, int rewardWeekEnd) {
		Hotel hotel = new Hotel(name, regularWeekday, regularWeekEnd, ratings,rewardWeekDay, rewardWeekEnd);
		hotelMap.put(name, hotel);
		hotelList.add(hotel);
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
 		String cheapestHotel = findCheapest(numDays[0] , numDays[1]);
 		System.out.println();
		return cheapestHotel;
	}
	
	public String findCheapest(int totalWeekDays, int totalWeekEndDays) {
		int minimumRate = 0;
		String cheapestHotel = null;
		ArrayList<Hotel> cheapestHotels = new ArrayList<Hotel>();
		HashMap<Hotel,Integer> hotelMap = new HashMap<Hotel,Integer>();
		HashMap<Hotel,Integer> ratingMap = new HashMap<Hotel,Integer>();
		for(Hotel hotel : hotelList) {
			
			int totalRate = hotel.getRegularWeekday() * totalWeekDays + hotel.getRegularWeekEnd() * totalWeekEndDays;
			hotelMap.put(hotel, totalRate);
			ratingMap.put(hotel, hotel.getRatings());
		}
		minimumRate = Collections.min(hotelMap.values());
		
		for(HashMap.Entry<Hotel, Integer> entry : hotelMap.entrySet()) {
			if(entry.getValue() == minimumRate) {
				cheapestHotels.add(entry.getKey());
			}
		}
		int maximumRating = Collections.max(ratingMap.values());
		for(Hotel hotel : cheapestHotels) {
			if(hotel.getRatings() != maximumRating) {
				maximumRating--;			
			}	
		System.out.println("Hotel : " + hotel.getName() + " Ratings : " + hotel.getRatings() +" Total Rate : " + minimumRate);
		cheapestHotel = hotel.getName();
		}
		
		return cheapestHotel;
	}


	
	public int[] numberOfDays(String fromDate, String toDate) {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd MMM yyyy");
		LocalDate date1 = LocalDate.parse(fromDate, dtf);
		LocalDate date2 = LocalDate.parse(toDate, dtf);
		int numOfWeekDays = 0;
		int numOfWeekEnds = 0;
		int[] numOfDays = new int[2];
		for (LocalDate date = date1; date.isBefore(date2.plusDays(1)); date = date.plusDays(1)) {
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
		
		numOfDays[0] = numOfWeekDays;
		numOfDays[1] = numOfWeekEnds;
		return numOfDays;
	}
	
	/**
	 * UC 7
	 * 
	 */
	
	public String findbestRatedHotel(String fromDate, String toDate) {
		int rating = 0;
		int rent = 0;
		String bestRatedHotel = "";
		for (HashMap.Entry<String, Hotel> entry : hotelMap.entrySet()) {
			if (entry.getValue().getRatings() > rating) {
				rating = entry.getValue().getRatings();
				bestRatedHotel = entry.getKey();
				rent = calculateRent(fromDate, toDate, entry.getValue().getRegularWeekday(),
						entry.getValue().getRegularWeekEnd());
			}
		}
		System.out.println("Best rated hotel : " + bestRatedHotel + ", Rent : " + rent);
		return bestRatedHotel;
	}
	
	public int calculateRent(String fromDate, String toDate, int weekdayRate, int weekendRate) {
		int[] numOfDays = numberOfDays(fromDate, toDate);
		int weekdayRent = weekdayRate * numOfDays[0];
		int weekendRent = weekendRate * numOfDays[1];
		int totalRent = weekdayRent + weekendRent;
		return totalRent;
	}

	/**
	 * PRINT
	 * 
	 */
	public void printHotels() {
		for (HashMap.Entry<String, Hotel> entry : hotelMap.entrySet()) {
			System.out.println("Rate for Hotel " +entry.getKey() + " for regular customer \n for weekday is : " 
									+ entry.getValue().getRegularWeekday() + " \n and for weekend is : " + entry.getValue().getRegularWeekEnd());
			System.out.println("Ratings : "+ entry.getValue().getRatings());
			System.out.println("For Rewards customers: \n for Weekdays is : "+ entry.getValue().getRewardWeekDay() + 
					"\n and for weekend is : "+ entry.getValue().getRewardWeekEnd());
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
