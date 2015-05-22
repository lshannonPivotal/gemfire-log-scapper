package io.pivotal.fe.gemfire.util;

import java.io.File;

public class LogFileProcessor {
	
	public static LogSummary processLogFile(File f) {
		LogSummary summary = new LogSummary();
		int index = f.getName().indexOf(".");
		String fileName = f.getName().substring(0, index);
		summary.setName(fileName);
		return summary;
	}

}
