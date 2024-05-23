package com.neopane.springselenium.kelvin.config;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;

import com.neopane.springselenium.kelvin.annotation.LazyConfiguration;

@LazyConfiguration
public class WebDriveWaitConfig {
	
	
	@Value("${default.timeout:30}")
	public int timeout;

	
	
	@Bean
	@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
	public WebDriverWait webDriverWait(WebDriver driver) {
		
		return new WebDriverWait(driver, Duration.ofSeconds(timeout));
	}
}
