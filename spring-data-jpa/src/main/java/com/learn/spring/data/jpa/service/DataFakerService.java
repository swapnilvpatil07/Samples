/**
 * 
 */
package com.learn.spring.data.jpa.service;

import org.springframework.stereotype.Service;

import com.github.javafaker.Faker;

/**
 * @author Nilam Patil
 *
 */
@Service
public class DataFakerService {

	private Faker faker;

	public Faker getFaker() {
		if (faker == null)
			faker = new Faker();
		return faker;
	}

}
