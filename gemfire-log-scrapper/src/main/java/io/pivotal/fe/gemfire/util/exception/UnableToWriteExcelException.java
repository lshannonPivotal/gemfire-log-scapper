/**
 * 
 */
package io.pivotal.fe.gemfire.util.exception;

/**
 * Thrown if the excel could not be written
 * @author lshannon
 *
 */
public class UnableToWriteExcelException extends Exception {

	private static final long serialVersionUID = 5553019229262643733L;
	
	public UnableToWriteExcelException() {
		
	}
	
	public UnableToWriteExcelException(String message) {
		super(message);
	}

}
