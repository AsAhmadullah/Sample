package com.helper;

public class File_Reader_Manager {
	
	// Private Constructor
		private File_Reader_Manager() {
			// To restrict object creation in another class
		}
		
		// Static Method
		public static File_Reader_Manager getInstanceFRM() {
			File_Reader_Manager frm = new File_Reader_Manager();
			return frm;
		}
		
		// Non-Static Method
		public Automation_Configuration_Reader getInstanceACR() throws Throwable {
			Automation_Configuration_Reader cr = new Automation_Configuration_Reader();
			return cr;
		}

}
