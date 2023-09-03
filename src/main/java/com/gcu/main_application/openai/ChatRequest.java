package com.gcu.main_application.openai;

import java.util.ArrayList;
import java.util.List;

//Thanks https://www.baeldung.com/spring-boot-chatgpt-api-openai
public class ChatRequest {

	private String model;
	private List<Message> messages;
	private int n = 1;
	private double temperature;

	public ChatRequest() {	}
	
	public ChatRequest(String model, String prompt) {
		this.model = model;

		this.messages = new ArrayList<>();
		this.messages.add(new Message("user", prompt));
	}

	public ChatRequest(String model, List<Message> messages, int n, double temperature) {
		super();
		this.model = model;
		this.messages = messages;
		this.n = n;
		this.temperature = temperature;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public List<Message> getMessages() {
		return messages;
	}

	public void setMessages(List<Message> messages) {
		this.messages = messages;
	}

	public int getN() {
		return n;
	}

	public void setN(int n) {
		this.n = n;
	}

	public double getTemperature() {
		return temperature;
	}

	public void setTemperature(double temperature) {
		this.temperature = temperature;
	}

}
