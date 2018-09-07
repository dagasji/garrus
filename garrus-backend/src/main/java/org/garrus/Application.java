package org.garrus;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

import javax.annotation.PostConstruct;

import org.joda.time.DateTimeUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

abstract

@SpringBootApplication 
@EnableScheduling
public class Application {

	@Value("${isTesting}")
	private boolean isTesting;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@PostConstruct
	void started() {
		TimeZone.setDefault(TimeZone.getTimeZone("GMT-3"));
		// Set now date for testing.

//		if (this.isTesting) {
//			SimpleDateFormat DATE_FORMATTER = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss:SSS");
//			Date fixedDateTime;
//			try {
//				fixedDateTime = DATE_FORMATTER.parse("27/07/2018 10:12:00:000");
//				DateTimeUtils.setCurrentMillisFixed(fixedDateTime.getTime());
//			} catch (ParseException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
	}
}