package org.spring.exception;

import java.io.Serializable;

public class ErrorMessage implements Serializable {
	public ErrorMessage(){
		
	}
	public ErrorMessage(String code,String msg){
		this.code=code;
		this.msg=msg;
	}
	private String code;
	private String msg;
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	
}
