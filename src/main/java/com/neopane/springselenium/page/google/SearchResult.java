package com.neopane.springselenium.page.google;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.neopane.springselenium.kelvin.annotation.PageFragment;
import com.neopane.springselenium.page.Base;

@PageFragment
public class SearchResult extends Base {
	
	@FindBy(css="div.MjjYud")
	private  List<WebElement> results;
	
	public int getCount() {
		return this.results.size();
	}

	@Override
	public boolean isAt() {
		 
		return this.wait.until(d-> !this.results.isEmpty());
	}

}
