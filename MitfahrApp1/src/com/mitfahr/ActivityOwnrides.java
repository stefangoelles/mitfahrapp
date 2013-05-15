package com.mitfahr;

import java.io.IOException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.HttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.BasicHttpParams;
import org.json.JSONArray;
import org.json.JSONObject;
import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
//import android.util.Log; // TODO(0) löschen WENN Log NOCH NICHT VERWENDET WIRD.
import android.widget.ListView;
import android.widget.Toast;
import android.widget.ArrayAdapter;


//TODO löschen QUELLE: http://www.codeproject.com/Articles/267023/Send-and-receive-json-between-android-and-php

public class ActivityOwnrides extends Activity {

	int TIMEOUT_MILLISEC = 50000; // TODO(1) löschen wenn wir *Params und
									// TIMEOUT nicht brauchen

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_ownrides);


		// QUELLE:
		// http://androidarabia.net/quran4android/phpserver/connecttoserver.php

		try {


			HttpClient httpclient = new DefaultHttpClient();
			// HttpClient httpclient = new DefaultHttpClient(); //FALLS TODO(1)

			String url = "http://www.zauberbox.at/mitfahrapp/rest.php?function=get&format=json&email=test@test.test"; 
			// TODO(2) beliebige Email mit UserEmail ersetzen
			HttpGet httpget = new HttpGet(url);

			// Instantiate a GET HTTP method
			try {

				ResponseHandler<String> responseHandler = new BasicResponseHandler();

				String responseBody = httpclient.execute(httpget,
						responseHandler);

				// Parse
				JSONObject json = new JSONObject(responseBody);
				JSONArray jArray = json.getJSONArray("trips");

				// ArrayAdapter für ListView Einträge
				ArrayAdapter<String> listAdapter = new ArrayAdapter<String>(
						this, R.layout.viewlist_adapter_ownrides);

				// Find the ListView ressource
				ListView listView = (ListView) findViewById(R.id.editListView);

				// Erzeugt einen ListView Eintrag
				for (int i = 0; i < jArray.length(); i++) {
					String trip_info = "";
					String s = jArray.getJSONObject(i).getString("trip");
					JSONObject jObjectTrip = new JSONObject(s);

					trip_info += jObjectTrip.getString("date") + " um ";
					trip_info += jObjectTrip.getString("time") + " Uhr\n";
					trip_info += "von " + jObjectTrip.getString("from")
							+ " nach ";
					trip_info += jObjectTrip.getString("to") + "\n";
					trip_info += "Kosten pro Person: "
							+ jObjectTrip.getString("costs") + "\n\n";
					trip_info += jObjectTrip.getString("aso");
					// TODO(3) von datenbank werden alle attribute geholt - hier
					// werden nicht alle eingesetzt

					listAdapter.add(trip_info);
				}

				listView.setAdapter(listAdapter);

				// Json Body anzeigen TODO(4) irgendwann löschen
				// Toast.makeText(this, responseBody, Toast.LENGTH_LONG).show();

			} catch (ClientProtocolException e) {
				// TODO(5) Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO(5) Auto-generated catch block
				e.printStackTrace();
			}
		} catch (Throwable t) {
			Toast.makeText(this, "Request failed: " + t.toString(),
					Toast.LENGTH_LONG).show();
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_ownrides, menu);
		return true;
	}
}
