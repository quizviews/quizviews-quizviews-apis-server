//package com.viewquiz.backend.app.quiz.web.controller.media;
//
//import java.io.IOException;
//import java.util.List;
//
//import javax.servlet.http.HttpServletResponse;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.viewquiz.backend.app.quiz.persistence.model.media.Text;
//import com.viewquiz.backend.app.quiz.service.media.TextService;
//import com.viewquiz.backend.app.quiz.web.controller.exception.TextNotFoundException;
//
////@RestController
////@RequestMapping("/texts")
////public class TextController {
////
////	@Autowired
////	private TextServiceImpl textServiceImpl;
////	@RequestMapping(method = RequestMethod.GET)
////	public List<Text> list() {
////		return textServiceImpl.findAll();
////	}
//
////@RequestMapping("/tests/{idTest}/{questions-answers}/{id-questions-answers}/texts")
//@RestController
//// public class TextController extends AbstractController<Text, Integer>{
//public class TextController {
//	private TextService textService;
//
//	@Autowired
//	public TextController(TextService textService) {
//		this.textService = textService;
//
//	}
//
//	@RequestMapping(method = RequestMethod.POST)
//	public Text create(@RequestBody Text text) {
//		return textService.create(text);
//	}
//
//	@RequestMapping(value = "/{idText}", method = RequestMethod.GET)
//	public Text read(@PathVariable("idText") int idText) {
//		Text text = textService.read(idText);
//		if (text == null) {
//			throw new TextNotFoundException(idText);
//		}
//		return text;
//	}
//
//	@RequestMapping(method = RequestMethod.GET)
//	public List<Text> list() {
//		return textService.list();
//	}
//
//	@RequestMapping(value = "/{idText}", method = RequestMethod.PUT)
//	public Text update(@PathVariable("idText") int idText, @RequestBody Text newText) {
//		if (textService.read(idText) == null) {
//			throw new TextNotFoundException(idText);
//		}
//		return textService.update(idText, newText);
//
//	}
//
//	@RequestMapping(value = "/{idText}", method = RequestMethod.DELETE)
//	public void delete(@PathVariable("idText") int idText) {
//		if (textService.read(idText) == null) {
//			throw new TextNotFoundException(idText);
//		}
//		textService.delete(idText);
//
//	}
//
//	@ExceptionHandler(TextNotFoundException.class)
//	public void handleTestNotFound(TextNotFoundException exception, HttpServletResponse response) throws IOException {
//		response.sendError(HttpStatus.NOT_FOUND.value(), exception.getMessage());
//	}
//}
