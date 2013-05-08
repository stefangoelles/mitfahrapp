package com.mitfahr;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class ActivityOwnrides extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_ownrides);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_ownrides, menu);
		return true;
	}

}
