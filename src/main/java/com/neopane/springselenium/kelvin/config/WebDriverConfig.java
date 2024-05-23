package com.neopane.springselenium.kelvin.config;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;

import com.neopane.springselenium.kelvin.annotation.LazyConfiguration;
import com.neopane.springselenium.kelvin.annotation.ThreadScopeBean;

import io.github.bonigarcia.wdm.WebDriverManager;

@LazyConfiguration
@Profile("!remote")
public class WebDriverConfig {
	
  
	 @ThreadScopeBean
	@ConditionalOnProperty(name="browser", havingValue="ff")
	public WebDriver firefoxDriver() {
		
		
		WebDriverManager.firefoxdriver().setup();
		return new FirefoxDriver();
	}
	
	//@Primary
	//@ConditionalOnProperty(name="browser", havingValue="chrome")
	 @ConditionalOnMissingBean
	 @ThreadScopeBean
	 public WebDriver chromeDriver() {
		
		
		WebDriverManager.chromedriver().setup();
		return new ChromeDriver();
	}
	



}
