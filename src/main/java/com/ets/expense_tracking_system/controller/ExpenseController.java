package com.ets.expense_tracking_system.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
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
	@GetMapping("/expenses/{id}")
	public String getExpenseById(@PathVariable("id") Long id){
		return "The expense ID is: "+id;
	}
	@DeleteMapping("/expenses")
	public String deleteExpenseById(@RequestParam("id") Long id){
		return "The expense ID is: "+id;
	}
}
