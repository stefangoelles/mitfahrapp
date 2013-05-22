package com.mitfahr;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.view.View.OnClickListener;
public class MainWindow extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main_window);
		
		 Button button_trip = (Button) findViewById(R.id.btn_trip);
		 Button button_ride = (Button) findViewById(R.id.btn_ride);
		 Button button_ownrides = (Button) findViewById(R.id.btn_ownrides);
		
		 button_trip.setOnClickListener(new OnClickListener()
		    {
		      public void onClick(View v)
		      {
		    	 Intent inte = new Intent(MainWindow.this, ActivityOfferRide.class);
		    	  MainWindow.this.startActivity(inte);
		      }
		    });
		 
		 button_ride.setOnClickListener(new OnClickListener()
		    {
		      public void onClick(View v)
		      {
		    	 Intent inte = new Intent(MainWindow.this, ActivityGetRide.class);
		    	  MainWindow.this.startActivity(inte);
		      }
		    });
		 
		 button_ownrides.setOnClickListener(new OnClickListener()
		    {
		      public void onClick(View v)
		      {
		    	 Intent inte = new Intent(MainWindow.this, ActivityOwnRides.class);
		    	  MainWindow.this.startActivity(inte);
		    	  finish();
		      }
		    });
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main_window, menu);
		return true;
	}
	

}
