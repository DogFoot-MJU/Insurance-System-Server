package com.dogfoot.insurancesystemserver.domain.user.exception;

public class NotLoginException extends IllegalArgumentException{
	
	public NotLoginException(UserExceptionMessage m) {
		super(m.getMessage());
	}
}
