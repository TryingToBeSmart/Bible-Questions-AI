package com.gcu.main_application.openai;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

//Thanks https://www.baeldung.com/spring-boot-chatgpt-api-openai

/**
 * The Class OpenAIRestTemplateConfig.
 */
@Configuration
public class OpenAIRestTemplateConfig {
	//logger
	private static final Logger logger = LoggerFactory.getLogger(OpenAIRestTemplateConfig.class);

	/** The openai api key. */
	@Value("${openai.api.key}")
	private String openaiApiKey;

	/**
	 * Openai rest template.
	 *
	 * @return the rest template
	 */
	@Bean
	@Qualifier("openaiRestTemplate")
	public RestTemplate openaiRestTemplate() {
		logger.info("Began openaiRestTemplate()");
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.getInterceptors().add((request, body, execution) -> {
			request.getHeaders().add("Authorization", "Bearer " + openaiApiKey);
			logger.info("Exiting openaiRestTemplate() with execution.execute(request, body))");
			return execution.execute(request, body);
		});
		logger.info("Exiting openaiRestTemplate() with only restTemplate");
		return restTemplate;
	}
}
