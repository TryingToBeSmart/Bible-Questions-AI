package com.gcu.main_application.openai;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

/**
 * The Class ChatController.
 */
//Thanks https://www.baeldung.com/spring-boot-chatgpt-api-openai
@Controller
public class ChatController {
	//logger
	private static final Logger logger = LoggerFactory.getLogger(ChatController.class);
	
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
		logger.info("Get /chat started");
		model.addAttribute("chatRequest", new ChatRequest()); // Add it to the model
		logger.info("Get /chat ended");
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
		logger.info("getChatResponse started");
		
		// create a request
		ChatRequest request = new ChatRequest(openaiModel, messages);

		// call the API
		try {
            ChatResponse response = restTemplate.postForObject(apiUrl, request, ChatResponse.class);

            if (response == null || response.getChoices() == null || response.getChoices().isEmpty()) {
                logger.error("No OpenAI API response");
                model.addAttribute("chatResponse", "No response");
            } else {
                model.addAttribute("chatResponse", response.getChoices().get(0).getMessage().getContent());
                logger.info("New OpenAI API response recieved");
            }
        } catch (HttpClientErrorException.Unauthorized ex) {
            logger.error("Invalid API key", ex);
            throw new OpenAIException("Invalid API key");
        }
		
		// add new 'chatRequest' again for the GET request
		// Might want to change this eventually to keep the original 'request' to keep track of the conversation.  Maybe for 'paid' users
        model.addAttribute("chatRequest", new ChatRequest());
        logger.info("getChatResponse ending");
        
		// return the first response
		return "chat";
	}
	
}