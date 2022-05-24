package com.example.expenses.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.expenses.Entity.Expenses;


@Repository
public interface ExpensesRepository extends JpaRepository<Expenses, Long> {

}
