package com.mitfahr;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.mitfahr.database.Ride;
import com.mitfahr.database.RideModel;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class ActivityCheckTrip extends Activity {
	private String check_from;
	private String check_to;
	private String check_date;
	private String check_time;
	private String check_seats;
	private String check_desc;
	private Date convert_date;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_check_trip);
		
		Intent intent = getIntent();
		Bundle bundle = intent.getExtras();
		
		this.check_from = (String) bundle.get("from");
		this.check_to = (String) bundle.get("to");
		this.check_date = (String) bundle.get("date");
		this.check_time = (String) bundle.get("time");
		this.check_seats = (String) bundle.get("seats");
		this.check_desc = (String) bundle.get("desc");
		
		final TextView et_check_from = (TextView) findViewById(R.id.lbl_checkTrip_from);
		et_check_from.setText(check_from);
		
		TextView et_check_to = (TextView) findViewById(R.id.lbl_checkTrip_to);
		et_check_to.setText(check_to);
		
		final TextView et_check_date = (TextView) findViewById(R.id.lbl_checkTrip_date);
		et_check_date.setText(check_date);
		
		TextView et_check_time = (TextView) findViewById(R.id.lbl_checkTrip_time);
		et_check_time.setText(check_time);
		
		TextView et_check_seats = (TextView) findViewById(R.id.lbl_checkTrip_seats);
		et_check_seats.setText(check_seats);
		
		TextView et_check_desc = (TextView) findViewById(R.id.lbl_checkTrip_desc);
		et_check_desc.setText(check_desc);
		
		// button with specific action 
		final Button button = (Button) findViewById(R.id.btn_checkTrip_store);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
            	setContentView(R.layout.activity_check_trip);
        		
                // Store holy shit in db
            	int[] date = Utils.getInstance().splitDate(check_date);
            	
            	// grapping the phone number of the device
            	TelephonyManager telephonyManager = (TelephonyManager)getSystemService(Context.TELEPHONY_SERVICE);
            	String phoneNumber = telephonyManager.getLine1Number();
            	Log.d("testing", "After phone number " + phoneNumber);
            	
            	int[] time = Utils.getInstance().splitTime(check_time);
            	/*Log.d("testing", "Test check from " + check_from);
            	Log.d("testing", "Test check from " + check_to);
            	Log.d("testing", "Test check from " + date[2]);
            	Log.d("testing", "Test check from " + date[1]);
            	Log.d("testing", "Test check from " + date[0]);
            	Log.d("testing", "Test check from " + check_desc);
            	Log.d("testing", "Test check from " + phoneNumber);
            	Log.d("testing", "Test check from " + time[0]);
            	Log.d("testing", "Test check from " + time[1]);*/
            	Log.d("testing","Test check form " + Integer.parseInt(check_seats));
            	RideModel.getInstance().insertRides(new Ride(check_from, check_to, date[2],date[1], date[0], 0, check_desc, phoneNumber, "Hans Juergen", "test.test@test.at@", time[0], time[1], Integer.parseInt(check_seats)));
            	Log.d("testing", "after insert Rides ");
            	
            	//close activity
            	finish();
            }
        });
        
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.menu, menu);
		return true;
	}

}
