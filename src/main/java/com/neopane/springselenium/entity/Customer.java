package com.neopane.springselenium.entity;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
//@Table(name= "customer")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer {
	
	@Id
	private Integer id;
	private String fromCountry;
	private String toCountry;
	private Date dob;
	private String firstName;
	private String lastName;
	
	@Column(name="customer_email")
	private String email;
	private String phone;
	private String comments;

}

//id,from_country,to_country,dob,first_name,last_name,customer_email,phone,comments