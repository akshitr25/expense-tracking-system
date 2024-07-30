package com.ets.expense_tracking_system.service;

import java.util.List;
import java.util.Optional;

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
	@Override
	public Expense getExpenseById(Long id) {
		Optional<Expense> expense=expenseRepo.findById(id);
		if(expense.isPresent())
			return expense.get();
		else
			throw new RuntimeException("Exception is not found for the id: "+id);
	}
	@Override
	public void deleteExpenseById(Long id) {
		expenseRepo.deleteById(id);
	}

}
