package com.viewquiz.backend.app.quiz.persitence.repository;

//import javax.validation.constraints.AssertTrue; 

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.web.WebAppConfiguration;

import com.viewquiz.backend.app.ViewQuizBackEndApplication;
import com.viewquiz.backend.app.quiz.persistence.model.Question;
import com.viewquiz.backend.app.quiz.persistence.model.media.Image;
import com.viewquiz.backend.app.quiz.persitence.repository.media.ImageJpaRepository;
import com.viewquiz.backend.app.quiz.persitence.repository.media.ImageRepository;

import junit.framework.Assert;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = ViewQuizBackEndApplication.class)
@WebAppConfiguration
public class ImagePersistenceTests {

	@Autowired
	private ImageJpaRepository imageJpaRepository;
	@Autowired
	private ImageRepository imageRepository;

	@Test
	public void testGetImagesByName() {
		List<Image> imageByNameImage = imageRepository.getImagesByNameImage("");
		// System.out.println(imageByNameImage);
		assertTrue("list not empty " + imageByNameImage.toString(), imageByNameImage.size() > 0);
	}

	@Test
	public void testGetImageByNameJPA() {
		List<Image> imagesByNameImage = imageJpaRepository.getImagesByNameImageLike("A%");
		// System.out.println(imagesByNameImage);
		assertTrue("list not empty " + imagesByNameImage.toString(), imagesByNameImage.size() > 0);
	}

	@Test
	public void testGetImageByNameImageNot() {
		List<Image> imageByNameImages = imageJpaRepository.getImageByNameImageNot("Ala");
		// System.out.println("404 "+imageByNameImage);
		assertFalse("not found 404", imageByNameImages == null);
	}

	@Test
	public void testGetImageByNameImageContaining() {
		List<Image> listImageNameContainigWord = imageJpaRepository.getImagesByNameImageContaining("la");
		// System.out.println("find this: "+listImageNameContainigWord);
		assertFalse("exist ala", listImageNameContainigWord == null);
	}

	@Test
	public void testfindImagesByWidthImageGreaterThanEqualAndHeightImageGreaterThanEqual() {
		List<Image> listImageNamebyPixel = imageJpaRepository.findImagesByWidthImageGreaterThanEqualAndHeightImageGreaterThanEqual(100, 100);
		// System.out.println("[100px,100px]find this: "+listImageNamebyPixel);
		assertFalse("exist ala", listImageNamebyPixel == null);
	}

	@Test
	public void testfindImagesByWidthImageGreaterThanEqualAndHeightImageGreaterThanEqual_JPQL() {
		List<Image> listImageNamebyPixel = imageRepository.getImagesByPixelBetweenWidthAndHeight(200, 200);
		// System.out.println("[200px,200px]find this: "+listImageNamebyPixel);
		assertFalse("exist ala", listImageNamebyPixel == null);
	}

	@Test
	public void testqueryByWidthImageRangeAndUrlImage() {
		// List<Image> listImageNamebyPixel=
		// imageJpaRepository.queryByWidthImageGreaterThanEqualAndHeightImageLessThanEqualAndUrlImageLike(
		// 0,1720,"http%") ;
		// List<Image> listImageNamebyPixel=
		// imageJpaRepository.queryByWidthImageGreaterThanEqualAndHeightImageLessThanEqualAndUrlImageLike1(
		// 0,1720,"http%") ;
		// List<Image> listImageNamebyPixel=
		// imageJpaRepository.queryByWidthImageGreaterThanEqualAndHeightImageLessThanEqualAndUrlImageLike2(
		// 0,1720,"http%") ;
		List<Image> listImageNamebyPixel = imageJpaRepository.queryByWidthImageGreaterThanEqualAndHeightImageLessThanEqualAndUrlImageLike4();
		System.out.println("testqueryByWidthImageRangeAndUrlImage like% http [200px,200px], find this: " + listImageNamebyPixel.size());
		listImageNamebyPixel.forEach((x) -> System.out.println("----> " + x.getIdImage()));
		assertFalse("exist ala", listImageNamebyPixel == null);
	}

	@Test
	public void testPagination() {
		Pageable pageRequest = new PageRequest(3, 5);
		List<Image> listImageNamebyPixel = imageJpaRepository.queryAllImagesByPage(pageRequest);
		System.out.println("testPagination " + listImageNamebyPixel.size());
		listImageNamebyPixel.forEach((x) -> System.out.println("testPagination ----> " + x.getIdImage()));
		assertFalse("exist ala", listImageNamebyPixel == null);
	}

	@Test
	public void testPagination1() {
		Sort sort = new Sort(Sort.Direction.ASC, "urlImage");
		Pageable pageRequest = new PageRequest(0, 5, sort);
		Page<Image> listImageNamebyPixel = imageJpaRepository.queryByNameImageLike("%dog%", pageRequest);
		System.out.println("testPagination1 " + listImageNamebyPixel.getSize());
		listImageNamebyPixel.forEach((x) -> System.out.println("testPagination1 ----> " + x.getNameImage()));
		for (Image image : listImageNamebyPixel) {
			System.out.println("image pagination " + image.getNameImage());
		}
		assertFalse("exist ala", listImageNamebyPixel == null);
	}

}
