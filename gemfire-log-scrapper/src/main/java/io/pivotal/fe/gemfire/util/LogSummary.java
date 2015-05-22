package io.pivotal.fe.gemfire.util;

import java.util.List;
import java.util.Map;

/**
 * Simple Pojo for storing information obtained from parsing a log file
 * @author lshannon
 *
 */
public class LogSummary {
	
	private Map<String, List<String>> messages;
	private String name;
	
	public Map<String, List<String>> getMessages() {
		return messages;
	}
	public void setMessages(Map<String, List<String>> messages) {
		this.messages = messages;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	

}
