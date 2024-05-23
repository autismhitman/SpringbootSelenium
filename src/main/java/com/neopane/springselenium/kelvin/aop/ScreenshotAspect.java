package com.neopane.springselenium.kelvin.aop;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.neopane.springselenium.kelvin.annotation.TakeScreenshot;
import com.neopane.springselenium.kelvin.service.ScreenshotService;

@Aspect
@Component
public class ScreenshotAspect {
	
  
	@Autowired
	private ScreenshotService screenshotService;
	
 
	
	
	@After("@annotation(takeScreenshot))")
	public void after(TakeScreenshot takeScreenshot) {
		
		this.screenshotService.takesScreenshot();
	}
	
}
