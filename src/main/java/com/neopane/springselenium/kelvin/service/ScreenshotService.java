package com.neopane.springselenium.kelvin.service;

import java.io.File;
import java.nio.file.Path;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import org.springframework.util.FileCopyUtils;

import com.github.javafaker.Faker;

@Lazy
@Component

public class ScreenshotService {
	
	@Autowired
   
	private ApplicationContext ctx;
	
	@Value("${screenshot.path}")
	private Path path;
	
	@Autowired
	private Faker faker;
	
	public void takesScreenshot()  {
		
		try {
		File srcFile= this.ctx.getBean(TakesScreenshot.class).getScreenshotAs(OutputType.FILE);
		FileCopyUtils.copy(srcFile, this.path.resolve(faker.name().firstName()+".png").toFile());
	} 
		catch(Exception e) {
			
			System.out.println(e.getMessage());
		}
	}
	
	
}
