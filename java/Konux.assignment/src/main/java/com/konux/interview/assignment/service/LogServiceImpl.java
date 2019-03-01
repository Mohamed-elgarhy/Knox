package com.konux.interview.assignment.service;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

import org.springframework.stereotype.Service;

import com.konux.interview.assignment.dto.LogEntry;
import com.konux.interview.assignment.dto.LogEntryProto;
import com.konux.interview.assignment.interfaces.LogService;

@Service
public class LogServiceImpl implements LogService {

	@Override
	public void logServiceDetails(LogEntry logEntry) {
		LogEntryProto.LogEntry entry =  LogEntryProto.LogEntry.newBuilder()
		.setTimestamp(logEntry.getTimestamp())
		.setUserId(logEntry.getUserId())
		.setEvent(logEntry.getEvent()).build();
		
		byte [] logMessageAsByteArray = entry.toByteArray();
		
		Socket server;
		try {
			server = new Socket("localhost",7234);
			OutputStream out = server.getOutputStream();
			entry.writeTo(out);
			out.close();
			server.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		
	}



}
