package io.pivotal.fe.gemfire.util.exception;

/**
 * To be thrown if inital arguement is not a folder
 * @author lshannon
 *
 */
public class InvalidFolderPathException extends Exception {

	private static final long serialVersionUID = -5465283864294840635L;

	public InvalidFolderPathException() {
		
	}
	
	public InvalidFolderPathException(String message) {
		super(message);
	}

}
