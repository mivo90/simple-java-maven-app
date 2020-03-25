package com.kwieto.api.controller;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

@SpringBootTest
class BlablaTests {

	Blabla blabla = new Blabla();

	@Test
	public void blabla1() {
		Assert.isTrue(!blabla.isFalse(), "test");
	}

	@Test
	public void blabla2() {
		Assert.isTrue(blabla.isTrue(), "test");
	}
}

