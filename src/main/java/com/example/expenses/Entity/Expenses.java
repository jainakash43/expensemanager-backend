package com.example.expenses.Entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Expenses {

	@Id
	private long utr;
	
	private String dateofexpense;
	
	private String category;
	
	private String description;
	
	private int amount;
	
	
	
	public Expenses() {
	
	}

	public Expenses(long utr, String dateofexpense, String category, String description, int amount) {
		this.utr = utr;
		this.dateofexpense = dateofexpense;
		this.category = category;
		this.description = description;
		this.amount = amount;
	}

	public long getUtr() {
		return utr;
	}

	public void setUtr(long utr) {
		this.utr = utr;
	}

	public String getDateofexpense() {
		return dateofexpense;
	}

	public void setDateofexpense(String dateofexpense) {
		this.dateofexpense = dateofexpense;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}
	
}
