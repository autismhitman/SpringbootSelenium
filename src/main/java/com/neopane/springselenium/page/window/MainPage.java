package com.neopane.springselenium.page.window;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.neopane.springselenium.kelvin.annotation.Page;
import com.neopane.springselenium.page.Base;



@Page
public class MainPage extends Base {

	@FindBy(tagName="a")
	private List<WebElement> links;
	
	
	public void goTo() {
		
		this.driver.get("https://vins-udemy.s3.amazonaws.com/ds/window/main.html");
	}
	
	
	public void launchAllWindows() {
		
		links.stream().forEach(WebElement::click);
	}
	
	@Override
	public boolean isAt() {
		 
		return this.wait.until(d->!this.links.isEmpty());
	}
}
