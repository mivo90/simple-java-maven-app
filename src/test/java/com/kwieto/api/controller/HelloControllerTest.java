package com.kwieto.api.controller;

import org.junit.Test;

class HelloControllerTest {

	@Test
	public void helloTest() {
		HelloController helloController = new HelloController();
		helloController.hello();
	}

	@Test
	public void testTest() {
		HelloController helloController = new HelloController();
		helloController.test();
	}
}

