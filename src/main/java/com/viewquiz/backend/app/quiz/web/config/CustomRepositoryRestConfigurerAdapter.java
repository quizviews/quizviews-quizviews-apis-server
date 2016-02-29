//package com.viewquiz.backend.app.quiz.web.config;
//
//import java.io.File;
//import java.io.IOException;
//import java.text.SimpleDateFormat;
//import java.util.Date;
//
//import org.springframework.context.annotation.Configuration;
//import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurerAdapter;
//import org.springframework.web.servlet.config.annotation.EnableWebMvc;
//
//import com.fasterxml.jackson.core.JsonGenerationException;
//import com.fasterxml.jackson.databind.JsonMappingException;
//import com.fasterxml.jackson.databind.ObjectMapper;
//
//@Configuration
//@EnableWebMvc
//
//public class CustomRepositoryRestConfigurerAdapter extends RepositoryRestConfigurerAdapter {
//	@Override
//	public void configureJacksonObjectMapper(ObjectMapper objectMapper) {
//		// super.configureJacksonObjectMapper(objectMapper);
//		// try {
//		// objectMapper.writeValue(new File("D:/dataOne.json") ,"yyyy-MM-dd
//		// HH:mm:ss"+new Date());
//		// } catch (JsonGenerationException e) {
//		// e.printStackTrace();
//		// } catch (JsonMappingException e) {
//		// e.printStackTrace();
//		// } catch (IOException e) {
//		// e.printStackTrace();
//		// }
//		// objectMapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd
//		// HH:mm:ss"));
//		objectMapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd"));
//	}
//}
