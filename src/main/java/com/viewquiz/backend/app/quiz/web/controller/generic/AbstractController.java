//package com.viewquiz.backend.app.quiz.web.controller.generic;
//
//import java.io.Serializable;
//import org.springframework.data.repository.CrudRepository;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//
////@RequestMapping("/tests/{idTest}/{questions-answers}/{id-questions-answers}/{medias}")
//public abstract class AbstractController<T, ID extends Serializable> {
//
//	private CrudRepository<T, ID> repo;
//
//	public AbstractController(CrudRepository<T, ID> repo) {
//		this.repo = repo;
//	}
//
//	@RequestMapping( method = RequestMethod.GET)
//	public Iterable<T> list() {
//		Iterable<T> all = this.repo.findAll();
//		return all;
//	}
//}