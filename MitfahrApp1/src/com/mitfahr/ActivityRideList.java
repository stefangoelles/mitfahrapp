package com.mitfahr;

import java.util.Iterator;
import java.util.List;

import com.mitfahr.database.Ride;
import com.mitfahr.database.RideModel;

import android.os.Bundle;
import android.app.Activity;
import android.app.ProgressDialog;
import android.view.Menu;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ActivityRideList extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_ride_list);

		ArrayAdapter<String> listAdapter = new ArrayAdapter<String>(this,
				R.layout.viewlist_adapter_rides);

		ListView listView = (ListView) findViewById(R.id.list_RideList);

		new Thread(new Runnable() {

			ProgressDialog progressDialog = ProgressDialog.show(
					ActivityRideList.this, "", "Loading. Please wait...", true);
			ArrayAdapter<String> listAdapter = new ArrayAdapter<String>(
					ActivityRideList.this, R.layout.viewlist_adapter_rides);
			List<Ride> ride_list;

			public void run() {

				Bundle b = getIntent().getExtras();
				String from = b.getString("from");
				String to = b.getString("to");
				String date = b.getString("date");
				String time = b.getString("time");

				ride_list = RideModel.getInstance().getSearchedRides(from, to,
						date, time);

				runOnUiThread(new Runnable() {

					@Override
					public void run() {

						// Find the ListView ressource
						progressDialog.dismiss();
						Iterator<Ride> iterator = ride_list.iterator();

						while (iterator.hasNext()) {
							Ride ride = iterator.next();

							String ride_string = "";
							ride_string += ride.getFrom() + " ";
							ride_string += ride.getTo() + " ";
							ride_string += ride.getDate() + " ";
							ride_string += ride.getTime() + " ";

							listAdapter.add(ride_string);
						}

						ListView listView = (ListView) findViewById(R.id.list_RideList);
						listView.setAdapter(listAdapter);

					}
				});

			}
		}).start();

		/*
		 * 
		 * 
		 * for(int i = 0; i<50; i++){
		 * 
		 * listAdapter.add("bla");
		 * 
		 * 
		 * } listView.setTranscriptMode(ListView.TRANSCRIPT_MODE_NORMAL);
		 * listView.setAdapter(listAdapter);
		 */
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_ride_list, menu);
		return true;
	}

}
