package com.mitfahr.test;

import static org.junit.Assert.*;

import org.junit.Before;

import com.jayway.android.robotium.solo.Solo;
import com.mitfahr.ActivityCheckTrip;
import com.mitfahr.ActivityImpressum;
import com.mitfahr.ActivityOwnRides;
import com.mitfahr.ActivityGetRide;
import com.mitfahr.ActivityOfferRide;
import com.mitfahr.MainWindow;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.test.ActivityInstrumentationTestCase2;
import android.util.Log;
import android.widget.EditText;

import com.mitfahr.R;

public class ActivityCheckTripTest extends
		ActivityInstrumentationTestCase2<MainWindow> {

	private Solo solo;

	@SuppressWarnings("deprecation")
	public ActivityCheckTripTest() {
		super("com.mitfahr", MainWindow.class);
		// TODO Auto-generated constructor stub
	}

	@Before
	protected void setUp() throws Exception {
		super.setUp();
		solo = new Solo(getInstrumentation(), getActivity());
	}

	public void testAddRemove() {
		

	}

}
