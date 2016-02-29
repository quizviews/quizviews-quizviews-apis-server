//package com.viewquiz.backend.app.quiz.web.controller.media;
//
//import java.net.URI; 
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpHeaders;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
//
//import com.viewquiz.backend.app.quiz.persistence.model.media.Image;
//import com.viewquiz.backend.app.quiz.service.media.ImageService;
//
//@RestController
//public class ImageController {
//
//	@Autowired
//	private ImageService imageService;
//
//	
////	http://localhost:8080/images
//	@RequestMapping("/images")
//	public ResponseEntity<List<Image>>  listAll(@RequestParam(value = "name", required = false) String esm) {
//		
//		List<Image> images = null;
//		if (esm== null) {
//			images = imageService.list();
//		}else {
//			images = imageService.getImagesByNames(esm);
//		}
//		return new ResponseEntity<>(images, HttpStatus.OK);
//
//	}
//	
//	
//	
//	
//	
////	http://localhost:8080/images/Ala
//	@RequestMapping("/images/{name}")
//	public ResponseEntity<List<Image>>  listImagesByName(@PathVariable String name) {
//		List<Image> images = imageService.getImagesByNames(name);
//		return new ResponseEntity<>(images, HttpStatus.OK);
//	}
//	
//	
//	
//	
//////	http://localhost:8080/images/1
////	@RequestMapping("/images/{idImage}")
////	public ResponseEntity<Image>  listImagesById(@PathVariable int idImage) {
////		Image image = imageService.getImagesById(idImage);
////		return new ResponseEntity<>(image, HttpStatus.OK);
////	}
////	
//	
//	
// 
//	
//	
//	
//	
//	//HttpClient HeadRequest should add Content-Type:application/json
//	//the body should have a Question json parsed
//	@RequestMapping(value = "/images", method = RequestMethod.POST)
//	public ResponseEntity<?> createImage(@RequestBody Image image) {
//		image = imageService.saveImage(image);
//		HttpHeaders responseHeaders = new HttpHeaders();
//		URI newPollUri = ServletUriComponentsBuilder
//				.fromCurrentRequest()
//				.path("/{id}")
//				.buildAndExpand(image.getIdImage())
//				.toUri();
//				responseHeaders.setLocation(newPollUri);
//				return new ResponseEntity<>(null, responseHeaders, HttpStatus.CREATED);
//	}
//	
//	
//	
//	
//	
//	
//	//HttpClient HeadRequest should add Content-Type:application/json
//	//the body should have a Question json parsed
//	@RequestMapping(value = "/images/{id}", method = RequestMethod.PUT)
//	public ResponseEntity<?> updateimage(@RequestBody Image image,@PathVariable  int id) {
//		imageService.create(image);
//		return new ResponseEntity<>(null, HttpStatus.OK);
//	}
//	
//	
//	
//	
//	
//	
//
//	
//	
//
//	
//	
//	
//	@RequestMapping(value = "/images/{id}", method = RequestMethod.DELETE)
//	public ResponseEntity<?> deleteQuestion(@PathVariable  int id) {
//		imageService.delete(id);
//		return new ResponseEntity<>(null, HttpStatus.OK);
//	}
//}
