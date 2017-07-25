package com.ats.eCommerce.dao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ParseDate {
	public static Date parseDate(String date) {
	     try {
	         return new SimpleDateFormat("yyyy-MM-dd").parse(date);
	     } catch (ParseException e) {
	    	 Error.class.getName();
	    	 System.err.println("Parse fallito.");
	         return null;
	     }
	  }

}