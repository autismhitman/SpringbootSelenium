package com.neopane.springselenium.kelvin.config;

import org.springframework.context.annotation.Bean;

import com.github.javafaker.Faker;
import com.neopane.springselenium.kelvin.annotation.LazyConfiguration;

@LazyConfiguration
public class FakerConfig {
	
	@Bean
	public Faker getFakker() {
		
		return new Faker();
	}

}
