package com.neopane.springselenium.resource;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.util.FileCopyUtils;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.neopane.springselenium.SeleniumApplicationTestNGTest;

public class ResourceTest extends SeleniumApplicationTestNGTest {
	
	
	@Value("classpath:data.csv") //"file:E:\Navin\2024\Cucumber2024\spring-selenium\spring-selenium\src\test\resources\data.csv
	private Resource resource;
	
	@Test
	public void resourceTest() throws IOException {
		
		Files.readAllLines(resource.getFile().toPath()).forEach(System.out::println);
		
	}
	
	
	@Value("https://www.google.com")  
	private Resource resource1;

	@Test
	public void resourceTest1() throws IOException {
		
		System.out.println(
				
				new String(resource1.getInputStream().readAllBytes())
				
				);
		
	}
	
	@Value("https://www.w3.org/2023/Process-20231103/#RecsWD")
	private Resource resource3;
	
	@Value("${screenshot.path}")
	private Path path;
	
	@Test
	public void resourceTest3() throws IOException {
		
		 FileCopyUtils.copy(resource3.getInputStream(), Files.newOutputStream(path));
		
	}
	
	
	@Autowired 
	private ResourceLoader resourceLoader;
	
	
	@Test(dataProvider="getData")
	public void resourceTest4(String url, String saveAs) throws IOException {
		
		FileCopyUtils.copy(resourceLoader.getResource(url).getInputStream(), 
				Files.newOutputStream(path.resolve(saveAs)));
	}
	
	@DataProvider
	public Object[][] getData() throws IOException{
		
		return Files.readAllLines(resource.getFile().toPath())
				.stream()
				.map(m->m.split(","))
				.toArray(Object[][]::new);
		
	}
	
}
