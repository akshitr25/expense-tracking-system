package com.ets.expense_tracking_system.repository;

import java.sql.Date;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ets.expense_tracking_system.entity.Expense;

@Repository
public interface ExpenseRepository extends JpaRepository<Expense, Long>{
	//select * from tbl_expenses where category=?
	Page<Expense> findByCategory(String category,Pageable page);
	//select * from tbl_expenses where name like '%keyword%';
	Page<Expense> findByNameContaining(String keyword,Pageable page);
	//select * from tbl_expense where date between 'startDate' and 'endDate'
	Page<Expense> findByDateBetween(Date startDate,Date endDate, Pageable page);
}
