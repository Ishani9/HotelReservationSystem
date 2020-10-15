package com.bl.assignment;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class HotelReservationTest {

	/**
	 * UC 1
	 * 
	 */
	@Test
	public void whenNewHotelAdded_shouldReturn_true() {
		HotelReservation hotelReservation = new HotelReservation();
		hotelReservation.addHotel("Lakewood", 110);
		hotelReservation.addHotel("Bridgewood", 160);
		hotelReservation.addHotel("Ridgewood", 220);
		hotelReservation.printHotels();
		Integer size = 3;
		assertEquals(size, hotelReservation.size());
	}
	
	/**
	 * UC 2
	 * 
	 */
	@Test
	public void whenCheapestMethodCalled_shouldReturn_nameOfHotel() {
		HotelReservation hotelReservation = new HotelReservation();
		hotelReservation.addHotel("Lakewood", 110);
		hotelReservation.addHotel("Bridgewood", 160);
		hotelReservation.addHotel("Ridgewood", 220);
		assertEquals("Lakewood", hotelReservation.cheapestHotel("10 Sep 2020", "11 Sep 2020"));
	}
	
	@Test
	public void whenCheapestMethodCalled2_shouldReturn_nameOfHotel() {
		HotelReservation hotelReservation = new HotelReservation();
		hotelReservation.addHotel("Lakewood", 110);
		hotelReservation.addHotel("Bridgewood", 160);
		hotelReservation.addHotel("Ridgewood", 220);
		assertEquals("Lakewood", hotelReservation.cheapestHotel("10 Sep 2020", "22 Sep 2020"));
	}

}
