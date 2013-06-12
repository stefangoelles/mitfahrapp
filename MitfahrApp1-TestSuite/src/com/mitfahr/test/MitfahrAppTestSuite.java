package com.mitfahr.test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;


@RunWith(Suite.class)

@SuiteClasses({SomeTest.class, InitialButtonTest.class, DateValidatorTest.class, 
	UtilsTest.class, OfferRideTest.class, RideTest.class, RideModelTest.class, ActivityCheckTripTest.class})

public class MitfahrAppTestSuite {
	
	
}
