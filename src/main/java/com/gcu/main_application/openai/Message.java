package com.gcu.main_application.openai;

/**
 * The Class Message.
 */
//Thanks https://www.baeldung.com/spring-boot-chatgpt-api-openai
public class Message {

	/** The role. */
	private String role;
	
	/** The content. */
	private String content;

	/**
	 * Instantiates a new message.
	 */
	public Message() {	}
	
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
	}

	/**
	 * Gets the role.
	 *
	 * @return the role
	 */
	public String getRole() {
		return role;
	}

	/**
	 * Sets the role.
	 *
	 * @param role the new role
	 */
	public void setRole(String role) {
		this.role = role;
	}

	/**
	 * Gets the content.
	 *
	 * @return the content
	 */
	public String getContent() {
		return content;
	}

	/**
	 * Sets the content.
	 *
	 * @param content the new content
	 */
	public void setContent(String content) {
		this.content = content;
	}

}
