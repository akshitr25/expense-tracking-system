package com.ets.expense_tracking_system.service;

import com.ets.expense_tracking_system.entity.User;

import com.ets.expense_tracking_system.entity.UserModel;

public interface UserService {
	User createUser(UserModel user);
}
