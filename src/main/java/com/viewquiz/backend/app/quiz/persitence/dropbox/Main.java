//package com.viewquiz.backend.app.quiz.persitence.dropbox;
//
//import java.io.File;
//import java.io.FileInputStream;
//import java.io.FileNotFoundException;
//import java.io.IOException;
//import java.io.InputStream;
//import java.util.ArrayList;
//
//import com.dropbox.core.DbxClient;
//import com.dropbox.core.DbxEntry;
//import com.dropbox.core.DbxException;
//import com.dropbox.core.DbxRequestConfig;
//import com.dropbox.core.DbxWriteMode;
//
//public class Main {
//	private static final String ACCESS_TOKEN = "hJf7knZeXOwAAAAAAAAGboxf3s2yZOKzw1IWeEWx735kasVIE1qkuKbB31Hl_-QR";
//
//	public static void main(String[] args) throws DbxException, IOException {
//		// final String DROP_BOX_APP_KEY = "vegc7wrcpt9pebo";
//		// final String DROP_BOX_APP_SECRET = "sg75ky5udufbhnb";
//		//
//		// String rootDir = "C:\\Users\\Downloads\\";
//		String rootDir = "C:\\Users\\Houssem\\Downloads\\";
//
//		// Create Dropbox client
//		DbxRequestConfig config = new DbxRequestConfig("dropbox/java-tutorial", "en_US");
//		DbxClient client = new DbxClient(config, ACCESS_TOKEN);
//
//		// InputStream in = new FileInputStream(rootDir + "Koala.jpg");
//
//		File inputFile = new File(rootDir + "Tulips.jpg");
//		FileInputStream inputStream = new FileInputStream(inputFile);
//
//		try {
//			DbxEntry.File uploadedFile = client.uploadFile("/Tulips.jpg", DbxWriteMode.add(), inputFile.length(), inputStream);
//			System.out.println("Uploaded: " + uploadedFile.toString());
//		} finally {
//			inputStream.close();
//		}
//
//		String appDropboxUrl = client.createShareableUrl("/Tulips.jpg");
//		System.out.println(appDropboxUrl);
//		String imagePathUrl = appDropboxUrl.replaceFirst("www.dropbox.com", "dl.dropboxusercontent.com");
//		System.out.println(imagePathUrl );
//	}
//
//}