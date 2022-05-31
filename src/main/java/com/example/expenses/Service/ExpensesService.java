package com.example.expenses.Service;

import java.sql.Date;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.expenses.Entity.Expenses;
import com.example.expenses.Repository.ExpensesRepository;

@Service
public class ExpensesService {

	@Autowired
	private ExpensesRepository expenseRepository;
	
	
	
	public List<Expenses> getAllExpenses()
	{
		return expenseRepository.findAll();
	}



	public  Expenses save(Expenses expenses) {
		
		Long id = expenses.getUtr();
		if(expenseRepository.existsById(id))
		{
			return null;
		}
		
		return expenseRepository.save(expenses);
		
		
	}



	public List<Expenses> getExpensesofCurrentMonth() {
		
		LocalDate today = LocalDate.now();
		LocalDate firstDayOfMonth = today.with(TemporalAdjusters.firstDayOfMonth());
		LocalDate lastDayOfMonth = today.with(TemporalAdjusters.lastDayOfMonth());
		
		return expenseRepository.findExpensesOfCurrentMonth(Date.valueOf(firstDayOfMonth),
				                                            Date.valueOf(lastDayOfMonth));
		
		
		
	}
	
	
}
