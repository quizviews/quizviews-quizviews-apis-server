package com.viewquiz.backend.app.quiz.persitence.dropbox;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

import com.dropbox.core.DbxClient;
import com.dropbox.core.DbxEntry;
import com.dropbox.core.DbxException;
import com.dropbox.core.DbxRequestConfig;
import com.dropbox.core.DbxWriteMode;

public class DropBoxFileHandler {
	private static final String TESTS_FOLDER_NAME = "Tests";
	private static final String QUESTIONS_FOLDER_NAME = "Questions";
	private static final String ANSWERS_FOLDER_NAME = "Answers";
	private static final String IMAGES_FOLDER_NAME = "Images";
	private static final String AUDIOS_FOLDER_NAME = "Audios";
	private static final String VIDEOS_FOLDER_NAME = "Videos";

	@SuppressWarnings("unused")
	private static final String FILES_FOLDER_NAME = "Files";

	private static final String ACCESS_TOKEN = "hJf7knZeXOwAAAAAAAAGboxf3s2yZOKzw1IWeEWx735kasVIE1qkuKbB31Hl_-QR";
	DbxRequestConfig config = new DbxRequestConfig("dropbox/java-tutorial", "en_US");
	DbxClient client = new DbxClient(config, ACCESS_TOKEN);

	private String pathToUploadedFile;
	private String folderToUploadedFile;
	private String subFolderToUploadedFile;

	public DropBoxFileHandler(MultipartFile fileToUpload, DirectoryType directoryType, FileType fileType) {

		this.fileToUpload = fileToUpload;
		switch (directoryType) {
		case TEST:
			folderToUploadedFile = ("/" + TESTS_FOLDER_NAME);
			break;

		case QUESTION:
			folderToUploadedFile = ("/" + TESTS_FOLDER_NAME + "/" + QUESTIONS_FOLDER_NAME + "/" + ANSWERS_FOLDER_NAME);
			break;
		case ANSWER:
			folderToUploadedFile = ("/" + TESTS_FOLDER_NAME + "/" + QUESTIONS_FOLDER_NAME + "/" + ANSWERS_FOLDER_NAME);
			break;

		default:
			System.out.println("unknowing Directory Type");
			break;
		}
		switch (fileType) {
		case IMAGE:
			subFolderToUploadedFile = ("/" + IMAGES_FOLDER_NAME);
			break;

		case AUDIO:
			subFolderToUploadedFile = ("/" + AUDIOS_FOLDER_NAME);
			break;
		case VIDEO:
			subFolderToUploadedFile = ("/" + VIDEOS_FOLDER_NAME);
			break;

		case PDF:
			break;

		default:
			System.out.println("unknowing file type");
			break;
		}

	}

	public enum FileType {
		IMAGE, PDF, AUDIO, VIDEO
	}

	public enum DirectoryType {
		ANSWER, QUESTION, TEST
	}

	public String nameFile;

	public File file;

	public String getUrl() {
		return "";
	}

	private MultipartFile fileToUpload;

	public String uploadFile() {
		pathToUploadedFile = folderToUploadedFile + subFolderToUploadedFile;
		String linkToFileuploaded = "";
		try {
			linkToFileuploaded = uploadMultipartFileToDropBox(fileToUpload, pathToUploadedFile);
		} catch (IllegalStateException | IOException | DbxException e) {
			linkToFileuploaded = "error";
		}
		return linkToFileuploaded;
	}

	private String uploadMultipartFileToDropBox(MultipartFile multipartFile, String pathToUploadedFile) throws FileNotFoundException, IllegalStateException, IOException, DbxException {
		String sharedUrl = "";
		DbxRequestConfig config = new DbxRequestConfig("dropbox/checkVersion", "en_US");
		DbxClient dbxClient = new DbxClient(config, ACCESS_TOKEN);
//		File fileConverted = multipartToFile(file);
		File fileConverted = convert(multipartFile);
		FileInputStream fis = new FileInputStream(fileConverted);

		try {
			DbxEntry.File uploadedFile = dbxClient.uploadFile(pathToUploadedFile + "/" + multipartFile.getOriginalFilename(), DbxWriteMode.force(), multipartFile.getSize(), fis);
			sharedUrl = dbxClient.createShareableUrl(pathToUploadedFile + "/" + multipartFile.getOriginalFilename());
			sharedUrl = sharedUrl .replaceFirst("www.dropbox.com", "dl.dropboxusercontent.com");

			System.out.println("Uploaded: " + uploadedFile.toString() + " URL " + sharedUrl);
		} finally {
			fis.close();
		}
		return sharedUrl;
	}

	// http://stackoverflow.com/questions/24339990/how-to-convert-a-multipart-file-to-file
	private File multipartToFile(MultipartFile multipart) throws IllegalStateException, IOException {
		File convFile = new File(multipart.getOriginalFilename());
		multipart.transferTo(convFile);
		return convFile;
	}

	public File convert(MultipartFile file) throws IOException {
		File convFile = new File(file.getOriginalFilename());
//		convFile.createNewFile();
		FileOutputStream fos = new FileOutputStream(convFile);
		fos.write(file.getBytes());
		fos.close();
		return convFile;
	}
	// public boolean saveFileInDropBox(MultipartFile file) {
	// File theFile = new File("C://FolderSetup//Files//Test_ImageCovers//" +
	// file.getOriginalFilename());
	// byte[] bytes;
	// try
	//
	// {
	// // bytes = file.getBytes();
	// BufferedOutputStream stream = new BufferedOutputStream(new
	// FileOutputStream(theFile));
	// stream.write(bytes);
	// stream.close();
	// boolean createNewFile = theFile.createNewFile();
	// } catch (
	//
	// IOException e)
	//
	// {
	// e.printStackTrace();
	// }
	// }

}
