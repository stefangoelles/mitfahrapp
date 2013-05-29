package com.mitfahr;

import android.util.Log;

public class Utils {

	private static Utils instance; 

	
	public static Utils getInstance()
	{
		if (instance == null) {
			instance = new Utils();
			Log.d("testing", "Utils class new instance");
		}
		
		return instance;
	}
	
	/**
	 * Split the date into parts
	 * e.g. DD.MM.YYYY into [DD,MM,YYYY]
	 * @param date
	 * @return
	 */
	public int[] splitDate(String date){
		//Log.d("testing", "Utils split date started .. " + date);
		String dateParts[] = date.split("\\.+", 3);
		
		int parts[] = {Integer.parseInt(dateParts[0]), Integer.parseInt(dateParts[1]), Integer.parseInt(dateParts[2])};
		//Log.d("testing", "parts = " + parts.toString() + "len " + parts.length);
		return parts;
	}
	
	public int[] splitTime(String time){
		//Log.d("testing",time);
		String timeParts[] = time.split("\\p{Punct}",2);
		//Log.d("testing", timeParts[0]);
		//Log.d("testing", timeParts[1]);
		
		int parts[] = {Integer.parseInt(timeParts[0]), Integer.parseInt(timeParts[1])};
		//Log.d("testing","Result " + parts[0]);
		return parts;
	}
	
}
