package com.ets.expense_tracking_system.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ets.expense_tracking_system.entity.Expense;

@Repository
public interface ExpenseRepository extends JpaRepository<Expense, Long>{

}
