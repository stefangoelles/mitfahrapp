package com.mitfahr;

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
	private EditText m_edit_text;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_trip);
		
		
		Button button_weiter = (Button) findViewById(R.id.btn_weiter);
		
		button_weiter.setOnClickListener(new OnClickListener()
	    {
	      public void onClick(View v)
	      {
	    	 //Intent inte = new Intent(ActivityTrip.this, ActivityCheckInput.class);
	    	 
	    	 m_edit_text = (EditText) findViewById(R.id.txt_trip_von);
	    	 from = m_edit_text.getText().toString();
	    	 
	    	 Toast.makeText(getApplicationContext(), from, Toast.LENGTH_LONG).show();
	    	 
	    	 //ActivityTrip.this.startActivity(inte);
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
