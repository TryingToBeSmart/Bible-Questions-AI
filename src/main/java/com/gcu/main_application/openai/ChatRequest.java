package com.gcu.main_application.openai;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// TODO: Auto-generated Javadoc
/**
 * The Class ChatRequest.
 */
//Thanks https://www.baeldung.com/spring-boot-chatgpt-api-openai
public class ChatRequest {
	
	/** The Constant logger. */
	//logger
	private static final Logger logger = LoggerFactory.getLogger(ChatRequest.class);

	/** The system message. */
	String systemMessage = AiTraining.SYSTEM_MESSAGE;//get training message from doc
	
	/** The model. */
	private String model;
	
	/** The messages. */
	private List<Message> messages;
	
	/** The n. */
	private int n = 1;
	
	/** The temperature. */
	private double temperature;

	/**
	 * Instantiates a new chat request.
	 */
	public ChatRequest() {
		logger.info("New blank ChatRequest constructed");
	}
	
	/**
	 * Instantiates a new chat request.
	 *
	 * @param model the model
	 * @param prompt the prompt
	 */
	public ChatRequest(String model, String prompt) {
		this.model = model;

		this.messages = new ArrayList<>();
		this.messages.add(new Message("system", systemMessage));//add AI training message
		this.messages.add(new Message("user", prompt));//add user's question
		
		logger.info("New model/user prompt ChatRequest constructed");
	}

	/**
	 * Instantiates a new chat request.
	 *
	 * @param model the model
	 * @param messages the messages
	 * @param n the n
	 * @param temperature the temperature
	 */
	public ChatRequest(String model, List<Message> messages, int n, double temperature) {
		super();
		this.model = model;
		this.messages = messages;
		this.n = n;
		this.temperature = temperature;
		
		logger.info("New model/message/n/tempurature ChatRequest constructed");
	}

	/**
	 * Gets the model.
	 *
	 * @return the model
	 */
	public String getModel() {
		logger.info("getModel");
		return model;
	}

	/**
	 * Sets the model.
	 *
	 * @param model the new model
	 */
	public void setModel(String model) {
		this.model = model;
		logger.info("setModel");
	}

	/**
	 * Gets the messages.
	 *
	 * @return the messages
	 */
	public List<Message> getMessages() {
		logger.info("getMessages");
		return messages;
	}

	/**
	 * Sets the messages.
	 *
	 * @param messages the new messages
	 */
	public void setMessages(List<Message> messages) {
		this.messages = messages;
		logger.info("setMessages");
	}

	/**
	 * Gets the n.
	 *
	 * @return the n
	 */
	public int getN() {
		logger.info("getN");
		return n;
	}

	/**
	 * Sets the n.
	 *
	 * @param n the new n
	 */
	public void setN(int n) {
		this.n = n;
		logger.info("setN");
	}

	/**
	 * Gets the temperature.
	 *
	 * @return the temperature
	 */
	public double getTemperature() {
		logger.info("getTemperature");
		return temperature;
	}

	/**
	 * Sets the temperature.
	 *
	 * @param temperature the new temperature
	 */
	public void setTemperature(double temperature) {
		this.temperature = temperature;
		logger.info("setTemperature");
	}

}
