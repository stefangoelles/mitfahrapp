package com.mitfahr;

import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Toast;

public class ActivityCheckTrip extends Activity {
	private String check_from;
	private String check_to;
	private String check_date;
	private String check_time;
	private String check_seats;
	private String check_desc;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_check_trip);
		
		check_from = getIntent().getStringExtra("from");
		check_to = getIntent().getStringExtra("to");
		check_date = getIntent().getStringExtra("date");
		check_time = getIntent().getStringExtra("time");
		check_seats = getIntent().getStringExtra("seats");
		check_desc = getIntent().getStringExtra("desc");
		
		
		Log.d("DEBUG ActivityCheckTrip", check_from);
		Log.d("DEBUG ActivityCheckTrip", check_to);
		Log.d("DEBUG ActivityCheckTrip", check_date);
		Log.d("DEBUG ActivityCheckTrip", check_time);
		Log.d("DEBUG ActivityCheckTrip", check_seats);
		Log.d("DEBUG ActivityCheckTrip", check_desc);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_check_trip, menu);
		return true;
	}

}
