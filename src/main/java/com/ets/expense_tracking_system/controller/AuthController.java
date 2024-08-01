package com.ets.expense_tracking_system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ets.expense_tracking_system.entity.User;
import com.ets.expense_tracking_system.entity.UserModel;
import com.ets.expense_tracking_system.service.UserService;

import jakarta.validation.Valid;

@RestController
public class AuthController {
	@Autowired
	private UserService userService;
	@PostMapping("/login")
	public ResponseEntity<String> login(){
		return new ResponseEntity<String>("User is logged in",HttpStatus.OK);
	}
	@PostMapping("/register")
	public ResponseEntity<User> save(@Valid @RequestBody UserModel user){
		return new ResponseEntity<User>(userService.createUser(user),HttpStatus.CREATED);
	}
}
