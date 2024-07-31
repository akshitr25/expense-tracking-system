package com.ets.expense_tracking_system.controller;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.ets.expense_tracking_system.entity.Expense;
import com.ets.expense_tracking_system.service.ExpenseService;

import jakarta.validation.Valid;

@RestController
public class ExpenseController {
	@Autowired
	private ExpenseService expenseService;
	@GetMapping("/expenses")
	public List<Expense> getAllExpenses(Pageable page){
		return expenseService.getAllExpenses(page).toList();
	}
	@GetMapping("/expenses/{id}")
	public Expense getExpenseById(@PathVariable("id") Long id){
		return expenseService.getExpenseById(id);
	}
	@ResponseStatus(value=HttpStatus.NO_CONTENT)
	@DeleteMapping("/expenses")
	public void deleteExpenseById(@RequestParam("id") Long id){
		expenseService.deleteExpenseById(id);
	}
	@ResponseStatus(value=HttpStatus.CREATED)
	@PostMapping("/expenses")
	public Expense saveExpenseDetails(@Valid @RequestBody Expense expense) {
		expenseService.saveExpenseDetails(expense);
		System.out.println("***************Printing the expense details: "+expense+"***************");
		return expense;
	}
	@PutMapping("/expenses/{id}")
	public void updateExpenseDetails(@RequestBody Expense expense, @PathVariable Long id) {
		expenseService.updateExpenseDetails(id, expense);
		System.out.println("***************Printing the expense details: "+expense+"***************");
	}
	@GetMapping("/expenses/category")
	public List<Expense> getExpensesByCategory(@RequestParam String category,Pageable page){//{{url}}/expenses/category?category=Bills
		return expenseService.readByCategory(category, page);
	}
	@GetMapping("/expenses/name")
	public List<Expense> getExpensesByName(@RequestParam String keyword, Pageable page){//{{url}}/expenses/name?keyword=Petrol
		return expenseService.readByName(keyword, page);
	}
	@GetMapping("/expenses/date")
	public List<Expense> getExpensesByDates(@RequestParam(required=false) Date startDate,
			@RequestParam(required=false) Date endDate,
			Pageable page){//{{url}}/expenses/date?startDate=2024-07-10&endDate=2024-07-20
		return expenseService.readByDate(startDate,endDate,page);
	}
}
