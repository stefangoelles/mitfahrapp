package com.mitfahr;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;



import android.os.Bundle;
import android.app.Activity;
import android.graphics.Color;
import android.text.format.DateFormat;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.AdapterView;
import android.widget.TextView;

public class ActivityGetRide<T> extends Activity 
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
		setContentView(R.layout.activity_getride);
		
		ArrayAdapter<String> listAdapter = new ArrayAdapter<String>(
				this, R.layout.viewlist_adapter_rides);
		
		ListView listView = (ListView) findViewById(R.id.list_getRide);
		
		
		for(int i = 0; i<50; i++){
			
			listAdapter.add("bla");
			
			
		}
		listView.setTranscriptMode(ListView.TRANSCRIPT_MODE_NORMAL);
		listView.setAdapter(listAdapter);
	
		
		
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) 
	{
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_ride, menu);
		return true;
	}
	
	
	
	

}
