package com.mitfahr;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
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
		
		Button button_store_to_db = (Button) findViewById(R.id.btn_check_trip_store);
		
		check_from = getIntent().getStringExtra("from");
		check_to = getIntent().getStringExtra("to");
		check_date = getIntent().getStringExtra("date");
		check_time = getIntent().getStringExtra("time");
		check_seats = getIntent().getStringExtra("seats");
		check_desc = getIntent().getStringExtra("desc");
		
		
	    TextView text = (TextView) findViewById(R.id.lbl_check_trip_from);
	    text.setText(check_from);
	    text = (TextView) findViewById(R.id.lbl_check_trip_to);
	    text.setText(check_to);
	    text = (TextView) findViewById(R.id.lbl_check_trip_date);
	    text.setText(check_date);
	    text = (TextView) findViewById(R.id.lbl_check_trip_time);
	    text.setText(check_time);
	    text = (TextView) findViewById(R.id.lbl_check_trip_seats);
	    text.setText(check_seats);
	    text = (TextView) findViewById(R.id.lbl_check_trip_desc);
	    text.setText(check_desc);
		
		Log.d("DEBUG ActivityCheckTrip", check_from);
		Log.d("DEBUG ActivityCheckTrip", check_to);
		Log.d("DEBUG ActivityCheckTrip", check_date);
		Log.d("DEBUG ActivityCheckTrip", check_time);
		Log.d("DEBUG ActivityCheckTrip", check_seats);
		Log.d("DEBUG ActivityCheckTrip", check_desc);
		
		button_store_to_db.setOnClickListener(new OnClickListener()
	    {
	      public void onClick(View v)
	      {
	    	 //IMPLEMENTATION
	    	//store to database here
	    	  Log.d("DEBUG OUTPUT", "DATA successfully stored to Database!");
	    	  
	      }
	    });
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_check_trip, menu);
		return true;
	}

}
