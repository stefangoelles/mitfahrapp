package com.mitfahr;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;



import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.text.format.DateFormat;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.AdapterView;
import android.widget.TextView;

public class ActivityGetRide<T> extends Activity 
{
	private String from = "Graz";
	private String to = "Tirol";
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

		Button button_search = (Button) findViewById(R.id.btn_activity_getride_go);
		
		button_search.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {

				Intent inte = new Intent(ActivityGetRide.this,
						ActivityRideList.class);
				
				
				EditText et = (EditText) findViewById(R.id.txt_getRide_from);
				String from = et.getText().toString();
				
				EditText et2 = (EditText) findViewById(R.id.txt_getRide_to);
				String to = et2.getText().toString();

				EditText et3 = (EditText) findViewById(R.id.txt_getRide_date);
				String date = et3.getText().toString();
				
				EditText et4 = (EditText) findViewById(R.id.txt_getRide_time);
				String time = et4.getText().toString();
				
				
				inte.putExtra("from", from);
				inte.putExtra("to", to);
				inte.putExtra("date", date);
				inte.putExtra("time", time);
				
				ActivityGetRide.this.startActivity(inte);
				
				
				/*
				
				//TODO daten von view id an RideList übergeben
				Intent i = new Intent(this, ActivityRideList.class);
				
				*/
				
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) 
	{
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.menu, menu);
		return true;
	}
	
	
	
	

}
