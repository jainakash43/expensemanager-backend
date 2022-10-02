package com.example.expenses.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.example.expenses.Entity.Budget;
import com.example.expenses.Repository.BudgetRepository;

@Service
public class BudgetService {
	
	
	@Autowired
	private BudgetRepository budgetRepository;
	
	@Transactional
	public  Budget save(int amount)
	{
		String yearmon = getYearMon(LocalDate.now());
		Optional<Budget> bud = budgetRepository.findById(yearmon);
		if(bud.isPresent())
		{
			Budget updateBudget = bud.get();
			updateBudget.setAmount(amount);
			budgetRepository.save(updateBudget);
		}
		else
		{
			Budget newBudget = new Budget();
			newBudget.setYearmon(yearmon);
			newBudget.setAmount(amount);
			newBudget.setMonth(getCurrentMonth(LocalDate.now()));
			newBudget.setYear(LocalDate.now().getYear());
			budgetRepository.save(newBudget);
		}
		bud = budgetRepository.findById(yearmon);
		return bud.get();
		
		
	   
		
		
		
		 
	}
	
	
	public Budget getBudget(String yearmon)
	{
		Optional<Budget> budgetResponse = budgetRepository.findById(yearmon);
		Budget budget = budgetResponse.get();
		return budget;
	}
	
	private static String getYearMon(LocalDate today)
	{
		String date[]=today.toString().split("-");
		String yearmon=date[0]+date[1];
		return yearmon;
	}
	private static String getCurrentMonth(LocalDate today)
	{
		String currentMonth = today.getMonth().toString();
		return StringUtils.capitalize(currentMonth);
		
	}
	
	
}
