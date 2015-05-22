/**
 * 
 */
package io.pivotal.fe.gemfire.util.exception;

/**
 * Thrown if a directory is submitted that does not contain files with the extension 
 * specified in the FireReader
 * @author lshannon
 *
 */
public class NoLogFilesInDirectoryException extends Exception {

	private static final long serialVersionUID = -3243649181094417368L;
	
	public NoLogFilesInDirectoryException() {
	}

	public NoLogFilesInDirectoryException(String message) {
		super(message);
	}
	
}
