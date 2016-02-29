package com.viewquiz.backend.app.server;

import org.springframework.boot.autoconfigure.web.ServerProperties;

import org.springframework.context.annotation.Bean;

import org.springframework.context.annotation.Configuration;

@Configuration

public class ServerPropertiesConfig {
	@Bean
	public ServerProperties getServerProperties() {

		return new ServerCustomization();

	}

}
