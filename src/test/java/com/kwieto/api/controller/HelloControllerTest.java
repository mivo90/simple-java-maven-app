package com.kwieto.api.controller;

import org.junit.Test;
import org.junit.Assert;

public class HelloControllerTest {

	@Test
	public void helloTest() {
		HelloController helloController = new HelloController();
		Assert.assertEquals("Hello!", helloController.hello());
	}

	@Test
	public void testTest() {
		HelloController helloController = new HelloController();
		Assert.assertEquals("Test!", helloController.test());
	}
}

