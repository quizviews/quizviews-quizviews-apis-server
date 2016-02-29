package com.viewquiz.backend.app.quiz.persitence.repository.media;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.viewquiz.backend.app.quiz.persistence.model.media.Image;
import com.viewquiz.backend.app.quiz.persitence.repository.generic.AbstractRepository;

@Repository
// public class ImageRepository extends AbstractRepository<Image, Integer> {
public class ImageRepository {

	@PersistenceContext
	private EntityManager entityManager;
	private ImageJpaRepository imageJpaRepository;

	@Autowired
	public ImageRepository(ImageJpaRepository imageJpaRepository) {
		this.imageJpaRepository = imageJpaRepository;
	}

	// @Override
	// protected JpaRepository<Image, Integer> getJpaRepository() {
	// return this.imageJpaRepository;
	// }

	public Image create(Image image) {
		// entityManager.persist(image);
		// entityManager.flush();
		imageJpaRepository.saveAndFlush(image);
		return image;
	}

	public Image read(int idImage) {
		// entityManager.persist(image);
		// entityManager.flush();
		return imageJpaRepository.findOne(idImage);

	}

	public List<Image> list(int idImage) {
		// entityManager.persist(image);
		// entityManager.flush();
		return imageJpaRepository.findAll();

	}

	public Image update(Image image) {
		// image = entityManager.merge(image);
		// entityManager.flush();
		imageJpaRepository.saveAndFlush(image);
		return image;
	}

	public void delete(int idImage) {
		// image = entityManager.merge(image);
		// entityManager.flush();
		imageJpaRepository.delete(idImage);
	}

	public List<Image> getImagesByNameImage(String nameImage) {
		Query query = entityManager.createQuery("select i from Image i where i.nameImage like :name").setParameter("name", nameImage + "%");
		@SuppressWarnings("unchecked")
		List<Image> imageList = query.getResultList();
		return imageList;
	}

	public List<Image> getImagesByPixelBetweenWidthAndHeight(int widthImage, int heightImage) {
		Query query = entityManager.createQuery("select i from Image i where i.widthImage >= :width and i.heightImage >= :height ").setParameter("width", widthImage).setParameter("height", heightImage);
		@SuppressWarnings("unchecked")
		List<Image> imageList = query.getResultList();
		return imageList;
	}

}
