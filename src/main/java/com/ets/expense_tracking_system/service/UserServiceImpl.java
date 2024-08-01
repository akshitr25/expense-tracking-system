package com.ets.expense_tracking_system.service;

import com.ets.expense_tracking_system.entity.User;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ets.expense_tracking_system.entity.UserModel;
import com.ets.expense_tracking_system.exceptions.ItemAlreadyExistsException;
import com.ets.expense_tracking_system.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	UserRepository userRepository;
	@Override
	public User createUser(UserModel user) {
		if(userRepository.existsByEmail(user.getEmail()))
		{
			throw new ItemAlreadyExistsException("User is already registered with email: "+user.getEmail());
		}
		User newUser=new User();
		BeanUtils.copyProperties(user, newUser);
		return userRepository.save(newUser);
	}

}
