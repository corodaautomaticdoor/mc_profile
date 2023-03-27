package com.coroda.exception;

import java.util.Date;

public class CustomizeErrorDetails {

	private Date timeStamp;
	private String message;

	public CustomizeErrorDetails(Date timeStamp, String message) {
		this.timeStamp = timeStamp;
		this.message = message;
	}

	public Date getTimeStamp() {
		return timeStamp;
	}

	public String getMessage() {
		return message;
	}
}
