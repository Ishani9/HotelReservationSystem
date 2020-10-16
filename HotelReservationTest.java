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
		hotelReservation.addHotel("Lakewood", 110, 90);
		hotelReservation.addHotel("Bridgewood", 160, 60);
		hotelReservation.addHotel("Ridgewood", 220, 150);

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
		hotelReservation.addHotel("Lakewood", 110, 90);
		hotelReservation.addHotel("Bridgewood", 160, 60);
		hotelReservation.addHotel("Ridgewood", 220, 150);

		assertEquals("Lakewood", hotelReservation.cheapestHotel("10 Sep 2020", "11 Sep 2020"));
	}
	
	@Test
	public void whenCheapestMethodCalled2_shouldReturn_nameOfCheapestHotel() {
		HotelReservation hotelReservation = new HotelReservation();
		hotelReservation.addHotel("Lakewood", 110, 90);
		hotelReservation.addHotel("Bridgewood", 160, 60);
		hotelReservation.addHotel("Ridgewood", 220, 150);

		assertEquals("Lakewood", hotelReservation.cheapestHotel("10 Sep 2020", "22 Sep 2020"));
	}

}
