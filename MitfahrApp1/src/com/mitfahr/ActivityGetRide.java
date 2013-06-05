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

		Button button_search = (Button) findViewById(R.id.btn_activity_getride_go);
		
		button_search.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {

				Intent inte = new Intent(ActivityGetRide.this,
						ActivityRideList.class);
				
				ActivityGetRide.this.startActivity(inte);
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
