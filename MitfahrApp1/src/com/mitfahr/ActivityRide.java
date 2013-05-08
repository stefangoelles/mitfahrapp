package com.mitfahr;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;



import android.os.Bundle;
import android.app.Activity;
import android.graphics.Color;
import android.text.format.DateFormat;
import android.view.Menu;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.AdapterView;
import android.widget.TextView;

public class ActivityRide<T> extends Activity 
{
	private String from = "Graz";
	private String to = "Tiol";
	private static Date date;
	private Date time;
	private ArrayAdapter<String> array_ride;
	private EditText From;
	//private ArrayAdapter<String> mNewDevicesArrayAdapter;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_ride);
		
		List rideList = new ArrayList<String>();
		rideList.add("Item1");
		rideList.add("Item2");
		rideList.add("Item3");
		rideList.add("Item4");
		
		ListAdapter listAdapter = new ArrayAdapter<T>(getApplicationContext(), R.layout.custom_list_view, rideList);

//		array_ride = new ArrayAdapter<String>(this, R.layout.activity_ride, rideList);
		//final ListView listRideView = (ListView) findViewById(R.id.list_ride);
		//listRideView.setAdapter(array_ride);
		
		
		
		
		
		final ListView LV = (ListView)findViewById(R.id.list_ride);
		
		LV.setAdapter(listAdapter);
		
		
		
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) 
	{
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_ride, menu);
		return true;
	}
	
	
	
	

}
