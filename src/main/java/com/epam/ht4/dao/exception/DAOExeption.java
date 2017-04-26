package com.epam.ht4.dao.exception;

public class DAOExeption extends Exception{
	private static final long serialVersionUID = 1L;

	public DAOExeption() {
	}

	public DAOExeption(String message, Exception e) {
		super(message, e);
	}

	public DAOExeption(String message) {
		super(message);
	}

	public DAOExeption(Exception e) {
		super(e);
	}
}
