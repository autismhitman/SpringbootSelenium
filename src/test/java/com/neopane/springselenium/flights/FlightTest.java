package com.neopane.springselenium.flights;

import org.springframework.beans.factory.annotation.Autowired;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.neopane.springselenium.SeleniumApplicationTestNGTest;
import com.neopane.springselenium.page.flights.FlightAppDetails;
import com.neopane.springselenium.page.flights.FlightPage;

public class FlightTest extends SeleniumApplicationTestNGTest{
	
	@Autowired
	private FlightPage flightpage;
	
	@Autowired
	private FlightAppDetails fad;
	
	
	@Test
	public void flightTest() {
		
		this.flightpage.goTo(this.fad.getUrl());
		Assert.assertTrue(this.flightpage.isAt());
		Assert.assertEquals(this.flightpage.getLabels(), this.fad.getLabels());
	}
	

}
