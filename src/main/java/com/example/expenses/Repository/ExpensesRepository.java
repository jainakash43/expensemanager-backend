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

	
	
	@Query(value=" select * from expenses"
			          + " where to_date(dateofexpense,'DD MON YYYY') >= :firstDay AND "
			          + "to_date(dateofexpense,'DD MON YYYY') <= :lastDay"
			          + " ORDER BY to_date(dateofexpense,'DD MON YYYY') ", nativeQuery=true)
	List<Expenses> findExpensesOfCurrentMonth(@Param("firstDay") Date f,@Param("lastDay")Date l);
	
	
	
	
	
	

}
