package com.viewquiz.backend.app.quiz.web.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.thoughtworks.xstream.io.path.Path;
import com.viewquiz.backend.app.quiz.persistence.model.Test;
import com.viewquiz.backend.app.quiz.persitence.dropbox.DropBoxFileHandler;
import com.viewquiz.backend.app.quiz.persitence.dropbox.DropBoxFileHandler.DirectoryType;
import com.viewquiz.backend.app.quiz.persitence.dropbox.DropBoxFileHandler.FileType;
import com.viewquiz.backend.app.quiz.service.TestService;
import com.viewquiz.backend.app.quiz.web.controller.exception.ResourceNotFoundException;
import com.viewquiz.backend.app.quiz.web.controller.exception.TestNotFoundException;

@RequestMapping("api/tests")
@RestController
public class TestController {

	public TestService testService;

	@Autowired
	public TestController(TestService testService) {
		this.testService = testService;
	}

	@ResponseStatus(HttpStatus.CREATED)
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<?> create(@Valid @RequestBody Test test) {
		test = testService.create(test);
		HttpHeaders responseHeaders = new HttpHeaders();
		URI newTestUri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(test.getIdTest()).toUri();
		responseHeaders.setLocation(newTestUri);
		return new ResponseEntity<>(null, responseHeaders, HttpStatus.CREATED);

	}

	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(value = "/{idTest}", method = RequestMethod.GET)
	public Test read(@PathVariable int idTest) {
		verifyTestExist(idTest);
		Test test = testService.read(idTest);
		return test;
	}

	// @RequestMapping(method = RequestMethod.GET, produces =
	// "application/json", params = { "page", "size" }this does not work
	@RequestMapping(method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<Collection<Test>> list(@RequestParam(value = "page", defaultValue = "0", required = false) final int page, @RequestParam(value = "size", defaultValue = "500", required = false) final int size) {
		Pageable pageRequest = new PageRequest(page, size);
		List<Test> allTests = testService.list(pageRequest);
		return new ResponseEntity<>(allTests, HttpStatus.OK);
	}

	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(value = "/{idTest}", method = RequestMethod.PUT)
	public Test update(@PathVariable int idTest, @RequestBody Test test) {
		verifyTestExist(idTest);
		Test testToUpdate = testService.read(idTest);
		testToUpdate = testService.update(testToUpdate, test);
		return testToUpdate;
	}

	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(value = "/{idTest}", method = RequestMethod.DELETE)
	public void delete(@PathVariable int idTest) {
		verifyTestExist(idTest);
		testService.delete(idTest);
	}

	public void verifyTestExist(int idTest) {
		Test test = testService.read(idTest);
		if (test == null) {
			// throw new TestNotFoundException(idTest);
			throw new ResourceNotFoundException(idTest);
		}
	}

	@ExceptionHandler(TestNotFoundException.class)
	public void handleTestNotFound(TestNotFoundException exception, HttpServletResponse response) throws IOException {
		response.sendError(HttpStatus.NOT_FOUND.value(), exception.getMessage());
	}

	//
	// @RequestMapping(value = "/upload", method = RequestMethod.POST)
	// public String handleFileUpload(@RequestParam("name") String name,
	// @RequestParam("file") MultipartFile file) {
	// if (!file.isEmpty()) {
	// File theFile=new File("C://FolderSetup//" + file.getOriginalFilename());
	// try {
	// byte[] bytes = file.getBytes();
	// BufferedOutputStream stream = new BufferedOutputStream(new
	// FileOutputStream(theFile));
	// stream.write(bytes);
	// stream.close();
	// boolean createNewFile = theFile.createNewFile();
	//
	//
	//// File file0 = new File("C://FolderSetup//" + file.getName());
	//// boolean createNewFile = file0 .createNewFile();
	//// System.out.println("Go to the location: " + file0.toString() + " on
	// your computer and verify that the image has been stored.");
	//
	// return "You successfully uploaded " + name + "!";
	// } catch (Exception e) {
	// return "You failed to upload " + name + " => " + e.getMessage();
	// }
	// } else {
	// return "You failed to upload " + name + " because the file was empty.";
	// }
	// }
	// @RequestMapping(value = "/upload", method = RequestMethod.POST)
	//// public String handleFileUpload(@RequestParam(value = "file", required =
	// true) MultipartFile file, @RequestParam(value = "person", required =
	// true) String person, @RequestParam(value = "date", required = true)
	// @DateTimeFormat(pattern = "yyyy-MM-dd") Date date) {
	// public ResponseEntity<?> handleFileUpload(@RequestParam(value = "file",
	// required = false) MultipartFile file) {
	// System.out.println(file.getOriginalFilename());
	//
	// File theFile = new File("C://FolderSetup//Files//Test_ImageCovers//" +
	// file.getOriginalFilename());
	// byte[] bytes;
	// try {
	// bytes = file.getBytes();
	// BufferedOutputStream stream = new BufferedOutputStream(new
	// FileOutputStream(theFile));
	// stream.write(bytes);
	// stream.close();
	// boolean createNewFile = theFile.createNewFile();
	// } catch (IOException e) {
	// e.printStackTrace();
	// }
	// HttpHeaders responseHeaders = new HttpHeaders();
	//// URI newTestUri =
	// ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(file.getOriginalFilename()).toUri();
	// URI newTestUri =
	// ServletUriComponentsBuilder.fromCurrentRequest().replacePath("/files/Test_ImageCovers").path("/{id}").buildAndExpand(file.getOriginalFilename()).toUri();
	// responseHeaders.setLocation(newTestUri);
	//// URI newTestUri =
	// ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(file.getOriginalFilename()).toUri();
	//// responseHeaders.setLocation(newTestUri);
	// return new ResponseEntity<>(null, responseHeaders, HttpStatus.CREATED);
	//
	// }

	@RequestMapping(value = "/upload", method = RequestMethod.POST)
	// public String handleFileUpload(@RequestParam(value = "file", required =
	// true) MultipartFile file, @RequestParam(value = "person", required =
	// true) String person, @RequestParam(value = "date", required = true)
	// @DateTimeFormat(pattern = "yyyy-MM-dd") Date date) {
	public ResponseEntity<?> handleFileUpload(@RequestParam(value = "file", required = false) MultipartFile file) throws URISyntaxException {
		System.out.println(file.getOriginalFilename());
		DropBoxFileHandler dropBoxFileHandler = new DropBoxFileHandler(file, DirectoryType.TEST, FileType.IMAGE);
		String linkToFile = dropBoxFileHandler.uploadFile();
		// byte[] bytes;
		// try {
		// bytes = file.getBytes();
		// BufferedOutputStream stream = new BufferedOutputStream(new
		// FileOutputStream(theFile));
		// stream.write(bytes);
		// stream.close();
		// boolean createNewFile = theFile.createNewFile();
		// } catch (IOException e) {
		// e.printStackTrace();
		// }
		HttpHeaders responseHeaders = new HttpHeaders();
		// URI newTestUri =
		// ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(file.getOriginalFilename()).toUri();
		// URI newTestUri =
		// ServletUriComponentsBuilder.fromCurrentRequest().replacePath("/files/Test_ImageCovers").path("/{id}").buildAndExpand(file.getOriginalFilename()).toUri();
		URI newTestUri = new URI(linkToFile);
		responseHeaders.setLocation(newTestUri);
		// URI newTestUri =
		// ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(file.getOriginalFilename()).toUri();
		// responseHeaders.setLocation(newTestUri);
		return new ResponseEntity<>(null, responseHeaders, HttpStatus.CREATED);

	}
}
