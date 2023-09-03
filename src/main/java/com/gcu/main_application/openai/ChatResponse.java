package com.gcu.main_application.openai;

import java.util.List;

/**
 * The Class ChatResponse.
 */
//Thanks https://www.baeldung.com/spring-boot-chatgpt-api-openai
public class ChatResponse {

	/** The choices. */
	private List<Choice> choices;

	/**
	 * Instantiates a new chat response.
	 */
	public ChatResponse() {
	}

	/**
	 * Instantiates a new chat response.
	 *
	 * @param choices the choices
	 */
	public ChatResponse(List<Choice> choices) {
		super();
		this.choices = choices;
	}

	/**
	 * Gets the choices.
	 *
	 * @return the choices
	 */
	public List<Choice> getChoices() {
		return choices;
	}

	/**
	 * Sets the choices.
	 *
	 * @param choices the new choices
	 */
	public void setChoices(List<Choice> choices) {
		this.choices = choices;
	}

	/**
	 * The Class Choice.
	 */
	public static class Choice {

		/** The index. */
		private int index;
		
		/** The message. */
		private Message message;

		/**
		 * Instantiates a new choice.
		 */
		public Choice() {
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
		}

		/**
		 * Gets the index.
		 *
		 * @return the index
		 */
		public int getIndex() {
			return index;
		}

		/**
		 * Sets the index.
		 *
		 * @param index the new index
		 */
		public void setIndex(int index) {
			this.index = index;
		}

		/**
		 * Gets the message.
		 *
		 * @return the message
		 */
		public Message getMessage() {
			return message;
		}

		/**
		 * Sets the message.
		 *
		 * @param message the new message
		 */
		public void setMessage(Message message) {
			this.message = message;
		}

	}
}
