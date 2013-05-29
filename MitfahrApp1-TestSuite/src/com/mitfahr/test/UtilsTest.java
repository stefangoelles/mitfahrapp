package com.mitfahr.test;

import junit.framework.Assert;

import com.mitfahr.Utils;

import android.test.AndroidTestCase;

public class UtilsTest extends AndroidTestCase
{
	public void testSplitDateCorrect(){
		Utils testUtils = new Utils();
		
		String[] expected = {"29","05","2013"};
		
		String[] result = testUtils.splitDate("29.05.2013");
		
		Assert.assertEquals(expected, result);
	}
	
	public void testSplitDateWrong(){
		Utils testUtils = new Utils();
		
		String[] expected = {"29","05","2013"};
		
		String[] result = testUtils.splitDate("2.011.2013");
		
		Assert.assertEquals(expected, result);
	}
	
	public void testSplitTimeCorrect(){
		Utils testUtils = new Utils();
		
		int[] expected = {13,15};
		
		int[] result = testUtils.splitTime("13:15");
		
		Assert.assertEquals(expected, result);
	}
	
	public void testSplitTimeWrong(){
		Utils testUtils = new Utils();
		
		int[] expected = {13,15};
		
		int[] result = testUtils.splitTime("1:3:15");
		
		Assert.assertEquals(expected, result);
	}
}