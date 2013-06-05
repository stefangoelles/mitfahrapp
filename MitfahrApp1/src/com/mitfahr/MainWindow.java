package com.mitfahr;

import android.app.TabActivity;

import com.mitfahr.*;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;
import android.view.View.OnClickListener;
public class MainWindow extends TabActivity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main_window);
		

		Resources ressources = getResources(); 
		TabHost tabHost = getTabHost(); 
 
		// Home tab
		Intent intentHome = new Intent().setClass(this, ActivityOwnRides.class);
		TabSpec tabSpecHome = tabHost
		  .newTabSpec("Home")
		  .setIndicator("", ressources.getDrawable(R.drawable.icon_home_config))
		  .setContent(intentHome);
 
		// Create tab
		Intent intentCreate = new Intent().setClass(this, ActivityOfferRide.class);
		TabSpec tabSpecCreate = tabHost
		  .newTabSpec("Create")
		  .setIndicator("", ressources.getDrawable(R.drawable.icon_create_config))
		  .setContent(intentCreate);
 
		// Search tab
		Intent intentSearch = new Intent().setClass(this, ActivityGetRide.class);
		TabSpec tabSpecSearch = tabHost
		  .newTabSpec("Search")
		  .setIndicator("", ressources.getDrawable(R.drawable.icon_search_config))
		  .setContent(intentSearch);
 
		// About tab
		Intent intentAbout = new Intent().setClass(this, ActivityImpressum.class);
		TabSpec tabSpecAbout = tabHost
		  .newTabSpec("About")
		  .setIndicator("", ressources.getDrawable(R.drawable.icon_about_config))
		  .setContent(intentAbout);
 
		// add all tabs 
		tabHost.addTab(tabSpecHome);
		tabHost.addTab(tabSpecCreate);
		tabHost.addTab(tabSpecSearch);
		//tabHost.addTab(tabSpecAbout);
 
		//set Home tab gitas default (zero based)
		tabHost.setCurrentTab(0);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
	   // MenuInflater inflater = getMenuInflater();
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
