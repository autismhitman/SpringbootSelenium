package com.neopane.springselenium.page.google;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.neopane.springselenium.kelvin.annotation.PageFragment;
import com.neopane.springselenium.page.Base;

@PageFragment
public class SearchComponent extends Base {
	
	
	@FindBy(name="q")
	private WebElement searchBox;
	
	@FindBy(name="btnK")
	private List<WebElement> searchButton;
	
	public void search(String keyword){
	 this.searchBox.sendKeys(keyword);
	// this.searchBox.sendKeys(Keys.TAB);
	 this.searchButton
	       .stream()
	       .filter(d->d.isDisplayed() && d.isEnabled())
	        .findFirst()
	        .ifPresent(WebElement::click);
		
	}
	
	
	@Override
	public boolean isAt() {
		 
		return this.wait.until((d)->this.searchBox.isDisplayed());
	}
	
	
	

}
