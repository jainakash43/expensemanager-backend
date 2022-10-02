package com.example.expenses.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.example.expenses.Entity.Budget;

public interface BudgetRepository extends JpaRepository<Budget, String> {
	
	

}
