package com.mitfahr;

import com.mitfahr.database.Ride;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ActivityOfferRide extends Activity {

	
	private String from;
	private String to;
	private String time;
	private Integer seats;
	private String desc;
	private String date;
	private int costs;
	private String phone;
	private String name;
	private String email;
	private int hour;
	private int minute;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_offerride);

		Button button_weiter = (Button) findViewById(R.id.btn_activityOfferride_next);

		button_weiter.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {

				Intent inte = new Intent(ActivityOfferRide.this,
						ActivityCheckTrip.class);
				try {

					Log.d("fail","fail");

				}

catch (Exception E) {
	Log.d("catch","fail");

				}

				Log.d("DEBUG ActivityTrip: from", from);
				Log.d("DEBUG ActivityTrip: to", to);
				Log.d("DEBUG ActivityTrip: date", date);
				Log.d("DEBUG ActivityTrip: time", time);
				Log.d("DEBUG ActivityTrip: seats", seats.toString());
				Log.d("DEBUG ActivityTrip: desc", desc);

		DateValidator val = new DateValidator();

				if (from.length() < 1 || to.length() < 1 || date.length() < 1
						|| time.length() < 1 || seats.equals(null)) {
					Toast.makeText(v.getContext(),
							"Bitte alle Felder ausfüllen!", Toast.LENGTH_SHORT)
							.show();
				}

				else if (val.isThisDateValid(date, "dd.MM.yyyy") == false) {
					Log.d("Date not valid........", "bla");
					Toast.makeText(v.getContext(),
							"Bitte Datum im Format dd.MM.yyyy eingeben!",
							Toast.LENGTH_SHORT).show();
				}

				else if (val.isThisDateValid(time, "hh:mm") == false) {
					Log.d("Time not valid........", "bla");
					Toast.makeText(v.getContext(),
							"Bitte Zeit im Format hh:mm eingeben!",
							Toast.LENGTH_SHORT).show();
				}

				else {
					inte.putExtra("from", from);
					inte.putExtra("to", to);
					inte.putExtra("date", date);
					inte.putExtra("time", time);
					inte.putExtra("seats", seats.toString());
					inte.putExtra("desc", desc);

					
					int dateParts[] = Utils.getInstance().splitDate(date);
					
					Ride ride = new Ride(from, to, dateParts[2], dateParts[1], dateParts[0], costs, desc, phone, name, email, hour, minute);
					
					
					ActivityOfferRide.this.startActivity(inte);
				}
			}
		});

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.menu, menu);
		return true;
	}

}
