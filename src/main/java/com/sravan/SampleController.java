package com.sravan;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

@Controller
public class SampleController {
	@Autowired
	private Environment environment;
	@RequestMapping("/test.html")
	public @ResponseBody String getReponse() {
		RestTemplate template = new RestTemplate();
		String endpointUrl = environment.getProperty("test.endpoint");
		ResponseEntity<String> entity = template.getForEntity(endpointUrl, String.class);
		return entity.getBody();
	}
}
