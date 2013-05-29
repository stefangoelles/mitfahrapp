package com.mitfahr;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class ActivityImpressum extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_impressum);
		
		
		Button agb = (Button) findViewById(R.id.btn_agb);
		
		 agb.setOnClickListener(new OnClickListener()
		    {
		      public void onClick(View v)
		      {
		    	 Intent inte = new Intent(ActivityImpressum.this, ActivityAGB.class);
		    	  //ActivityImpressum.this.startActivity(inte);
		    	  setContentView(R.layout.activity_agb);
	
		      }
		    });
		
		
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_impressum, menu);
		return true;
	}

}
