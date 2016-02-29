//package com.viewquiz.backend.app.quiz.service.media;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import com.viewquiz.backend.app.quiz.persistence.model.media.Image;
//import com.viewquiz.backend.app.quiz.persitence.repository.media.ImageRepository;
//import com.viewquiz.backend.app.quiz.service.generic.AbstractService;
//
//@Service
//public class ImageService extends AbstractService<ImageRepository, Image, Integer> {
//	private ImageRepository imageRepository;
//
//	@Autowired
//	public ImageService(ImageRepository imageRepository) {
//		this.imageRepository = imageRepository;
//	}
//
//	@Override
//	protected ImageRepository getRepository() {
//		return imageRepository;
//	}
//	//
//	// public List<Image> getAllImage() {
//	//
//	// return imageRepository.getAll();
//	// }
//	//
//	 public List<Image> getImagesByNames(String nomImage) {
//	
//	 return imageRepository.getImagesByNomImage(nomImage);
//	 }
//	//
//	public Image saveImage(Image image) {
//
//		image = imageRepository.update(image);
//		return image;
//	 }
//	//
//	// public void deleteImage(int id) {
//	// Image image = imageRepository.find(id);
//	// imageRepository.delete(image);
//	// }
//
//	// public Image getImagesById(int idImage) {
//	// Image image = imageRepository.find(idImage);
//	// return image;
//	// }
//
//}
