package com.viewquiz.backend.app.quiz.web.controller.exception;


/*I will not use this way is was just for a try*/
public class TestNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 7422596730625593417L;

	public TestNotFoundException(int id) {
		super("Test with id " + id + " is not found");
	}

}
