package com.example.expenses.Entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Budget {
	
	@Id
	private String yearmon;
	
	private String month;
	
	private int year;
	
	private int amount;

	public String getYearmon() {
		return yearmon;
	}

	public void setYearmon(String yearmon) {
		this.yearmon = yearmon;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}
	
	
	
	
	

}
