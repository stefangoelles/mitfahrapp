package com.mitfahr.database;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.json.JSONArray;
import org.json.JSONObject;


import android.util.Log;

public class RideModel {
	
	private boolean test = false;

	private static RideModel instance;

	
	public RideModel() {

		// put your initialization here(http url, etc)
	}

	public static RideModel getInstance() {
		if (instance == null) {
			instance = new RideModel();
		}
		return instance;
	}

	
	public List<Ride> getRides()
	{
		try {
			
List<Ride> rideen = new ArrayList<Ride>();
			
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

			Ride ride = new Ride();
			ride.setFrom(jObjectTrip.getString("from"));
			ride.setTo(jObjectTrip.getString("to"));
			ride.setDate(jObjectTrip.getString("date"));
			ride.setCosts(jObjectTrip.getInt("costs"));
			ride.setAso(jObjectTrip.getString("aso"));
			ride.setPhone(jObjectTrip.getString("phone"));
			ride.setName(jObjectTrip.getString("name"));
			ride.setEmail(jObjectTrip.getString("email"));
			ride.setTime(jObjectTrip.getString("time"));
			//ride.setFrom(jObjectTrip.getString("email")); TODO USW

			
			
			rideen.add(ride);
			
		}
		return rideen;

	} catch (Exception e) {
		e.printStackTrace();
	}
		
		
		
		
		return null;
	}
	
	public void editRides(Ride ride){
		
		
		try {

			HttpClient httpclient = new DefaultHttpClient();
			String url = "http://www.zauberbox.at/mitfahrapp/rest.php?function=update&ID=" + ride.getID() + "&from=" + ride.getFrom() + "&to=" + ride.getTo() + "&date=" + ride.getDate() + "&costs=" + ride.getCosts() + "&aso=" + ride.getAso() + "&phone=" + ride.getPhone() + "&name=" + ride.getName() + "&email=" + ride.getEmail() + "&time=" + ride.getTime() + "&seats=" + ride.getSeats();
			// TODO Beliebige Email mit UserEmail ersetzen
			
			HttpGet httpget = new HttpGet(url);

			ResponseHandler<String> responseHandler = new BasicResponseHandler();

			String responseBody = httpclient.execute(httpget,
					responseHandler);

			//TODO response from server handling

			
				
			
		} catch (Exception e) {
			e.printStackTrace();
		}
			
			
	
	}

	public void getRidesbyID(int ID) {

	}

	
	public void deleteRides(Ride ride)
	{
		try {
		HttpClient httpclient = new DefaultHttpClient();
		String url = "http://www.zauberbox.at/mitfahrapp/rest.php?function=delete&ID=" + ride.getID();
		// TODO Beliebige Email mit UserEmail ersetzen
		
		HttpGet httpget = new HttpGet(url);

		ResponseHandler<String> responseHandler = new BasicResponseHandler();

		String responseBody = httpclient.execute(httpget,
				responseHandler);

		//TODO response from server handling
		
		
	} catch (Exception e) {
		e.printStackTrace();
	}
		
		
	}
	
	public boolean insertRides(Ride ride)
	{
		
		Log.d("testing", "Insert Rides");
    	Log.d("testing", "From: " + ride.getFrom());
    	Log.d("testing", "To: " + ride.getTo());
    	Log.d("testing", "Date : " + ride.getDate());
    	Log.d("testing", "Costs : " + ride.getCosts());
    	Log.d("testing", "ASO : " + ride.getAso());
    	Log.d("testing", "Phone" + ride.getPhone());
    	Log.d("testing", "Name:  " +ride.getName());
    	Log.d("testing", "Time:  " + ride.getTime());
    	Log.d("testing", "Email:  " + ride.getEmail());
    	Log.d("testing", "Seats : " + ride.getSeats());
		
		try {	
			HttpClient httpclient = new DefaultHttpClient();
			String url = "http://www.zauberbox.at/mitfahrapp/rest.php?function=insert&from=" + ride.getFrom() + "&to=" + ride.getTo() + "&date=" + ride.getDate() + "&costs=" + ride.getCosts() + "&aso=" + ride.getAso() + "&phone=" + ride.getPhone() + "&name=" + ride.getName() + "&email=" + ride.getEmail() + "&time=" + ride.getTime() + "&seats=" + ride.getSeats();
			// TODO Beliebige Email mit UserEmail ersetzen
			
			Log.d("testing", "String " + url);
			
			Log.d("testing", "Before HTTP GET");
			HttpGet httpget = new HttpGet(url);
			Log.d("testing", "After HTTP GET " + httpget.toString());
        	
			ResponseHandler<String> responseHandler = new BasicResponseHandler();

			String responseBody = httpclient.execute(httpget,
					responseHandler);
			
			Log.d("testing", "Response Body: " + responseBody);
        	

			//Log.d("testing",responseBody);
			if (responseBody == "Kein email Parameter" || responseBody == "query_error")
			{
				return false;
			}else
			{
				return true;
			}
			//TODO response from server handling

	
				
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
			
			
	}

/*
	public List<Ride> getRides(String from, String to, int year, int month,
			int day, int costs, String aso, String phone, String name,
			String email, int hour, int minute) {
		// TODO: implement correct database search(like) with overriden
		// methods(costs from-to and so on...)
		java.text.SimpleDateFormat date_format = new java.text.SimpleDateFormat(
				"yyyy-MM-dd");
		List<Ride> result = new ArrayList<Ride>();
		Iterator<Ride> it = rideen.iterator();
		while (it.hasNext()) {
			Ride ride = it.next();
			if (!(from == null) && ride.getFrom() == from) {
				result.add(ride);
			} else if (!(to == null) && ride.getTo() == to) {
				result.add(ride);
			} else if (ride.getDate() == date_format.format(new Date(
					year - 1900, month - 1, day))) {
				result.add(ride);
			} else if (ride.getCosts() == costs) {
				result.add(ride);
			} else if (!(aso == null) && ride.getAso() == aso) {
				result.add(ride);

			} else if (!(phone == null) && ride.getPhone() == phone) {
				result.add(ride);

			} else if (!(name == null) && ride.getName() == name) {
				result.add(ride);

			} else if (!(email == null) && ride.getEmail() == email) {
				result.add(ride);

			}
		}
		return result;

	}
*/
	
	public List<Ride> getSearchedRides(String from, String to, String date,
			String time) {
		


		
		try {
			
List<Ride> rideList = new ArrayList<Ride>();
			
			HttpClient httpclient = new DefaultHttpClient();
			String url = "http://www.zauberbox.at/mitfahrapp/rest.php?function=find&format=json&from=" + from + "&to=" + to + "&date=" + date + "&time=" + time;
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

				Ride ride = new Ride();
				ride.setFrom(jObjectTrip.getString("from"));
				ride.setTo(jObjectTrip.getString("to"));
				ride.setDate(jObjectTrip.getString("date"));
				ride.setCosts(jObjectTrip.getInt("costs"));
				ride.setAso(jObjectTrip.getString("aso"));
				ride.setPhone(jObjectTrip.getString("phone"));
				ride.setName(jObjectTrip.getString("name"));
				ride.setEmail(jObjectTrip.getString("email"));
				ride.setTime(jObjectTrip.getString("time"));
				//ride.setFrom(jObjectTrip.getString("email")); TODO USW

				
				
				rideList.add(ride);


				
			}
			return rideList;
		} catch (Exception e) {
			e.printStackTrace();
		}
			
				
			
		return null;
		}

	public boolean isTest() {
		return test;
	}

	public void setTest(boolean test) {
		this.test = test;
	}
		
		
		

}

