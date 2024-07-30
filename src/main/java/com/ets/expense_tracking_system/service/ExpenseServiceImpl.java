package com.ets.expense_tracking_system.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ets.expense_tracking_system.entity.Expense;
import com.ets.expense_tracking_system.repository.ExpenseRepository;

@Service
public class ExpenseServiceImpl implements ExpenseService{
	@Autowired
	private ExpenseRepository expenseRepo;
	@Override
	public List<Expense> getAllExpenses() {
		return expenseRepo.findAll();
	}

}
