package com.mitfahr;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class ActivityStatistic extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_statistic);

		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.menu, menu);
		return true;
	}
	
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
	    case R.id.about:
	    	startActivity(new Intent(this, com.mitfahr.ActivityImpressum.class));
	   // startActivity(new Intent(this, Impressum.class));
	    return true;
	    case R.id.statistics:
	    	startActivity(new Intent(this, com.mitfahr.ActivityStatistic.class));
	    //startActivity(new Intent(this, Help.class));
	    return true;
	    case R.id.exit:
	    	System.exit(0);
	    default:
	    return super.onOptionsItemSelected(item);
	}

	}

}
