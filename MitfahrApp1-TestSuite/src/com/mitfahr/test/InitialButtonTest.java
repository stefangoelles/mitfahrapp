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

	public void testAddRemove() {
		
solo.clickOnImage(3);
solo.assertCurrentActivity("Get Ride Test", ActivityGetRide.class);

solo.clickOnImage(2);
solo.assertCurrentActivity("Offer Ride Test", ActivityOfferRide.class);

solo.clickOnButton("Weiter");
solo.assertCurrentActivity("Own Rides Test Btn Weiter No entrys", ActivityOfferRide.class);

//------------------------------------------------------------------------
//entering text!

EditText dummy = (EditText) solo.getView(R.id.txt_activityOfferride_from);
solo.enterText(dummy, "Graz");

dummy = (EditText) solo.getView(R.id.txt_activityOfferride_to);
solo.enterText(dummy, "asdfasdf");

dummy = (EditText) solo.getView(R.id.txt_activityOfferride_date);
solo.enterText(dummy, "12.12.2012");

dummy = (EditText) solo.getView(R.id.txt_activityOfferride_time);
solo.enterText(dummy, "12:00");

dummy = (EditText) solo.getView(R.id.txt_activityOfferride_size);
solo.enterText(dummy, "3");

dummy = (EditText) solo.getView(R.id.txt_activityOfferride_desc);
solo.enterText(dummy, "hallohallo");

//------------------------------------------------------------------------

solo.clickOnButton("Weiter");
solo.assertCurrentActivity("Own Rides Test Btn Weiter No entrys", ActivityCheckTrip.class);

solo.goBack();
solo.goBack();

solo.clickOnImage(1);
solo.assertCurrentActivity("Own Rides Test", ActivityOwnRides.class);


		//solo.pressMenuItem(1);
		//assertTrue("fail", solo.searchText("Fahrt"));
		//solo.pressMenuItem(2);
		//assertTrue("fail", solo.searchText("von"));
		//solo.pressMenuItem(0);
		//assertTrue("fail", solo.searchText("von"));
		//solo.clickOnText("About");
		//assertTrue("fail", solo.searchText("Impressum"));
		//solo.assertCurrentActivity("bla", ActivityImpressum.class);
		//solo.pressMenuItem(0)
		//solo.clickOnText("Create");
		//assertTrue(solo.searchText("Datum"));
	//	solo.assertCurrentActivity("Check on first activity", MainWindow.class);
		//solo.clickOnTe
		//solo.assertCurrentActivity("Check Button_1", ActivityOfferRide.class);
		//solo.goBack();
		//solo.
		//solo.clickOnText("Create");
	//solo.assertCurrentActivity("ActivityOfferRide",ActivityOfferRide.class);
		//solo.assertCurrentActivity("Check Button_2", ActivityGetRide.class);
	//	solo.goBack();
	//	solo.goBack();

		//solo.clickOnActionBarItem(2);
		//solo.assertCurrentActivity("Check Button_3", ActivityOwnRides.class);
		//solo.goBack();
	}

}
