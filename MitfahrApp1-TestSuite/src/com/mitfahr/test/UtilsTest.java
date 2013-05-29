package com.mitfahr.test;

import junit.framework.Assert;

import com.mitfahr.Utils;

import android.test.AndroidTestCase;
import android.util.Log;

public class UtilsTest extends AndroidTestCase
{
	public void testSplitDateCorrect(){
		Utils testUtils = Utils.getInstance();
		Log.d("testing", "Testcase: Instance received");
		Log.d("testing", testUtils.toString());
		int[] expected = {29,05,2013};
		Log.d("testing", "expected string " + expected[0]);
		int[] result = testUtils.splitDate("29.05.2013");
		Log.d("testing", "Result string " + result[0]);
		Assert.assertEquals(expected.length , result.length);
	}
	
	public void testSplitDateWrong(){
		Utils testUtils = Utils.getInstance();
		
		int[] expected = {2,011,2013};
		
		int[] result = testUtils.splitDate("2.011.2013");
		
		Assert.assertEquals(expected[1], result[1]);
	}
	
	public void testSplitTimeCorrect(){
		Utils testUtils = Utils.getInstance();
		
		int[] expected = {13,15};
		
		int[] result = testUtils.splitTime("13:15");
		
		Assert.assertEquals(expected[1], result[1]);
	}
	
	public void testSplitTimeWrong(){
		Utils testUtils = Utils.getInstance();
		
		int[] expected = {1,13,15};
		
		int[] result = testUtils.splitTime("1:3:15");
		
		Assert.assertEquals(expected.length, result.length);
	}
}