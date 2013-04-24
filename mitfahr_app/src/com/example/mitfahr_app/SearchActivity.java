package com.example.mitfahr_app;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class SearchActivity extends Activity {
	
	Button search;
	String von, nach, date;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_search);
		
		search = (Button)findViewById(R.id.btn_search);
		
		search.setOnClickListener(new OnClickListener()
		{
			public void onClick(View v)
			{
				Intent get_information = new Intent();
				von = getString(R.id.txt_von);
				nach = getString(R.id.txt_nach);
				date = getString(R.id.txt_date);
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.search_actifity, menu);
		return true;
	}
	

}
