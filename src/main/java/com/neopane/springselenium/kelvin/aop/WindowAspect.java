package com.neopane.springselenium.kelvin.aop;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.neopane.springselenium.kelvin.annotation.Window;
import com.neopane.springselenium.kelvin.service.WindowSwitchService;

@Aspect
@Component
public class WindowAspect {
	
  
	@Autowired
	private WindowSwitchService switchService;
	
	
	@Before("@target(window) && within(com.neopane.springselenium..*)")
	public void before(Window window) {
		
		this.switchService.switchByTitle(window.value());
	}
	
	
	@After("@target(window) && within(com.neopane.springselenium..*)")
	public void after(Window window) {
		
		this.switchService.switchByIndex(0);
	}
	
}
