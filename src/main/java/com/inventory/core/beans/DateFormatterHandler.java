package com.inventory.core.beans;

import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.expression.ParseException;
import org.springframework.format.Formatter;

@Configuration
public class DateFormatterHandler {
	@Bean
	public Formatter<Date> localDateFormatter() {
		return new Formatter<Date>() {
			@Override
			public Date parse(String text, Locale locale) throws ParseException {
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ");
				Date result;
				try {
					result = sdf.parse(text);
				} catch (java.text.ParseException e) {
					e.printStackTrace();
					throw new ParseException(3, "Failed at parsing [" + text + "]");
				}
				return result;
			}

			@Override
			public String print(Date object, Locale locale) {
				return DateTimeFormatter.ISO_DATE_TIME.format(object.toInstant());
			}
		};
	}

}
