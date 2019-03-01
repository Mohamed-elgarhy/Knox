package com.konux.interview.assignment.dto;

public class LogEntry {

	private String event;
	private Long userId;
	private Long timestamp;
	
	
	
	public String getEvent() {
		return event;
	}
	public void setEvent(String event) {
		this.event = event;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	
	public Long getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Long timestamp) {
		this.timestamp = timestamp;
	}
	
	

	
	@Override
	public String toString() {
		return "LogEntry [event=" + event + ", userId=" + userId + ", timeStamp=" + timestamp + "]";
	}
	
	
}
