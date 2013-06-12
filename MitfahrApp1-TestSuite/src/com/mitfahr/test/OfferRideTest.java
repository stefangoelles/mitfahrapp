package com.mitfahr.test;

import junit.framework.Assert;

import com.mitfahr.DateValidator;

import com.mitfahr.database.Ride;
import com.mitfahr.database.RideModel;

import android.test.AndroidTestCase;

public class OfferRideTest extends AndroidTestCase
{
	/**
	 * Test if a ride was inserted into database correct 
	 */
	public void testOfferRideTrue(){
		
		String from = "Daham";
		String to = "UNITAET";
		int year = 2013;
		int month = 6;
		int day = 11;
		int costs = 300;
		String aso = "blablabla";
		String phone = "321654321";
		String name = "Mohamet";
		String email= "Ali@ali.com";
		int seats = 1;
		int hour = 5;
		int minute = 5;
		

		Ride ride = new Ride(from, to, year, month, day, costs, aso, phone, name, email, hour, minute, seats);

		boolean result = RideModel.getInstance().insertRides(ride);
		
		
		Assert.assertEquals(true, result);
	}
	
	/**
	 * Test if inserting a ride into database went wrong
	 */
	public void testOfferRideFalse(){
		
		String from = " ";
		String to = " ";
		int year = 2013;
		int month = 5;
		int day = 29;
		int costs = 300;
		String aso = "blablabla";
		String phone = "321654321";
		String name = "Mohamet";
		String email= "";
		int seats = 1;
		int hour = 5;
		int minute = 5;
		
		Ride ride = new Ride(from, to, year, month, day, costs, aso, phone, name, email, hour, minute, seats);
		boolean result = RideModel.getInstance().insertRides(ride);
		
		
		Assert.assertEquals(false, result);
	}
	
	
}
