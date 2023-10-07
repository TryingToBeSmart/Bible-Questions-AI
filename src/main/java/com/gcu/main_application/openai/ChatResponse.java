package com.gcu.main_application.openai;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The Class ChatResponse.
 */
//Thanks https://www.baeldung.com/spring-boot-chatgpt-api-openai
public class ChatResponse {

	//logger
	private static final Logger logger = LoggerFactory.getLogger(ChatResponse.class);
	
	/** The choices. */
	private List<Choice> choices;

	/**
	 * Instantiates a new chat response.
	 */
	public ChatResponse() {
		logger.info("New blank ChatResponse constructed");
	}

	/**
	 * Instantiates a new chat response.
	 *
	 * @param choices the choices
	 */
	public ChatResponse(List<Choice> choices) {
		super();
		this.choices = choices;
		logger.info("New ChatResponse with choices constructed");
	}

	/**
	 * Gets the choices.
	 *
	 * @return the choices
	 */
	public List<Choice> getChoices() {
		logger.info("getChoices");
		return choices;
	}

	/**
	 * Sets the choices.
	 *
	 * @param choices the new choices
	 */
	public void setChoices(List<Choice> choices) {
		this.choices = choices;
		logger.info("setChoices");
	}

	/**
	 * The Class Choice.
	 */
	public static class Choice {
		//logger
		private static final Logger logger = LoggerFactory.getLogger(Choice.class);

		/** The index. */
		private int index;
		
		/** The message. */
		private Message message;

		/**
		 * Instantiates a new choice.
		 */
		public Choice() {
			logger.info("New blank Choice constructed");
		}

		/**
		 * Instantiates a new choice.
		 *
		 * @param index the index
		 * @param message the message
		 */
		public Choice(int index, Message message) {
			super();
			this.index = index;
			this.message = message;
			logger.info("New Choice with index/message constructed");
		}

		/**
		 * Gets the index.
		 *
		 * @return the index
		 */
		public int getIndex() {
			logger.info("getIndex");
			return index;
		}

		/**
		 * Sets the index.
		 *
		 * @param index the new index
		 */
		public void setIndex(int index) {
			this.index = index;
			logger.info("setIndex");
		}

		/**
		 * Gets the message.
		 *
		 * @return the message
		 */
		public Message getMessage() {
			logger.info("getMessage");
			return message;
		}

		/**
		 * Sets the message.
		 *
		 * @param message the new message
		 */
		public void setMessage(Message message) {
			this.message = message;
			logger.info("setMessage");
		}

	}
}
