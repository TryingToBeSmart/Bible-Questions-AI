package com.gcu.main_application.openai;

/**
 * For OpenAI API exceptions
 */
@SuppressWarnings("serial")
public class OpenAIException extends RuntimeException{

	public OpenAIException(String message) {
		super(message);
	}

}
