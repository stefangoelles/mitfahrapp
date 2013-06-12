package com.mitfahr;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ActivityRideList extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_ride_list);
		
		ArrayAdapter<String> listAdapter = new ArrayAdapter<String>(
				this, R.layout.viewlist_adapter_rides);
		
		ListView listView = (ListView) findViewById(R.id.list_RideList);
		
		
		for(int i = 0; i<50; i++){
			
			listAdapter.add("bla");
			
			
		}
		listView.setTranscriptMode(ListView.TRANSCRIPT_MODE_NORMAL);
		listView.setAdapter(listAdapter);
	
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_ride_list, menu);
		return true;
	}

}
