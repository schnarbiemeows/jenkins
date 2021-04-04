package com.schnarbiesnmeowers.jenkins;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
/**
 *
 * @author Dylan I. Kessler
 *
 */
@SpringBootApplication
public class JenkinsApplication {

	private static final Logger FILE_LOGGER = LogManager.getLogger("FileAppender");

	/**
	 * this is the main class for our Jenkins application
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(JenkinsApplication.class, args);
	}


}