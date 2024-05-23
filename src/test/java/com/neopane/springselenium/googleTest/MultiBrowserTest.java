package com.neopane.springselenium.googleTest;

import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.testng.annotations.Test;

import com.neopane.springselenium.SeleniumApplicationTestNGTest;

public class MultiBrowserTest extends SeleniumApplicationTestNGTest {
	
	
	@Autowired
	private ApplicationContext ctx;
	
    
	@Test
	public void browserTest() {
		this.ctx.getBean("chromeDriver", WebDriver.class).get("https://google.com");
		this.ctx.getBean("firefoxDriver", WebDriver.class).get("https://Yahoo.com");
	}
}
