package com.mitfahr;

import java.util.Iterator;
import java.util.List;

import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONObject;

import com.mitfahr.database.Ride;
import com.mitfahr.database.RideModel;

import android.app.ProgressDialog;
import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.widget.ListView;
import android.widget.Toast;
import android.widget.ArrayAdapter;

public class ActivityOwnRides extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_ownrides);

		
		
		
			new Thread(new Runnable() {

				ProgressDialog progressDialog = ProgressDialog.show(
						ActivityOwnRides.this, "", "Loading. Please wait...",
						true);
				ArrayAdapter<String> listAdapter = new ArrayAdapter<String>(
						ActivityOwnRides.this,
						R.layout.viewlist_adapter_ownrides);
				List<Ride> ride_list;

				public void run() {

	
	
							
							
					ride_list = RideModel.getInstance().getRides();
					
			
					runOnUiThread(new Runnable() {

						@Override
						public void run() {

							// Find the ListView ressource
							progressDialog.dismiss();
							Iterator<Ride> iterator = ride_list.iterator(); 
							
							while(iterator.hasNext())
							{
								Ride ride= iterator.next();
						
								String ride_string = "";
								ride_string += ride.getFrom() + " ";
								ride_string += ride.getTo() + " ";
								ride_string += ride.getDate() + " ";
								ride_string += ride.getTime() + " ";
							
								listAdapter.add(ride_string);
							}
							ListView listView = (ListView) findViewById(R.id.editListView);
							listView.setAdapter(listAdapter);

						}
					});

			}
	}).start();

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_ownrides, menu);
		return true;
	}
}
