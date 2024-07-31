package com.ets.expense_tracking_system.exceptions;

public class ResourceNotFoundException extends RuntimeException {
	private static final long serialVersionUID=1L;
	public ResourceNotFoundException(String message) {
		super(message);
	}
}
