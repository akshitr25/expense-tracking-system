package com.ets.expense_tracking_system.entity;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class UserModel {
	@NotBlank(message="Name should not be empty.")
	private String name;
	@NotNull(message="Email should not be empty.")
	@Email(message="Please enter a valid email")
	private String email;
	@NotBlank(message="Password should not be empty.")
	@Size(min=5,message="Password should be atleast 5 characters")
	private String password;
	private Long age=0L;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Long getAge() {
		return age;
	}
	public void setAge(Long age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "UserModel [name=" + name + ", email=" + email + ", password=" + password + ", age=" + age + "]";
	}
}
