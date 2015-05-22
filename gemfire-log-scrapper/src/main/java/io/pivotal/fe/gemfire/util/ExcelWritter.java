package io.pivotal.fe.gemfire.util;

import io.pivotal.fe.gemfire.util.exception.UnableToWriteExcelException;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelWritter {
	
	public static void writeExcell(List<LogSummary> logSummaries) throws UnableToWriteExcelException {
		//Blank workbook
        XSSFWorkbook workbook = new XSSFWorkbook();
         
		for (LogSummary summary : logSummaries) {
			System.out.println("Will create a sheet for " + summary.getName());
			//Create a blank sheet
	        @SuppressWarnings("unused")
			XSSFSheet sheet = workbook.createSheet(summary.getName());
		}
		
		 try
	        {
	            //Write the workbook in file system
			 	DateFormat df2 = new SimpleDateFormat("MM-dd-yyyy-HH-mm");
			 	String formattedDate = df2.format(new Date().getTime());
	            FileOutputStream out = new FileOutputStream(new File("log_summary" + formattedDate + ".xlsx"));
	            workbook.write(out);
	            out.close();
	        }
	        catch (Exception e)
	        {
	           throw new UnableToWriteExcelException(e.getMessage());
	        }
		 finally {
			 try {
				workbook.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 }
	}

}
