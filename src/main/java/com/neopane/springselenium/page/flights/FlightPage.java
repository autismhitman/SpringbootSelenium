package com.neopane.springselenium.page.flights;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.neopane.springselenium.kelvin.annotation.Page;
import com.neopane.springselenium.kelvin.annotation.TakeScreenshot;
import com.neopane.springselenium.page.Base;

@Page
public class FlightPage extends Base {
       
	
	@FindBy(css="nav.P6Wwdb.OE019d span[jsname='V67aGc']")
	private List<WebElement> elements;
	
	
	public void goTo(final String url) {
		
		this.driver.get(url);
		this.driver.manage().window().maximize();
	}
	
	@TakeScreenshot
	public List<String> getLabels(){
		
		return this.elements
				.stream()
				.map(e->e.getText())
				.map(String::trim)
				.collect(Collectors.toList());
	}
	
	@Override
	public boolean isAt() {
		 
		return this.wait.until(d-> !this.elements.isEmpty());
	}

}
