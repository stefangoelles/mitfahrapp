package com.mitfahr.test;

import junit.framework.Assert;

import com.mitfahr.DateValidator;

import android.test.AndroidTestCase;

public class DateValidatorTest extends AndroidTestCase
{
	public void testvalidateDateTrue(){
		DateValidator testValidator = new DateValidator();
		
		boolean result = testValidator.isThisDateValid("12.12.2012", "dd.MM.yyyy");
		
		Assert.assertEquals(true, result);
	}
	
	public void testvalidateDateFalse(){
		DateValidator testValidator = new DateValidator();
		
		boolean result = testValidator.isThisDateValid("abcdefg", "dd.MM.yyyy");
		
		Assert.assertEquals(false, result);
	}
	
	public void testvalidateDate1stParam(){
		DateValidator testValidator = new DateValidator();
		
		boolean result = testValidator.isThisDateValid("abcdefg", null);
		
		Assert.assertEquals(false, result);
	}
	
	public void testvalidateDate2ndParam(){
		DateValidator testValidator = new DateValidator();
		
		boolean result = testValidator.isThisDateValid(null, "dd.MM.yyyy");
		
		Assert.assertEquals(false, result);
	}
	
	public void testvalidateDate0Param(){
		DateValidator testValidator = new DateValidator();
		
		boolean result = testValidator.isThisDateValid(null, null);
		
		Assert.assertEquals(false, result);
	}
}
