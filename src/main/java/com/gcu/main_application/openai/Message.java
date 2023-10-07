package com.gcu.main_application.openai;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The Class Message.
 */
//Thanks https://www.baeldung.com/spring-boot-chatgpt-api-openai
public class Message {
	//logger
	private static final Logger logger = LoggerFactory.getLogger(Message.class);

	/** The role. */
	private String role;
	
	/** The content. */
	private String content;

	/**
	 * Instantiates a new message.
	 */
	public Message() {
		logger.info("New blank Message constructed");
	}
	
	/**
	 * Instantiates a new message.
	 *
	 * @param role the role
	 * @param content the content
	 */
	public Message(String role, String content) {
		super();
		this.role = role;
		this.content = content;
		logger.info("New Message with role/content constructed");
	}

	/**
	 * Gets the role.
	 *
	 * @return the role
	 */
	public String getRole() {
		logger.info("getRole");
		return role;
	}

	/**
	 * Sets the role.
	 *
	 * @param role the new role
	 */
	public void setRole(String role) {
		this.role = role;
		logger.info("setRole");
	}

	/**
	 * Gets the content.
	 *
	 * @return the content
	 */
	public String getContent() {
		logger.info("getContent");
		return content;
	}

	/**
	 * Sets the content.
	 *
	 * @param content the new content
	 */
	public void setContent(String content) {
		this.content = content;
		logger.info("setContent");
	}

}
