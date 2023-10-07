package com.gcu.main_application;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * The Class MainApplication.
 */
@SpringBootApplication
public class MainApplication {

	//logger
	private static final Logger logger = LoggerFactory.getLogger(MainApplication.class);
	
	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		
		logger.info("main started...");
		
		SpringApplication.run(MainApplication.class, args);
		
		logger.info("main finished...");
	}

}
