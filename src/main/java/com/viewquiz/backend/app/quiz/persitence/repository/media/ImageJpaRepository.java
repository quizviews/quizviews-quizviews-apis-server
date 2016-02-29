package com.viewquiz.backend.app.quiz.persitence.repository.media;

import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.viewquiz.backend.app.quiz.persistence.model.media.Image;

@Repository
public interface ImageJpaRepository extends JpaRepository<Image, Integer> {
	// For DSL we use get/find/counts/read

	// By FieldName //IS EQUAL NOT

	Image getImageByNameImage(String nameImage);

	Image getImageByNameImageIs(String nameImage);

	Image getImageByNameImageEquals(String nameImage);

	List<Image> getImageByNameImageNot(String nameImage);

	List<Image> getImagesByNameImage(String nameImage);

	List<Image> getImagesByNameImageIs(String nameImage);

	List<Image> getImagesByNameImageEquals(String nameImage);

	List<Image> getImagesByNameImageNot(String nameImage);

	// LIKE {%} // StartingWith EndingWith Containing no {%}
	List<Image> getImagesByNameImageLike(String nameImage);

	List<Image> getImagesByNameImageStartingWith(String nameImage);

	List<Image> getImagesByNameImageEndingWith(String nameImage);

	List<Image> getImagesByNameImageContaining(String nameImage);

	List<Image> findImagesByNameImageLike(String nameImage);

	// AND OR
	List<Image> findImagesByUrlImageOrUriImage(String urlImage, String uriImage);

	List<Image> findImagesByUrlImageAndUriImage(String urlImage, String uriImage);
	// GreaterThan > , GreaterThanEqual >= , LessThan < , LessThanEqual <=

	// 2 fields
	List<Image> findImagesByWidthImageGreaterThanEqualAndHeightImageGreaterThanEqual(int widthImage, int heightImage);

	// Before Date
	List<Image> findByHorodatageCreationBefore(Date date);

	// List<Image> findByBooleanFieldTrue();FieldFalse();

	// IgnoreCase "X" == where UPPER(i.nameImage) like UPPER (?X%) ==where
	// UPPER(i.nomImage) =UPPER (?X)
	List<Image> findImagesByNameImageStartingWithIgnoreCase(String nameImage);

	// ASC DESC OrderByFiledAsc
	List<Image> findImagesByNameImageStartingWithIgnoreCaseOrderByWidthImageAsc(String nomImage);

	// First, Top5 Top10, DistinctQuestion
	List<Image> findTop5ImagesByNameImageStartingWithIgnoreCaseOrderByWidthImageDesc(String nomImage);

	// no repetition for the collection of questions
	List<Image> findTop5DistinctQuestionByNameImageStartingWithIgnoreCaseOrderByWidthImageAsc(String nomImage);

	// //query
	@Query("select i from Image i where i.widthImage >= :lowestWidth and i.widthImage <= :highestWidth and i.urlImage like :url")
	List<Image> queryByWidthImageGreaterThanEqualAndHeightImageLessThanEqualAndUrlImageLike1(@Param("lowestWidth") int lowestW, @Param("highestWidth") int highestW, @Param("url") String url);

	//
	@Query("select i from Image i where i.widthImage >= ?1 and i.widthImage <= ?2 and i.urlImage like ?3")
	List<Image> queryByWidthImageGreaterThanEqualAndHeightImageLessThanEqualAndUrlImageLike2(int lowestW, int highestW, String url);

	// //its equivalent
	@Query("select i from Image i where i.widthImage >= ?1 and i.widthImage <= ?2 and i.urlImage like %?3%")
	List<Image> queryByWidthImageGreaterThanEqualAndHeightImageLessThanEqualAndUrlImageLike3(int lowestW, int highestW, String url);

	// @Query(value="select * from Image i where i.width_Image >= ?0 and
	// i.width_Image <= ?1 and i.url_Image like %?2%", nativeQuery=true)
	@Query(value = "select * from images   where  width_image > 10 ", nativeQuery = true)
	List<Image> queryByWidthImageGreaterThanEqualAndHeightImageLessThanEqualAndUrlImageLike4();

	// //its equivalent
	List<Image> queryByWidthImageGreaterThanEqualAndHeightImageLessThanEqualAndUrlImageLike(int lowestW, int highestW, String urlImage);

	List<Image> queryByWidthImageGreaterThanEqualAndHeightImageLessThanEqual(int lowestW, int highestW);

	/// pagination
	Page<Image> queryByNameImageLike(String name, Pageable pageable);

	@Query(value = "select i from Image i ", nativeQuery = false)
	List<Image> queryAllImagesByPage(Pageable pageable);

}
