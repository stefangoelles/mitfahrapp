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

public class RideTest extends AndroidTestCase
{
	private Ride test = new Ride(0, "asdf", "asdf", 2000, 1, 1, 1, "asdf", "asdf", "asdf", "asdf", 1, 1, 1);
	private boolean result = false; 
	
	public void testRideGetFrom(){
		 
		if(test.getFrom().equalsIgnoreCase("asdf"))
		 {
			 result = true;
		 }

		Assert.assertEquals(true, result);
		result = false;
	}
	
	public void testRideGetTo(){
		 
		if(test.getTo().equalsIgnoreCase("asdf"))
		 {
			 result = true;
		 }

		Assert.assertEquals(true, result);
		result = false;
	}
	
	public void testRideGetAso(){
		 
		if(test.getAso().equalsIgnoreCase("asdf"))
		 {
			 result = true;
		 }

		Assert.assertEquals(true, result);
		result = false;
	}
	
	public void testRideGetCosts(){
		 
		if(test.getCosts() == 1)
		 {
			 result = true;
		 }

		Assert.assertEquals(true, result);
		result = false;
	}
	
	public void testRideGetPhone(){
		 
		if(test.getPhone().equalsIgnoreCase("asdf"))
		 {
			 result = true;
		 }

		Assert.assertEquals(true, result);
		result = false;
	}
	
	public void testRideGetName(){
		 
		if(test.getName().equalsIgnoreCase("asdf"))
		 {
			 result = true;
		 }

		Assert.assertEquals(true, result);
		result = false;
	}
	
	public void testRideGetEmail(){
		 
		if(test.getEmail().equalsIgnoreCase("asdf"))
		 {
			 result = true;
		 }

		Assert.assertEquals(true, result);
		result = false;
	}
	

}
