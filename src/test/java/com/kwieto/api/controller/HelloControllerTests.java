package com.kwieto.api.controller;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class HelloControllerTests {

	@Test
	void helloTest() {
		HelloController helloController = new HelloController();
		helloController.hello();
	}
}

