package com.viewquiz.backend.app.quiz.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ViewController {

	// @RequestMapping("/")
	// public String index() {
	// return "index.html";
	// }
	//
	// @RequestMapping("/spa/**")
	// public String app() {
	// return "index.html";
	// }

	@RequestMapping({ "/bikes", "/milages", "/gallery", "/tracks", "/tracks/{id:\\w+}", "/location", "/about", "/tests","/tests/new","/tests/**","/questions","/answers" })
	public String index() {
		return "forward:/index.html";
	}
}
