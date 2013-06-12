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
