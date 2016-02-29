package com.viewquiz.backend.app;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDateTime;

import com.dropbox.core.DbxClient;
import com.dropbox.core.DbxEntry;
import com.dropbox.core.DbxException;
import com.dropbox.core.DbxRequestConfig;
import com.dropbox.core.DbxWriteMode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.viewquiz.backend.app.quiz.s3.S3_VersionDirectory;

//http://javapapers.com/java/dropbox-java-api-tutorial/
/**
 * 
 * @author Houssem <br>
 *         this should cxreate the directories structure!
 * 
 *         <pre>
 *  
 *         ---QuizView---Tests---Questions-------Answers----------------
 * 	       ----------------------Images(Tests)---Images(Questions)------Images(Answers)
 * 	       ----------------------Audios(Tests)---Audios(Questions)------Audios(Answers)
 * 	       ----------------------Videos(Tests)---Videos(Questions)------Videos(Answers)
 * 	       ----------------------Files(Tests)----Files(Questions)-------Files(Answers)
 *         </pre>
 */
public class DropBoxBooster {
	private static final String ACCESS_TOKEN = "hJf7knZeXOwAAAAAAAAGboxf3s2yZOKzw1IWeEWx735kasVIE1qkuKbB31Hl_-QR";
	private final String versionDirectoryFileName = "VersionDirectory.txt";

	private static final String TESTS_FOLDER_NAME = "Tests";
	private static final String QUESTIONS_FOLDER_NAME = "Questions";
	private static final String ANSWERS_FOLDER_NAME = "Answers";
	private static final String VIDEOS_FOLDER_NAME = "Videos";
	private static final String AUDIOS_FOLDER_NAME = "Audios";
	@SuppressWarnings("unused")
	private static final String FILES_FOLDER_NAME = "Files";
	private static final String IMAGES_FOLDER_NAME = "Images";

	public void checkDirectoryVersion() {
		try {
			DbxEntry.File versionDirectoryFileFromDropbox = downloadFromDropbox(versionDirectoryFileName);
			if (null == versionDirectoryFileFromDropbox) {
				installVersionDirectoryFirstTime();
			} else {
//				S3_VersionDirectory parsedLocalVersionDirectory = parseVersionDirectoryFile(new File(versionDirectoryFileName));
				// VersionDirectory newVersionDirectory=
				// parseVersionDirectoryFile(new );
//				if (parsedLocalVersionDirectory.getVersion() < 0) {
//					System.out.println("we need upgrade");
//				}
			}
		} catch (DbxException | IOException e) {
			e.printStackTrace();
		}
	}

	private void installVersionDirectoryFirstTime() throws DbxException, IOException {
		createVersionDirectoryFileToDropBox();
		DbxRequestConfig config = new DbxRequestConfig("dropbox/downloadFromDropbox", "en_US");
		DbxClient dbxClient = new DbxClient(config, ACCESS_TOKEN);
		dbxClient.createFolder("/" + TESTS_FOLDER_NAME);
		dbxClient.createFolder("/" + TESTS_FOLDER_NAME + "/" + IMAGES_FOLDER_NAME);
		dbxClient.createFolder("/" + TESTS_FOLDER_NAME + "/" + QUESTIONS_FOLDER_NAME);
		dbxClient.createFolder("/" + TESTS_FOLDER_NAME + "/" + QUESTIONS_FOLDER_NAME + "/" + IMAGES_FOLDER_NAME);
		dbxClient.createFolder("/" + TESTS_FOLDER_NAME + "/" + QUESTIONS_FOLDER_NAME + "/" + AUDIOS_FOLDER_NAME);
		dbxClient.createFolder("/" + TESTS_FOLDER_NAME + "/" + QUESTIONS_FOLDER_NAME + "/" + VIDEOS_FOLDER_NAME);
		dbxClient.createFolder("/" + TESTS_FOLDER_NAME + "/" + QUESTIONS_FOLDER_NAME + "/" + ANSWERS_FOLDER_NAME);
		dbxClient.createFolder("/" + TESTS_FOLDER_NAME + "/" + QUESTIONS_FOLDER_NAME + "/" + ANSWERS_FOLDER_NAME + "/" + IMAGES_FOLDER_NAME);
		dbxClient.createFolder("/" + TESTS_FOLDER_NAME + "/" + QUESTIONS_FOLDER_NAME + "/" + ANSWERS_FOLDER_NAME + "/" + AUDIOS_FOLDER_NAME);
		dbxClient.createFolder("/" + TESTS_FOLDER_NAME + "/" + QUESTIONS_FOLDER_NAME + "/" + ANSWERS_FOLDER_NAME + "/" + VIDEOS_FOLDER_NAME);

	}

	private DbxEntry.File downloadFromDropbox(String fileName) throws DbxException, IOException {
		DbxRequestConfig config = new DbxRequestConfig("dropbox/downloadFromDropbox", "en_US");
		DbxClient dbxClient = new DbxClient(config, ACCESS_TOKEN);
		DbxEntry.File downloadedFile = null;
		FileOutputStream outputStream = new FileOutputStream(fileName);
		try {
			downloadedFile = dbxClient.getFile("/" + fileName, null, outputStream);
			if (downloadedFile != null) {
				Log.D("Metadata: " + downloadedFile.toString());
			}

		} finally {
			outputStream.close();
		}

		return downloadedFile;
	}

	private S3_VersionDirectory parseVersionDirectoryFile(File file) {

		return null;
	}

	private void createVersionDirectoryFileToDropBox() throws DbxException, IOException {
		DbxRequestConfig config = new DbxRequestConfig("dropbox/checkVersion", "en_US");
		DbxClient dbxClient = new DbxClient(config, ACCESS_TOKEN);
		
		File inputFile = new File(versionDirectoryFileName);
		ObjectMapper mapper = new ObjectMapper();
		S3_VersionDirectory myBean = new S3_VersionDirectory();
		myBean.setDate(LocalDateTime.now());
		myBean.setVersion(1);
		myBean.setS3(new S3_VersionDirectory.S3("Dropbox","ViewQuiz"));

		mapper.writeValue(inputFile, myBean);

		FileInputStream fis = new FileInputStream(inputFile);

		try {
			DbxEntry.File uploadedFile = dbxClient.uploadFile("/" + versionDirectoryFileName, DbxWriteMode.force(), inputFile.length(), fis);
			String sharedUrl = dbxClient.createShareableUrl("/" + versionDirectoryFileName);
			System.out.println("Uploaded: " + uploadedFile.toString() + " URL " + sharedUrl);
		} finally {
			fis.close();
		}

	}
}
