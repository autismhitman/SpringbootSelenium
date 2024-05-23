package com.neopane.springselenium.page.google;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import com.neopane.springselenium.kelvin.annotation.Page;
import com.neopane.springselenium.page.Base;

@Page
public class GooglePage extends Base {
	
	
	@Autowired
	private SearchComponent sc;
	
	@Autowired
	private SearchResult sr;
	
	public SearchComponent getSc() {
		return sc;
	}

	public SearchResult getSr() {
		return sr;
	}
     
	@Value("${app.url}")
	private String url;
	
	
	public void goTo() {
		this.driver.get(url);
	}

	@Override
	public boolean isAt() {
		 
		return this.sc.isAt();
	}
	
	 
	public void close() {
		this.driver.quit();
	}

}
