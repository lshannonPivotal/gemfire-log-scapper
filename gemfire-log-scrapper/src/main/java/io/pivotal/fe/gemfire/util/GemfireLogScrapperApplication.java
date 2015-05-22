package io.pivotal.fe.gemfire.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class GemfireLogScrapperApplication {

    public static void main(String[] args) {
        SpringApplication.run(GemfireLogScrapperApplication.class, args);
    }
    
    @Bean
    CommandLineRunner loadData() {
    	return new CommandLineRunner() {
			@Override
			public void run(String... arg0) throws Exception {
				BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
				System.out.println("Please input the folder containing the log files:");
				System.out.println("(press 'q' to quit at any time)");
				String folder = br.readLine();
				List<File> logFiles = FolderReader.readFolder(folder);
				List<LogSummary> logSummaries = new ArrayList<LogSummary>();
				for (File f : logFiles) {
					LogSummary summary = LogFileProcessor.processLogFile(f);
					if (summary != null) {
						logSummaries.add(summary);
					}
				}
				ExcelWritter.writeExcell(logSummaries);
				System.out.println("\n Process Complete. Press any key to quit.\n");
			    try {
					br.readLine();
				} catch (IOException e) {}
			}
    		
    	};
    }
}
