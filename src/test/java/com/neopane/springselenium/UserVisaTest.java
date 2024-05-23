package com.neopane.springselenium;

import java.sql.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.testng.ITestContext;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.neopane.springselenium.entity.Customer;
import com.neopane.springselenium.page.visa.VisaRegistrationPage;
import com.neopane.springselenium.repository.CustomerRepository;

public class UserVisaTest extends SeleniumApplicationTestNGTest {
	
	
	@Autowired
	private CustomerRepository customerRepo;
	
	@Autowired
	private VisaRegistrationPage  registrationPage;
	
	//@Test
	public void visaTest() {
 
		List<Customer> customers= this.customerRepo.findAll().stream().limit(3).collect(Collectors.toList());
		
		for( Customer c : customers) {
			
			this.registrationPage.goTo();
			this.registrationPage.setNames(c.getFirstName(), c.getLastName());
			this.registrationPage.setCountryFromAndTo(c.getFromCountry(), c.getToCountry());
			this.registrationPage.setBirthDate(c.getDob().toLocalDate());
			this.registrationPage.setContactDetails(c.getEmail(), c.getPhone());
			this.registrationPage.setComments(c.getComments());
			this.registrationPage.submit();
			
			System.out.println(this.registrationPage.getConfirmationNumber());
			
		}
		
		
	}
	
	//@Test
	public void visaTest2() {
		List<Customer> customers= this.customerRepo.findByFirstNameStartingWith("Mi").stream().limit(3).collect(Collectors.toList());
		System.out.println(customers.size());
		for( Customer c : customers) {
			
			this.registrationPage.goTo();
			this.registrationPage.setNames(c.getFirstName(), c.getLastName());
			this.registrationPage.setCountryFromAndTo(c.getFromCountry(), c.getToCountry());
			this.registrationPage.setBirthDate(c.getDob().toLocalDate());
			this.registrationPage.setContactDetails(c.getEmail(), c.getPhone());
			this.registrationPage.setComments(c.getComments());
			this.registrationPage.submit();
			
			System.out.println(this.registrationPage.getConfirmationNumber());
			
		}
		
	}
	
	
	@Test(dataProvider="getData")
	public void visaTest3(Customer c) {
	  
			this.registrationPage.goTo();
			this.registrationPage.setNames(c.getFirstName(), c.getLastName());
			this.registrationPage.setCountryFromAndTo(c.getFromCountry(), c.getToCountry());
			this.registrationPage.setBirthDate(c.getDob().toLocalDate());
			this.registrationPage.setContactDetails(c.getEmail(), c.getPhone());
			this.registrationPage.setComments(c.getComments());
			this.registrationPage.submit();
			System.out.println(this.registrationPage.getConfirmationNumber());
			
 	
	}
	
	
	@DataProvider
	public Object[] getData(ITestContext context) {
		
		return this.customerRepo.
				findByDobBetween(Date.valueOf(context.getCurrentXmlTest().getParameter("dateFrom")),
						Date.valueOf(context.getCurrentXmlTest().getParameter("dateTo")))
				.stream()
				.limit(3)
				.toArray();
	}
	

}
