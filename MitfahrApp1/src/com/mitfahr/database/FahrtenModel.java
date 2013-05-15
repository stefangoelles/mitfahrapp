package com.mitfahr.database;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class FahrtenModel {

private static FahrtenModel instance; 


//in the meantime local variables and list are used TODO: create real database connection
List<Fahrt> Fahrten = new ArrayList<Fahrt>();	


private FahrtenModel(){
	
	
	//put your initialization here(http url, etc)
}

	public static FahrtenModel getInstance()
	{
		if (instance == null) {
			instance = new FahrtenModel();
		}
		return instance;
	}
		
	
	public List<Fahrt> getFahrten()
	{
		return Fahrten;
	}
	
	public void editFahrt(int ID){
		
	}
	
	public void getFahrtbyID(int ID){
		
	}
	
	public void insertFahrt(Fahrt fahrt)
	{
		Fahrten.add(fahrt);
	}
	
	public List<Fahrt> getFahrten(String from, String to, int year, int month, int day, int costs, String aso, 
			String phone, String name, String email, int hour, int minute)
	{
		// TODO: implement correct database search(like) with overriden methods(costs from-to and so on...)
		java.text.SimpleDateFormat date_format = new java.text.SimpleDateFormat("yyyy-MM-dd");
		List<Fahrt> result = new ArrayList<Fahrt>();
		Iterator<Fahrt> it = Fahrten.iterator();
		while(it.hasNext())
		{
		    Fahrt fahrt = it.next();
		    if(!(from==null) && fahrt.getFrom() == from){
		    	result.add(fahrt);
		    } else if (!(to==null) && fahrt.getTo() == to){
		    	result.add(fahrt);
		    } else if (fahrt.getDate() == date_format.format(new Date(year-1900, month-1, day))){
		    	result.add(fahrt);
		    } else if (fahrt.getCosts() == costs){
		    	result.add(fahrt);
		    } else if (!(aso==null) && fahrt.getAso() == aso){
		    	result.add(fahrt);
		    
 		} else if (!(phone==null) && fahrt.getPhone() == phone){
	    	result.add(fahrt);
		    
		} else if (!(name==null) && fahrt.getName() == name){
	    	result.add(fahrt);
		    
		} else if (!(email==null) && fahrt.getEmail() == email){
	    	result.add(fahrt);
		    
		}
	}
		return result;
	
}
	
}
