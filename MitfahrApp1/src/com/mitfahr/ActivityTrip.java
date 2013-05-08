package com.mitfahr;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class ActivityTrip extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_trip);
		
		Button button_weiter = (Button) findViewById(R.id.btn_weiter);
		
		button_weiter.setOnClickListener(new OnClickListener()
	    {
	      public void onClick(View v)
	      {
	    	 Intent inte = new Intent(ActivityTrip.this, MainWindow.class);
	    	 ActivityTrip.this.startActivity(inte);
	    	 finish();
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
