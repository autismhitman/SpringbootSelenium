package com.neopane.springselenium.googleTest;

 

import static org.testng.Assert.assertTrue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.testng.annotations.Test;

import com.neopane.springselenium.SeleniumApplicationTestNGTest;
import com.neopane.springselenium.kelvin.service.ScreenshotService;
import com.neopane.springselenium.page.google.GooglePage;

public class Google2Test extends SeleniumApplicationTestNGTest{
	
	@Autowired
	private GooglePage gp;
	
	@Lazy
	@Autowired
	private ScreenshotService screenshot;
	
	@Test
	public void googleTest2() {
	 	
		this.gp.goTo();
		assertTrue(this.gp.isAt());
		this.gp.getSc().search("Selenium");
		assertTrue(this.gp.getSr().isAt());
		assertTrue(this.gp.getSr().getCount()>2);
		this.screenshot.takesScreenshot();
		this.gp.close();
	 	
		
	}
	

}
