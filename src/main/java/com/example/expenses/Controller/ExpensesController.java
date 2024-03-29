package com.example.expenses.Controller;



import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.expenses.Entity.Budget;
import com.example.expenses.Entity.Expenses;
import com.example.expenses.Exception.ResourceConflictException;
import com.example.expenses.Exception.ResourceNotFoundException;
import com.example.expenses.Service.BudgetService;
import com.example.expenses.Service.ExpensesService;

@RestController
@RequestMapping("/")
@CrossOrigin(origins = {"*"} /*{"http://expensetest.s3-website-us-east-1.amazonaws.com","http://localhost:4200"}*/ )
public class ExpensesController {

	@Autowired
	private ExpensesService expensesService;
	
	@Autowired
	private BudgetService budgetService;
	

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
	
	@GetMapping("/getTotalExpensesOfCurrentMonth")
	public int  getTotalExpensesofCurrentMonth()
	{
		int total = 0;
		
		total = expensesService.getTotalExpensesOfCurrentMonth();
		
		return total;
	}
	
	
	@GetMapping("/getBudget/{yearmon}")
	public ResponseEntity<Budget> getMonthlyBudget(@PathVariable String yearmon)
	{
	
	      Budget budget = budgetService.getBudget(yearmon);
	      
	      return new ResponseEntity<>(budget,HttpStatus.OK);
	
		
	}
	
	@PostMapping("/setBudget/{amount}")
	public ResponseEntity<Budget> setMonthlyBudget(@PathVariable int amount)
	{
		Budget budget = budgetService.save(amount);
		return new ResponseEntity<>(budget,HttpStatus.OK);
	}
	
	
    
	
	
	
	
}
