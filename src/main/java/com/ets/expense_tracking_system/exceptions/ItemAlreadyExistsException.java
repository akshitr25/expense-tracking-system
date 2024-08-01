package com.ets.expense_tracking_system.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.CONFLICT)
public class ItemAlreadyExistsException extends RuntimeException {
	private static final Long serialVersionUID=1L;
	public ItemAlreadyExistsException(String message)
	{
		super(message);
	}
}
