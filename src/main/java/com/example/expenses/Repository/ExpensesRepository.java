package com.example.expenses.Repository;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.expenses.Entity.Expenses;


@Repository
public interface ExpensesRepository extends JpaRepository<Expenses, Long> {

	
}


