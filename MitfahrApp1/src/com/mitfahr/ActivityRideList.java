package com.mitfahr;



import java.util.Date;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.*;

public class ActivityRideList extends Activity implements OnItemClickListener{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_ride_list);
		ListView listView = (ListView) findViewById(R.id.list_RideList);
		
			
		
		ArrayAdapter<String> listAdapter = new ArrayAdapter<String>(
				this, R.layout.viewlist_adapter_rides);
		
		
		
	
		for(int i = 0; i<5; i++){
			
			listAdapter.add("bla");
			
			
		}
		listView.setTranscriptMode(ListView.TRANSCRIPT_MODE_NORMAL);
		listView.setAdapter(listAdapter);
		
		listView.setFocusable(true);
		listView.setClickable(true);
		listView.setFocusableInTouchMode(true);
	

	}
		

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_ride_list, menu);
		return true;
	}



	@Override
	public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
		setContentView(R.layout.activity_agb);
	}

	
}
