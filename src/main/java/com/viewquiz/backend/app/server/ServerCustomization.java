package com.viewquiz.backend.app.server;

import org.springframework.boot.autoconfigure.web.ServerProperties;

import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;

import org.springframework.boot.context.embedded.ErrorPage;

import org.springframework.http.HttpStatus;

public class ServerCustomization extends ServerProperties {

	@Override

	public void customize(ConfigurableEmbeddedServletContainer container) {

		super.customize(container);

		// container.addErrorPages(new ErrorPage(HttpStatus.NOT_FOUND,

		// "/jsp/404.jsp"));

		// container.addErrorPages(new

		// ErrorPage(HttpStatus.INTERNAL_SERVER_ERROR,

		// "/jsp/500.jsp"));

		// container.addErrorPages(new ErrorPage("/jsp/error.jsp"));

		container.addErrorPages(new ErrorPage(HttpStatus.NOT_FOUND, "/404.html"));

		container.addErrorPages(new ErrorPage(HttpStatus.INTERNAL_SERVER_ERROR, "/500.html"));

		container.addErrorPages(new ErrorPage("/error.html"));

	}

	
	
}
