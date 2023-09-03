package com.gcu.main_application.openai;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

/**
 * The Class ChatController.
 */
//Thanks https://www.baeldung.com/spring-boot-chatgpt-api-openai
@Controller
public class ChatController {

	/** The rest template. */
	@Qualifier("openaiRestTemplate")
	@Autowired
	private RestTemplate restTemplate;

	/** The openai model. */
	@Value("${openai.model}")
	private String openaiModel;

	/** The api url. */
	@Value("${openai.api.url}")
	private String apiUrl;

	/**
	 * Chat.
	 *
	 * @param model the model
	 * @return the string
	 */
	@GetMapping("/chat")
	public String chat(Model model) {
		 model.addAttribute("chatRequest", new ChatRequest()); // Add it to the model
		 return "chat";
	}
	
	/**
	 * Gets the chat response.
	 *
	 * @param messages the messages
	 * @param model the model
	 * @return the chat response
	 */
	@PostMapping("/chat")
	public String getChatResponse(@RequestParam String messages, Model model) {
		// create a request
		ChatRequest request = new ChatRequest(openaiModel, messages);

		// call the API
		ChatResponse response = restTemplate.postForObject(apiUrl, request, ChatResponse.class);

		if (response == null || response.getChoices() == null || response.getChoices().isEmpty()) {
			model.addAttribute("chatResponse", "No response");
		}
		else model.addAttribute("chatResponse", response.getChoices().get(0).getMessage().getContent());
		
		// add 'chatRequest' again for the GET request
        model.addAttribute("chatRequest", new ChatRequest());
        
		// return the first response
		return "chat";
	}
	
}