package org.spring.exception;

import lombok.Getter;

@Getter
public class NotFoundException extends RuntimeException{
	/**
	 * 
	 */
	private static final long serialVersionUID = -3795590949434592786L;
	private String errcode;
	private String errorMsg;
	public NotFoundException(String errorMsg) {
		super(errorMsg);
		this.errorMsg=errorMsg;
	}
	
	public NotFoundException(String errorCode,String errorMsg) {
		super(errorMsg);
		this.errorMsg=errorMsg;
		this.errcode=errorCode;
	}
	
	
	
}
