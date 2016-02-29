package com.viewquiz.backend.app.quiz.persistence.model.util;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

public class CustomDateDerializer extends JsonDeserializer<Date> {
	private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

//	@Override
//	public Date deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException, JsonProcessingException {
//		ObjectCodec oc = jp.getCodec();
//		JsonNode node = oc.readTree(jp);
//
//		String dateString = node.asText();
//
//		Date joinDate;
//		try {
//			joinDate = dateFormat.parse(dateString);
//		} catch (ParseException e) {
//			throw new JsonParseException(e.getMessage(), JsonLocation.NA);
//		}
//
//		return joinDate;
//	}
	@Override
	public Date deserialize(JsonParser jsonParser, DeserializationContext deserializationContext)
			throws IOException, JsonProcessingException {
		String dateText = jsonParser.getText();
		Date parsedDate;
		try {
			parsedDate = dateFormat.parse(dateText);
			return parsedDate;
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return new Date();
	}
}
