package com.viewquiz.backend.app;

import java.io.File;

public class Booster {
//	C://FolderSetup/Files/
	private static final String DirectorySetupWindows = "C://FolderSetup";
	private static final String DirectorySetupUnix = "/home/FolderSetup";
	private static String DirectorySetup = null;
	private static final String SubDirectoryFiles = "/Files";

	public static void Boost() {
		System.out.println("setup file direcetory booster starts now");

		String propertyOSName = System.getProperty("os.name");
		String propertyOSVersion = System.getProperty("os.name");
		System.out.println(propertyOSName);
		System.out.println(propertyOSVersion);
		if (propertyOSName.startsWith("Windows")) {
			DirectorySetup = DirectorySetupWindows;
			Booster.createDirectorySetup(DirectorySetup);
			Booster.createDirectorySetup(DirectorySetup + SubDirectoryFiles);
		} else {
			System.out.println("systeme OS UNIX based");
		}
	}

	private static void createDirectorySetup(String path) {

		File theDir = new File(path);

		// if the directory does not exist, create it
		if (!theDir.exists()) {
			System.out.println("creating directory: " + path);
			boolean result = false;

			try {
				theDir.mkdir();
				result = true;
			} catch (SecurityException se) {
				// handle it
				System.out.println("SECURITY EXECPTION !!: " + se.getMessage());
			}
			if (result) {
				System.out.println("DIR created");
			}
		}
	}

	public static String GetFilesDirectory() {
		System.out.println("C://FolderSetup/Files/");
		System.out.println("is it the same");
		
		System.out.println(DirectorySetup + SubDirectoryFiles);
		return DirectorySetup + SubDirectoryFiles;
	}
}
