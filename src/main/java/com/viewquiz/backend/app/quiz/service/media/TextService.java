//package com.viewquiz.backend.app.quiz.service.media;
//
//import java.util.List;
//import java.util.Map;
//
//import org.springframework.beans.BeanUtils;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import com.viewquiz.backend.app.quiz.persistence.model.media.Text;
//import com.viewquiz.backend.app.quiz.persitence.repository.media.TextJpaRepository;
//
////package com.viewquiz.backend.app.quiz.service.media;
////
////import org.springframework.beans.factory.annotation.Autowired;
////
////import com.viewquiz.backend.app.quiz.persistence.model.media.Text;
////import com.viewquiz.backend.app.quiz.persitence.repository.media.TextRepository;
////import com.viewquiz.backend.app.quiz.service.generic.AbstractService;
////
////public class TextService extends AbstractService<TextRepository, Text, Integer> {
////
////	private TextRepository textRepository;
////
////	@Autowired
////	public TextService(TextRepository textRepository) {
////		this.textRepository = textRepository;
////	}
////
////	@Override
////	protected TextRepository getRepository() {
////		return textRepository;
////	}
////
////}
//
//@Service
//public class TextService {
//	private TextJpaRepository textJpaRepository;
//
//	@Autowired
//	public TextService(TextJpaRepository textJpaRepository) {
//		this.textJpaRepository = textJpaRepository;
//	}
//
//	public Text create(Text text) {
//		return textJpaRepository.saveAndFlush(text);
//	}
//
//	public Text read(int idText) {
//		Text text = textJpaRepository.findOne(idText);
//		return text;
//	}
//
//	public List<Text> list() {
//		List<Text> texts = textJpaRepository.findAll();
//		return texts;
//	}
//
//	public Text update(int idText, Text newText) {
//		Text textToUpdate = textJpaRepository.findOne(idText);
//		// BeanUtils.copyProperties(newText, textToUpdate, "idText");
//		// BeanUtils.copyProperties(othePerson, person);
//		// textToUpdate=new Text(newText);
//		if (newText.getHtmlText() != null) {
//			textToUpdate.setHtmlText(newText.getHtmlText());
//		}
//		if (newText.getSimpleText() != null) {
//			textToUpdate.setSimpleText(newText.getSimpleText());
//		}
//		Text textUpdated = textJpaRepository.saveAndFlush(textToUpdate);
//		return textUpdated;
//	}
//
//	public void delete(int idText) {
//		textJpaRepository.delete(idText);
//	}
//
//}