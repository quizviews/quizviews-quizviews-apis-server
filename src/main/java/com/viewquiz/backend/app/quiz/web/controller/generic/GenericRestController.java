package com.viewquiz.backend.app.quiz.web.controller.generic;
//package com.viewquiz.backend.app.quiz.web.controller.media;
//
//import java.io.Serializable;
//import java.util.HashMap;
//import java.util.Map;
//
//import org.springframework.data.repository.CrudRepository;
//import org.springframework.http.MediaType;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//
//import com.viewquiz.backend.app.Log;
//
////import org.apache.commons.beanutils.BeanUtils;
//@RequestMapping("/tests")
//public abstract class GenericRestController<T, ID extends Serializable> {
//	private CrudRepository<T, ID> repository;
//
//	public GenericRestController(CrudRepository<T, ID> repository) {
//		this.repository = repository;
//	}
//
//	// @RequestMapping(value =
//	// "/{idTest}/questions/{idQuestion}/{medias}/{idMedia}", method =
//	// RequestMethod.POST, consumes = { MediaType.APPLICATION_JSON_VALUE })
//	// public Map<String, Object> create(@RequestBody T json) {
//	// Log.D("Created " + json);
//	// Log.D("type is " + json.getClass());
//	//
//	// // T created = this.repository.save(json);
//	//
//	// Map<String, Object> m = new HashMap();
//	// m.put("success", true);
//	// m.put("created", json);
//	// return m;
//	// }
//
//	@RequestMapping(value = "/{idTest}/questions/{idQuestion}/{medias}/{idMedia}", method = RequestMethod.POST, consumes = { MediaType.APPLICATION_JSON_VALUE })
//	public Map<String, Object> read(@RequestBody T json, @PathVariable int idTest, @PathVariable int idQuestion, @PathVariable("medias") String medias, @PathVariable("idMedia") int idMedia) {
//		Log.I(idTest);
//		Log.I(idQuestion);
//		Log.I(medias);
//		Log.I(idMedia);
//
//		Log.D("Read " + json);
//		Log.D("type is " + json.getClass());
//
//		// T created = this.repository.save(json);
//
//		Map<String, Object> m = new HashMap();
//		m.put("success", true);
//		m.put("readed", json);
//		return m;
//	}
//
//}
