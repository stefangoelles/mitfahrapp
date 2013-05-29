package com.mitfahr;

public class Utils {

	private static Utils instance; 

	
	public static Utils getInstance()
	{
		if (instance == null) {
			instance = new Utils();
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
		String dateParts[] = date.split(".");
		
		int parts[] = {Integer.getInteger(dateParts[0]), Integer.getInteger(dateParts[1])};
		return dateParts;
	}
	
	public int[] splitTime(String time){
		String timeParts[] = time.split(":");
		
		int parts[] = {Integer.getInteger(timeParts[0]), Integer.getInteger(timeParts[1])};
		return parts;
	}
	
}
