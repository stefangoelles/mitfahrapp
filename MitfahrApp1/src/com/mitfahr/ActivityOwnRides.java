package com.mitfahr;

import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONObject;
import android.app.ProgressDialog;
import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.widget.ListView;
import android.widget.Toast;
import android.widget.ArrayAdapter;

public class ActivityOwnRides extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_ownrides);

		try {

			new Thread(new Runnable() {

				ProgressDialog progressDialog = ProgressDialog.show(
						ActivityOwnRides.this, "", "Loading. Please wait...",
						true);
				ArrayAdapter<String> listAdapter = new ArrayAdapter<String>(
						ActivityOwnRides.this,
						R.layout.viewlist_adapter_ownrides);

				public void run() {

					try {
						HttpClient httpclient = new DefaultHttpClient();
						String url = "http://www.zauberbox.at/mitfahrapp/rest.php?function=get&format=json&email=test@test.test";
						// TODO Beliebige Email mit UserEmail ersetzen
						HttpGet httpget = new HttpGet(url);

						ResponseHandler<String> responseHandler = new BasicResponseHandler();

						String responseBody = httpclient.execute(httpget,
								responseHandler);

						// Parse
						JSONObject json = new JSONObject(responseBody);
						JSONArray jArray = json.getJSONArray("trips");

						// Erzeugt einen ListView Eintrag
						for (int i = 0; i < jArray.length(); i++) {
							String trip_info = "";
							String s = jArray.getJSONObject(i)
									.getString("trip");
							JSONObject jObjectTrip = new JSONObject(s);

							trip_info += jObjectTrip.getString("date") + " um ";
							trip_info += jObjectTrip.getString("time")
									+ " Uhr\n";
							trip_info += "von " + jObjectTrip.getString("from")
									+ " nach ";
							trip_info += jObjectTrip.getString("to") + "\n";
							trip_info += "Kosten pro Person: "
									+ jObjectTrip.getString("costs") + "\n\n";
							trip_info += jObjectTrip.getString("aso");
							// TODO Von datenbank werden alle attribute geholt -
							// hier werden nicht alle eingesetzt

							listAdapter.add(trip_info);
						}

					} catch (Exception e) {
						Toast.makeText(getApplicationContext(), e.toString(),
								Toast.LENGTH_LONG).show();

					}
					runOnUiThread(new Runnable() {

						@Override
						public void run() {

							// Find the ListView ressource
							progressDialog.dismiss();
							ListView listView = (ListView) findViewById(R.id.editListView);
							listView.setAdapter(listAdapter);

						}
					});

				}
			}).start();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_ownrides, menu);
		return true;
	}
}
