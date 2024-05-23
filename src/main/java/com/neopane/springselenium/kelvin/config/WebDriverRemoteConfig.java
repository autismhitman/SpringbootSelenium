package com.neopane.springselenium.kelvin.config;

import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;

import com.neopane.springselenium.kelvin.annotation.LazyConfiguration;
import com.neopane.springselenium.kelvin.annotation.ThreadScopeBean;

@LazyConfiguration
@Profile("remote")

public class WebDriverRemoteConfig {

	@Value("${selenium.grid.url}")
	private URL url;

	@ThreadScopeBean
	@ConditionalOnProperty(name = "browser", havingValue = "ff")
	public WebDriver remotefirefoxDriver() {

		return new RemoteWebDriver(this.url, new FirefoxOptions());

	}

	@ThreadScopeBean
	@ConditionalOnMissingBean
	public WebDriver remoteChromeDriver() {
		return new RemoteWebDriver(this.url, new ChromeOptions());
	}

}
