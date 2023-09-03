package com.gcu.main_application.openai;

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
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.getInterceptors().add((request, body, execution) -> {
			request.getHeaders().add("Authorization", "Bearer " + openaiApiKey);
			return execution.execute(request, body);
		});
		return restTemplate;
	}
}
