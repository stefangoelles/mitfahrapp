package com.mitfahr.test;

import static org.junit.Assert.*;

import java.util.Date;

import junit.framework.Assert;

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
import android.widget.TextView;

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

	public void testActivityCheckTripOK() {
		
		solo.clickOnImage(2);
		solo.assertCurrentActivity("Offer Ride Test", ActivityOfferRide.class);
		
		solo.clickOnButton("Weiter");
		solo.assertCurrentActivity("Own Rides Test Btn Weiter No entrys", ActivityOfferRide.class);
		
		//------------------------------------------------------------------------
		//entering text!
		
	    String check_from_txt = "Graz";
		String check_to_txt = "asdfasdf";
	    String check_date_txt = "12.12.2012";
	    String check_time_txt = "12:00";
		String check_seats_txt = "3";
		String check_desc_txt = "halloHallo";
		
		EditText dummy = (EditText) solo.getView(R.id.txt_activityOfferride_from);
		solo.enterText(dummy, check_from_txt);
		
		dummy = (EditText) solo.getView(R.id.txt_activityOfferride_to);
		solo.enterText(dummy, check_to_txt);
		
		dummy = (EditText) solo.getView(R.id.txt_activityOfferride_date);
		solo.enterText(dummy, check_date_txt);
		
		dummy = (EditText) solo.getView(R.id.txt_activityOfferride_time);
		solo.enterText(dummy, check_time_txt);
		
		dummy = (EditText) solo.getView(R.id.txt_activityOfferride_size);
		solo.enterText(dummy,check_seats_txt );
		
		dummy = (EditText) solo.getView(R.id.txt_activityOfferride_desc);
		solo.enterText(dummy, check_desc_txt);
		
		//------------------------------------------------------------------------
		
		solo.clickOnButton("Weiter");
		
		// Activity Check Trip 
		solo.assertCurrentActivity("Own Rides Test Btn Weiter No entrys", ActivityCheckTrip.class);
		
		TextView et_check_from = (TextView) solo.getView(R.id.lbl_checkTrip_from);
		String check_from = String.valueOf(et_check_from.getText());
		
		TextView et_check_to = (TextView) solo.getView(R.id.lbl_checkTrip_to);
		String check_to = String.valueOf(et_check_to.getText());
		
		TextView et_check_date = (TextView) solo.getView(R.id.lbl_checkTrip_date);
		String check_date = String.valueOf(et_check_date.getText());
		
		TextView et_check_time = (TextView) solo.getView(R.id.lbl_checkTrip_time);
		String check_time = String.valueOf(et_check_time.getText());
		
		TextView et_check_seats = (TextView) solo.getView(R.id.lbl_checkTrip_seats);
		String check_seats = String.valueOf(et_check_seats.getText());
		
		TextView et_check_desc = (TextView) solo.getView(R.id.lbl_checkTrip_desc);
		String check_desc= String.valueOf(et_check_desc.getText());
		
		boolean result = false; 
		if(check_from_txt.equals(check_from) && check_to_txt.equals(check_to) && check_date_txt.equals(check_date) && check_time_txt.equals(check_time) && check_seats_txt.equals(check_seats) && check_desc_txt.equals(check_desc))
			result = true;

		solo.goBack();
		solo.goBack();
		Assert.assertEquals(true, result);
	}

}
