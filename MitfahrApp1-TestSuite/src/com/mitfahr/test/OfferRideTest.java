package com.mitfahr.test;

import junit.framework.Assert;

import com.mitfahr.DateValidator;
import com.mitfahr.database.Fahrt;
import com.mitfahr.database.FahrtenModel;

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
		int month = 5;
		int day = 29;
		int costs = 300;
		String aso = "blablabla";
		String phone = "321654321";
		String name = "Mohamet";
		String email= "Ali@ali.com";
		int hour = 5;
		int minute = 5;
		
		Fahrt fahrt = new Fahrt(from, to, year, month, day, costs, aso, phone, name, email, hour, minute);
		boolean result = FahrtenModel.getInstance().insertFahrt(fahrt);
		
		
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
		String email= "Ali@ali.com";
		int hour = 5;
		int minute = 5;
		
		Fahrt fahrt = new Fahrt(from, to, year, month, day, costs, aso, phone, name, email, hour, minute);
		boolean result = FahrtenModel.getInstance().insertFahrt(fahrt);
		
		
		Assert.assertEquals(true, result);
	}
	
	
}
