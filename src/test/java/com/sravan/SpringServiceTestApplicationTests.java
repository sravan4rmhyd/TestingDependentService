package com.sravan;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.context.annotation.Import;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.RestTemplate;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = SpringServiceTestApplication.class)
@Import(SampleTestController.class)
@TestPropertySource("test.properties")
@WebIntegrationTest
@DirtiesContext
public class SpringServiceTestApplicationTests {
	@Autowired
	private Environment environment;
	@Test
	public void contextLoads() {
		RestTemplate template = new RestTemplate();
		String url = environment.getProperty("test.endpoint");
		ResponseEntity<String> entity = template.getForEntity(url, String.class);
		String response =entity.getBody();
		Assert.assertEquals("welcome to test result", response);
	}

}
