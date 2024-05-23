package com.neopane.springselenium.window;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.TestPropertySource;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.neopane.springselenium.SeleniumApplicationTestNGTest;
import com.neopane.springselenium.page.window.MainPage;
import com.neopane.springselenium.page.window.PageA;
import com.neopane.springselenium.page.window.PageB;
import com.neopane.springselenium.page.window.PageC;

@TestPropertySource(properties = "browser=chrome")
public class WindowSwitchTest extends SeleniumApplicationTestNGTest{
	
	   
	    @Autowired
	    private MainPage mainPage;

	    @Autowired
	    private PageA pageA;

	    @Autowired
	    private PageB pageB;

	    @Autowired
	    private PageC pageC;
	
	
		@BeforeClass
		public void setup() {
			this.mainPage.goTo();
			this.mainPage.isAt();
			this.mainPage.launchAllWindows();
			
		}
	
		@Test(dataProvider="getData")
		public void switchTest( int index) {
		  this.pageA.addToArea(index +"\n");
		  this.pageB.addToArea(index * 2 + "\n");
		  this.pageC.addToArea(index * 3 + "\n");
		}
	
	   
		@DataProvider
		public Object[] getData() {
			
			return new Object[] {
					1,
					2,
					3
			};
		}

}
