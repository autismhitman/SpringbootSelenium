package com.neopane.springselenium.page.window;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.neopane.springselenium.kelvin.annotation.Window;
import com.neopane.springselenium.page.Base;



@Window("Page A")
public class PageA extends Base {

	@FindBy(id="area")
	private  WebElement textarea;
	 
	
	public void addToArea(final String msg) {
		
		this.textarea.sendKeys(msg);
	}
	
	@Override
	public boolean isAt() {
		 
		return this.wait.until(d->!this.textarea.isDisplayed());
	}
}
