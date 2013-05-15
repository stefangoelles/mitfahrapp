package com.mitfahr;

import com.mitfahr.R.layout;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ActivityTrip extends Activity {
	
	private String from;
	private String to;
	private String date;
	private String time;
	private Integer seats;
	private String desc;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_trip);
		
		
		Button button_weiter = (Button) findViewById(R.id.btn_weiter);
		
		button_weiter.setOnClickListener(new OnClickListener()
	    {
	      public void onClick(View v)
	      {
	    	  
	    	  try{
	    	 //Intent inte = new Intent(ActivityTrip.this, ActivityCheckInput.class);
	    	 
	    	  final EditText edit_text_von = (EditText) findViewById(R.id.txt_trip_von);
	    	  from = edit_text_von.getText().toString();
	    	  final EditText edit_text_bis = (EditText) findViewById(R.id.txt_bis);
	    	  to = edit_text_bis.getText().toString();
	    	
	    	  final EditText edit_text_date = (EditText) findViewById(R.id.txt_date);
	    	  date = edit_text_date.getText().toString();
	    	  
	    	  final EditText edit_text_time= (EditText) findViewById(R.id.txt_time);
	    	  time = edit_text_time.getText().toString();
	    	  
	    	  final EditText edit_text_seats = (EditText) findViewById(R.id.txt_size);
	    	  seats = Integer.parseInt(edit_text_seats.getText().toString());
	    	  
	    	  final EditText edit_text_desc = (EditText) findViewById(R.id.txt_beschreibung);
	    	  desc = edit_text_desc.getText().toString();
	    	  
	    	  Log.d("DebugActivityTrip_von: ", from);
	    	  Log.d("DebugActivityTrip_bis: ", to);
	    	  Log.d("DebugActivityTrip_date: ", date);
	    	  Log.d("DebugActivityTrip_time: ", time);
	    	  Log.d("DebugActivityTrip_seats: ", seats.toString());
	    	  Log.d("DebugActivityTrip_desc: ", desc);
	    	  
	    	  
	    	  
	    	 Toast.makeText(getApplicationContext(),to, Toast.LENGTH_LONG).show();
	    	 
	    	 //ActivityTrip.this.startActivity(inte);
	    	 
	    	  }
	    	  
	    	  catch(Exception E){
	              Toast.makeText(v.getContext(),E.toString(), Toast.LENGTH_SHORT).show();
	          }
	      }
	    });
		
	 
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_trip, menu);
		return true;
	}
	

}
