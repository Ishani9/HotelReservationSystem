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
	
}