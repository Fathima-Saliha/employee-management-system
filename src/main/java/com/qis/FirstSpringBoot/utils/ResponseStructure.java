package com.qis.FirstSpringBoot.utils;

public class ResponseStructure <T>{ //generic class generate cheyyan <>
	
	private int status;
	private String message;
	private T data;
	
	
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
	
	
	public ResponseStructure() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public ResponseStructure(int status, String message, T data) {
		super();
		this.status = status;
		this.message = message;
		this.data = data;
	}
	
	

}
