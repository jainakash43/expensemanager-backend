package com.example.expenses.Repository;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class testing {

	public static void main(String args[]) throws ParseException
	{
		  LocalDate date = LocalDate.now();
		  DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d MMMM yyyy");
		  String text = "10 May 2020";
		  LocalDate parsedDate = LocalDate.parse(text, formatter);
		  System.out.println(parsedDate);
	}
}
