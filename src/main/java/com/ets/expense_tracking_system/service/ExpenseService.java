package com.ets.expense_tracking_system.service;

import java.util.List;

import com.ets.expense_tracking_system.entity.Expense;

public interface ExpenseService {
	List<Expense> getAllExpenses();
	Expense getExpenseById(Long id);
	void deleteExpenseById(Long id);
}
