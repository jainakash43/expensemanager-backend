package com.example.expenses.Controller;

import java.time.LocalDate;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.expenses.Entity.Expenses;
import com.example.expenses.Exception.ResourceConflictException;
import com.example.expenses.Exception.ResourceNotFoundException;
import com.example.expenses.Service.ExpensesService;

@RestController
@RequestMapping("/")
@CrossOrigin(origins = {"*"} /*{"http://expensetest.s3-website-us-east-1.amazonaws.com","http://localhost:4200"}*/ )
public class ExpensesController {

	@Autowired
	private ExpensesService expensesService;
	
	
	@PostMapping("/addExpense")
	public ResponseEntity<Expenses> PostExpense(@RequestBody Expenses expenses)
	{
		
		Expenses exp = expensesService.save(expenses);
		
		if(exp == null)
		{
			throw new ResourceConflictException("UTR Already Exists");
		}
		
		return new ResponseEntity<>(exp,HttpStatus.CREATED);
	}
	
	@GetMapping("/getExpensesOfCurrentMonth")
	public List<Expenses> getExpensesofCurrentMonth()
	{
		
		List<Expenses> temp = expensesService.getExpensesofCurrentMonth();
		
		 if(temp.isEmpty())
			{
				throw new ResourceNotFoundException("No Data Available");
			}
	    
	    return temp;
	}
	
	
}
