package com.mitfahr.test;

import static org.junit.Assert.*;

import org.junit.Before;

import com.jayway.android.robotium.solo.Solo;
import com.mitfahr.ActivityOwnRides;
import com.mitfahr.ActivityRide;
import com.mitfahr.ActivityOfferRide;
import com.mitfahr.MainWindow;

import android.test.ActivityInstrumentationTestCase2;

public class InitialButtonTest extends
		ActivityInstrumentationTestCase2<MainWindow> {

	
	private Solo solo;
	
	@SuppressWarnings("deprecation")
	public InitialButtonTest() {
		super("com.mitfahr", MainWindow.class);
		// TODO Auto-generated constructor stub
	}

	@Before
	protected void setUp() throws Exception {
		super.setUp();
		solo = new Solo(getInstrumentation(), getActivity());
	}

	public void testAddRemove()
	{
		solo.assertCurrentActivity("Check on first activity", MainWindow.class);
		
		solo.clickOnButton("Fahren");
		solo.assertCurrentActivity("Check Button_1", ActivityOfferRide.class);
		
		solo.goBack();
		
		solo.clickOnButton("Mitfahren");
		solo.assertCurrentActivity("Check Button_2", ActivityRide.class);
		
		solo.goBack();
		solo.goBack();

		
		solo.clickOnButton("Eigene Fahrten");
		solo.assertCurrentActivity("Check Button_3", ActivityOwnRides.class);
		
		solo.goBack();

	}

}
