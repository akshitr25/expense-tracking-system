package com.ets.expense_tracking_system.service;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.ets.expense_tracking_system.entity.Expense;
import com.ets.expense_tracking_system.exceptions.ResourceNotFoundException;
import com.ets.expense_tracking_system.repository.ExpenseRepository;

@Service
public class ExpenseServiceImpl implements ExpenseService{
	@Autowired
	private ExpenseRepository expenseRepo;
	@Override
	public Page<Expense> getAllExpenses(Pageable page) {
		return expenseRepo.findAll(page);
	}
	@Override
	public Expense getExpenseById(Long id) {
		Optional<Expense> expense=expenseRepo.findById(id);
		if(expense.isPresent())
			return expense.get();
		else
			throw new ResourceNotFoundException("Expense is not found for the id: "+id);
	}
	@Override
	public void deleteExpenseById(Long id) {
		Expense expense=getExpenseById(id);
		expenseRepo.delete(expense);
	}
	@Override
	public Expense saveExpenseDetails(Expense expense) {
		return expenseRepo.save(expense);
	}
	@Override
	public Expense updateExpenseDetails(Long id, Expense expense) {
		Expense existingExpense=getExpenseById(id);
		existingExpense.setName(expense.getName()!=null?expense.getName():existingExpense.getName());
		existingExpense.setDescription(expense.getDescription()!=null?expense.getName():existingExpense.getDescription());
		existingExpense.setCategory(expense.getCategory()!=null?expense.getName():existingExpense.getCategory());
		existingExpense.setAmount(expense.getAmount()!=null?expense.getAmount():existingExpense.getAmount());
		existingExpense.setDate(expense.getDate()!=null?expense.getDate():existingExpense.getDate());
		return expenseRepo.save(existingExpense);
	}
	@Override
	public List<Expense> readByCategory(String category, Pageable page) {
		return expenseRepo.findByCategory(category, page).toList();
	}
	@Override
	public List<Expense> readByName(String keyword, Pageable page) {
		return expenseRepo.findByNameContaining(keyword,page).toList();
	}
	@Override
	public List<Expense> readByDate(Date startDate, Date endDate, Pageable page) {
		if(startDate==null){
			startDate=new Date(0);
		}
		if(endDate==null) {
			endDate=new Date(0);
		}
		return expenseRepo.findByDateBetween(startDate, endDate, page).toList();
	}
}
