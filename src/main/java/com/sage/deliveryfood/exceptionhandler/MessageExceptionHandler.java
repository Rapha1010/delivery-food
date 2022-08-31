package com.sage.deliveryfood.exceptionhandler;

import java.time.LocalDateTime;

public class MessageExceptionHandler {
	
	private LocalDateTime dataTime;
	private Integer status;
	private String message;
	
	public MessageExceptionHandler() {
	}
	
	public MessageExceptionHandler(LocalDateTime dataTime, Integer status, String message) {
		this.dataTime = dataTime;
		this.status = status;
		this.message = message;
	}
	
	public LocalDateTime getDataTime() {
		return dataTime;
	}
	public void setDataTime(LocalDateTime dataTime) {
		this.dataTime = dataTime;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}

}
