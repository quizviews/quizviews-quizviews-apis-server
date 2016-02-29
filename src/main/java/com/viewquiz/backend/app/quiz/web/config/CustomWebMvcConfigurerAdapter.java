package com.viewquiz.backend.app.quiz.web.config;

import java.util.List;
import java.util.Optional;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.AbstractJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.fasterxml.jackson.databind.SerializationFeature;
import com.viewquiz.backend.app.Booster;

//@EnableWebMvc
@Configuration
public class CustomWebMvcConfigurerAdapter extends WebMvcConfigurerAdapter {
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		// http://localhost:8080/files/1.jpg
		// registry.addResourceHandler("/files/**").addResourceLocations("file:/C://Temp/");
		// registry.addResourceHandler("/files/**").addResourceLocations("file:/C://FolderSetup/");
		// registry.addResourceHandler("/files/**").addResourceLocations("file:/C://FolderSetup/Files/");+
		
		/*** just because I used an S3 */
//		registry.addResourceHandler("/files/**").addResourceLocations("file:/" + Booster.GetFilesDirectory() + "/");
	}

	
//	//needs 
//	@Override
//	public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
//		// super.extendMessageConverters(converters);
//		Optional<HttpMessageConverter<?>> converterFounded = converters.stream()
//				.filter(c -> c instanceof AbstractJackson2HttpMessageConverter).findFirst();
//		if (converterFounded.isPresent()) {
//			final AbstractJackson2HttpMessageConverter converter = (AbstractJackson2HttpMessageConverter) converterFounded
//					.get();
//			// converter.getObjectMapper().enable(DeserializationFeature.)
//			converter.getObjectMapper().enable(SerializationFeature.INDENT_OUTPUT);
//			// application.properties
//			// #spring.jackson.serialization.indent-output=true
//
//		}
//	}
}