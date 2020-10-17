package com.bl.assignment;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class HotelReservationTest {

	/**
	 * UC 1
	 * @throws InvalidEntryException 
	 * 
	 */
	@Test
	public void whenNewHotelAdded_shouldReturn_Size() throws InvalidEntryException {
		HotelReservation hotelReservation = new HotelReservation();
		hotelReservation.addHotel("Lakewood", 110, 90, 3, 80, 80, "Regular");
		hotelReservation.addHotel("Bridgewood", 160, 60, 4, 110, 50, "Regular");
		hotelReservation.addHotel("Ridgewood", 220, 150, 5, 100, 40, "Regular");

		hotelReservation.printHotels();
		Integer size = 3;
		assertEquals(size, hotelReservation.size());
	}
	

	
	/**
	 * UC 2
	 * @throws InvalidEntryException 
	 * 
	 */
	 
	@Test
	public void whenCheapestMethodCalled_shouldReturn_nameOfCheapestHotel() throws InvalidEntryException {
		HotelReservation hotelReservation = new HotelReservation();
		hotelReservation.addHotel("Lakewood", 110, 90, 3, 80, 80, "Regular");
		hotelReservation.addHotel("Bridgewood", 160, 60, 4, 110, 50, "Regular");
		hotelReservation.addHotel("Ridgewood", 220, 150, 5, 100, 40, "Regular");
		assertEquals("Lakewood", hotelReservation.cheapestHotel("Regular", "09 Sep 2020", "10 Sep 2020"));
	}
	
	@Test
	public void whenCheapestMethodCalled2_shouldReturn_nameOfCheapestHotel() throws InvalidEntryException {
		HotelReservation hotelReservation = new HotelReservation();
		hotelReservation.addHotel("Lakewood", 110, 90, 3, 80, 80, "Regular");
		hotelReservation.addHotel("Bridgewood", 160, 60, 4, 110, 50, "Regular");
		hotelReservation.addHotel("Ridgewood", 220, 150, 5, 100, 40, "Regular");
		assertEquals("Lakewood", hotelReservation.cheapestHotel("Regular", "10 Sep 2020", "22 Sep 2020"));
	}
	
	/**
	 * UC 4
	 * @throws InvalidEntryException 
	 * 
	 */
	 
	@Test
	public void whenCheapestMethodWithWeekdayAndWeekendCalled_shouldReturn_nameOfCheapestHotels() throws InvalidEntryException {
		HotelReservation hotelReservation = new HotelReservation();
		hotelReservation.addHotel("Lakewood", 110, 90, 3, 80, 80, "Regular");
		hotelReservation.addHotel("Bridgewood", 160, 40, 4, 110, 50, "Regular");
		hotelReservation.addHotel("Ridgewood", 220, 150, 5, 100, 40, "Regular");
		
		assertEquals("Bridgewood", hotelReservation.cheapestHotel("Regular","11 Sep 2020", "13 Sep 2020"));
	}
	
	/**
	 * UC 5
	 * @throws InvalidEntryException 
	 * 
	 */
	 
	@Test
	public void whenNewRatingAdded_shouldReturn_rating() throws InvalidEntryException {
		HotelReservation hotelReservation = new HotelReservation();
		hotelReservation.addHotel("Lakewood", 110, 90, 3, 80, 80, "Regular");
		hotelReservation.addHotel("Bridgewood", 160, 60, 4, 110, 50, "Regular");
		hotelReservation.addHotel("Ridgewood", 220, 150, 5, 100, 40, "Regular");
		
		Integer rating = 3;
		assertEquals(rating, hotelReservation.rating("Lakewood"));
		Integer rating2 = 4;
		assertEquals(rating2, hotelReservation.rating("Bridgewood"));
		Integer rating3 = 5;
		assertEquals(rating3, hotelReservation.rating("Ridgewood"));
	}

	
	/**
	 * UC 6
	 * @throws InvalidEntryException 
	 * 
	 */
	@Test
	public void whenCheapestMethodCalled_shouldReturn_nameOfCheapestHotelsOfHigherRating() throws InvalidEntryException {
		HotelReservation hotelReservation = new HotelReservation();
		hotelReservation.addHotel("Lakewood", 110, 90, 3, 80, 80, "Regular");
		hotelReservation.addHotel("Bridgewood", 160, 40, 4, 110, 50, "Regular");
		hotelReservation.addHotel("Ridgewood", 220, 150, 5, 100, 40, "Regular");
		
		assertEquals("Bridgewood", hotelReservation.cheapestHotel("Regular", "11 Sep 2020", "12 Sep 2020"));
	}
	
	/**
	 * UC 7
	 * @throws InvalidEntryException 
	 * 
	 */
	@Test
	public void whenBestRatedHotelCalled_shouldReturn_bestRatedHotel() throws InvalidEntryException {
		HotelReservation hotelReservation = new HotelReservation();
		hotelReservation.addHotel("Lakewood", 110, 90, 3, 80, 80, "Regular");
		hotelReservation.addHotel("Bridgewood", 160, 40, 4, 110, 50, "Regular");
		hotelReservation.addHotel("Ridgewood", 220, 150, 5, 100, 40, "Regular");
		
		assertEquals("Ridgewood", hotelReservation.findbestRatedHotel("11 Sep 2020", "12 Sep 2020"));
	}
	
	/**
	 * UC 10
	 * @throws InvalidEntryException 
	 * 
	 */
	@Test
	public void whenCheapestMethodCalledonRewardCustomer_shouldReturn_nameOfCheapestHotel() throws InvalidEntryException {
		HotelReservation hotelReservation = new HotelReservation();
		hotelReservation.addHotel("Lakewood", 110, 90, 3, 80, 80, "Reward");
		hotelReservation.addHotel("Bridgewood", 160, 60, 4, 110, 50, "Reward");
		hotelReservation.addHotel("Ridgewood", 220, 150, 5, 100, 40, "Reward");
		
		assertEquals("Ridgewood", hotelReservation.cheapestHotel("Reward", "11 Sep 2020", "12 Sep 2020"));
	}
	
	
	public void whenInvalidCustomerType_shouldThrow_exception() throws InvalidEntryException {
		HotelReservation hotelReservation = new HotelReservation();
		hotelReservation.addHotel("Lakewood", 110, 90, 3, 80, 80, "Reg");
		hotelReservation.addHotel("Bridgewood", 160, 60, 4, 110, 50, "Re");
		hotelReservation.addHotel("Ridgewood", 220, 150, 5, 100, 40, "R");
		
	}

	
}
