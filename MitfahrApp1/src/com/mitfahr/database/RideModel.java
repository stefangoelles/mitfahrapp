package com.mitfahr.database;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class RideModel {

private static RideModel instance; 


//in the meantime local variables and list are used TODO: create real database connection
List<Ride> rideen = new ArrayList<Ride>();	


private RideModel(){
	
	
	//put your initialization here(http url, etc)
}

	public static RideModel getInstance()
	{
		if (instance == null) {
			instance = new RideModel();
		}
		return instance;
	}
		
	
	public List<Ride> getRides()
	{
		return rideen;
	}
	
	public void editRides(int ID){
		
	}
	
	public void getRidesbyID(int ID){
		
	}
	
	public void insertRides(Ride ride)
	{
		rideen.add(ride);
	}
	
	public List<Ride> getRides(String from, String to, int year, int month, int day, int costs, String aso, 
			String phone, String name, String email, int hour, int minute)
	{
		// TODO: implement correct database search(like) with overriden methods(costs from-to and so on...)
		java.text.SimpleDateFormat date_format = new java.text.SimpleDateFormat("yyyy-MM-dd");
		List<Ride> result = new ArrayList<Ride>();
		Iterator<Ride> it = rideen.iterator();
		while(it.hasNext())
		{
		    Ride ride = it.next();
		    if(!(from==null) && ride.getFrom() == from){
		    	result.add(ride);
		    } else if (!(to==null) && ride.getTo() == to){
		    	result.add(ride);
		    } else if (ride.getDate() == date_format.format(new Date(year-1900, month-1, day))){
		    	result.add(ride);
		    } else if (ride.getCosts() == costs){
		    	result.add(ride);
		    } else if (!(aso==null) && ride.getAso() == aso){
		    	result.add(ride);
		    
 		} else if (!(phone==null) && ride.getPhone() == phone){
	    	result.add(ride);
		    
		} else if (!(name==null) && ride.getName() == name){
	    	result.add(ride);
		    
		} else if (!(email==null) && ride.getEmail() == email){
	    	result.add(ride);
		    
		}
	}
		return result;
	
}
	
}
