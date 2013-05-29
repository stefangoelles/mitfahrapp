package com.mitfahr.test;

import static org.junit.Assert.*;

import java.util.List;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import com.mitfahr.DateValidator;
import com.mitfahr.database.Ride;
import com.mitfahr.database.RideModel;

import android.test.AndroidTestCase;

public class RideModelTest extends AndroidTestCase
{
	private String from = "asdf";
	private String to = "asdf";
	private int year = 2000;
	private int month = 1;
	private int day = 1;
	private int hour = 1;
	private int minute = 1;
	private int costs = 0;
	private String aso = "asdf";
	private String phone = "asdf";
	private String name = "asdf";
	private String email = "asdf";
	private int seats = 0;
	
	public void testRideModelInstance(){
		//DateValidator testValidator = new DateValidator();
		RideModel testRideModel = new RideModel();
		boolean result = true;
		 
		if(testRideModel.getInstance() == null)
		 {
			 result = false;
		 }

		Assert.assertEquals(true, result);
	}
	
	public void testRideModelgetRides(){
		//DateValidator testValidator = new DateValidator();
		RideModel testRideModel = new RideModel();
		boolean result = true;
		 
		List<Ride> test = testRideModel.getRides();
		
		if(test.equals(null))
		{
			result = false;
		}

		Assert.assertEquals(true, result);
	}
	
}
