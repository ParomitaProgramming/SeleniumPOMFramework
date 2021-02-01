package com.qa.tests;

import org.testng.annotations.Test;

import com.qa.base.TestBase;

import org.testng.annotations.BeforeTest;

public class LoginTest extends TestBase {

	TestBase testBase;
	
	@BeforeTest
	public void setup() {
		testBase = new TestBase();
		testBase.initialization();
	}

	@Test
	public void login() {
		System.out.println("hello");
	}


}
