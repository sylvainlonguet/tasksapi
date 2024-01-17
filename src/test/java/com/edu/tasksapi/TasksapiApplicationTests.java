package com.edu.tasksapi;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;

/** pour que le serveur demarre sur un port random */
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)

class TasksapiApplicationTests {

	@LocalServerPort
	/** could also be @Value("${server.port}") */
	private int port;

	@Autowired
	private TestRestTemplate template;

	@Test
	void whenTryingToRetrieveID1_ShouldGetJson() {

		String result = template.getForObject("http://localhost:" + port + "/1", String.class);

		assert (result.contains("{"));

	}

}
