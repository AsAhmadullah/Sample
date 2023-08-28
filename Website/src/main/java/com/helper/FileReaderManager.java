package com.helper;

public class FileReaderManager {

	// Private Constructor
	private FileReaderManager() {
			// To restrict object creation in another class
		}

	// Static Method
	public static FileReaderManager getInstanceFRM() {
		FileReaderManager frm = new FileReaderManager();
		return frm;
	}

	// Non-Static Method
	public ConfigurationReader getInstanceCR() throws Throwable {
		ConfigurationReader cr = new ConfigurationReader();
		return cr;
	}

}
