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
		
		 Button button = (Button) findViewById(R.id.btn_trip);
		
		 button.setOnClickListener(new OnClickListener()
		    {
		      public void onClick(View v)
		      {
		    	  //Intent inte = new Intent(MainWindow.this, ClassTrip.class);
		    	  //MainWindow.this.startActivity(inte);
		    	  setContentView(R.layout.activity_trip);
		    	  
		    	  
		    	  
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
