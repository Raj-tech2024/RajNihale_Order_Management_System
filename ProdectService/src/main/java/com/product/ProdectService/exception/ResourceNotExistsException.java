package com.product.ProdectService.exception;

public class ResourceNotExistsException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ResourceNotExistsException(String msg) {
		super(msg);
	}
}
