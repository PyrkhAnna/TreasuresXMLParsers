package com.epam.ht4.service.exception;

public class ServiceExeption extends Exception{
	private static final long serialVersionUID = 1L;

	public ServiceExeption() {
	}

	public ServiceExeption(String message, Exception e) {
		super(message, e);
	}

	public ServiceExeption(String message) {
		super(message);
	}

	public ServiceExeption(Exception e) {
		super(e);
	}
}
