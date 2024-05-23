package com.neopane.springselenium.repository;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.neopane.springselenium.entity.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

	
	List<Customer> findByFirstNameStartingWith(String startswith);
	List<Customer> findByDobBetween (Date from , Date to);
}
