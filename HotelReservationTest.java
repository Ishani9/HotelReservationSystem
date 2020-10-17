package com.bl.assignment;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class HotelReservationTest {

	/**
	 * UC 3
	 * 
	 */
	@Test
	public void whenNewHotelAdded_shouldReturn_Size() {
		HotelReservation hotelReservation = new HotelReservation();
		hotelReservation.addHotel("Lakewood", 110, 90, 3);
		hotelReservation.addHotel("Bridgewood", 160, 60, 4);
		hotelReservation.addHotel("Ridgewood", 220, 150, 5);

		hotelReservation.printHotels();
		Integer size = 3;
		assertEquals(size, hotelReservation.size());
	}
	
	/**
	 * UC 2
	 * 
	 */
	@Test
	public void whenCheapestMethodCalled_shouldReturn_nameOfCheapestHotel() {
		HotelReservation hotelReservation = new HotelReservation();
		hotelReservation.addHotel("Lakewood", 110, 90, 3);
		hotelReservation.addHotel("Bridgewood", 160, 60, 4);
		hotelReservation.addHotel("Ridgewood", 220, 150, 5);
		assertEquals("Lakewood", hotelReservation.cheapestHotel("10 Sep 2020", "11 Sep 2020"));
	}
	
	@Test
	public void whenCheapestMethodCalled2_shouldReturn_nameOfCheapestHotel() {
		HotelReservation hotelReservation = new HotelReservation();
		hotelReservation.addHotel("Lakewood", 110, 90, 3);
		hotelReservation.addHotel("Bridgewood", 160, 60, 4);
		hotelReservation.addHotel("Ridgewood", 220, 150, 5);
		assertEquals("Lakewood", hotelReservation.cheapestHotel("10 Sep 2020", "22 Sep 2020"));
	}
	
	/**
	 * UC 4
	 * 
	 */
	@Test
	public void whenCheapestMethodWithWeekdayAndWeekendCalled_shouldReturn_nameOfCheapestHotels() {
		HotelReservation hotelReservation = new HotelReservation();
		hotelReservation.addHotel("Lakewood", 110, 90, 3);
		hotelReservation.addHotel("Bridgewood", 160, 90, 4);
		hotelReservation.addHotel("Ridgewood", 220, 150, 5);
		
		assertEquals("Lakewood", hotelReservation.cheapestHotel("11 Sep 2020", "13 Sep 2020"));
	}
	
	/**
	 * UC 5
	 * 
	 */
	@Test
	public void whenNewRatingAdded_shouldReturn_rating() {
		HotelReservation hotelReservation = new HotelReservation();
		hotelReservation.addHotel("Lakewood", 110, 90, 3);
		hotelReservation.addHotel("Bridgewood", 160, 60, 4);
		hotelReservation.addHotel("Ridgewood", 220, 150, 5);

		Integer rating = 3;
		assertEquals(rating, hotelReservation.rating("Lakewood"));
		Integer rating2 = 4;
		assertEquals(rating2, hotelReservation.rating("Bridgewood"));
		Integer rating3 = 5;
		assertEquals(rating3, hotelReservation.rating("Ridgewood"));
	}
	
	// 	UC 6
	@Test
	public void whenCheapestMethodCalled_shouldReturn_nameOfCheapestHotelsOfHigherRating() {
		HotelReservation hotelReservation = new HotelReservation();
		hotelReservation.addHotel("Lakewood", 110, 90, 3);
		hotelReservation.addHotel("Bridgewood", 160, 40, 4);
		hotelReservation.addHotel("Ridgewood", 220, 150, 5);
		assertEquals("Bridgewood", hotelReservation.cheapestHotel("11 Sep 2020", "12 Sep 2020"));
	}

}
