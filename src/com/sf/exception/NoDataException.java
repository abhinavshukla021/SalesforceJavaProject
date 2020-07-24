package com.sf.exception;

public class NoDataException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8717741814758690496L;

	public NoDataException() {
		super("No data found");
	}
}
