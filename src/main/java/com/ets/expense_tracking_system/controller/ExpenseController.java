package com.ets.expense_tracking_system.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ets.expense_tracking_system.entity.Expense;
import com.ets.expense_tracking_system.service.ExpenseService;

@RestController
public class ExpenseController {
	@Autowired
	private ExpenseService expsenseService;
	@GetMapping("/expenses")
	public List<Expense> getAllExpenses(){
		return expsenseService.getAllExpenses();
	}
}
