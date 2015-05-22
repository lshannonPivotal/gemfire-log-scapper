package io.pivotal.fe.gemfire.util;

import io.pivotal.fe.gemfire.util.exception.InvalidFolderPathException;
import io.pivotal.fe.gemfire.util.exception.NoLogFilesInDirectoryException;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Give a folder returns a list of files that of *.log
 * 
 * @author lshannon
 *
 */
public class FolderReader {

	public static final String LOG = "log";

	/**
	 * Reads through a directory and if it find files with the .log extension it
	 * returns a list of File references point to those
	 * 
	 * @param path
	 * @return
	 * @throws InvalidFolderPathException
	 * @throws NoLogFilesInDirectoryException
	 */
	public static List<File> readFolder(String path) throws InvalidFolderPathException, NoLogFilesInDirectoryException {
		File directory = new File(path);
		if (directory == null || !directory.isDirectory()) {
			throw new InvalidFolderPathException(
					"Inital arguement to this application must be a fully qualified path to a folder contain log files");
		}
		List<File> logFiles = new ArrayList<File>();
		scanFolderForLogs(logFiles, path);
		if (logFiles.isEmpty()) {
			throw new NoLogFilesInDirectoryException(
					"There were no files of type " + FolderReader.LOG
							+ " the the supplied directory of " + path);
		}
		return logFiles;
	}

	/*
	 * Recursively scans the folder looking for files
	 */
	private static void scanFolderForLogs(List<File> logFiles, String path) {
		if (logFiles == null) {
			logFiles = new ArrayList<File>();
		}
		File root = new File(path);
		File[] list = root.listFiles();
		for (File f : list) {
			if (f.isDirectory()) {
				scanFolderForLogs(logFiles, f.getAbsolutePath());
			} else {
				int i = f.getName().lastIndexOf('.');
				if (i > 0) {
					if (f.getName().substring(i + 1).equals(LOG)) {
						logFiles.add(f);
					}
				}
			}
		}
	}

}
