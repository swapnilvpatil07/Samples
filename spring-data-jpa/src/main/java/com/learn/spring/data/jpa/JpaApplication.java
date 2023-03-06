/**
 * 
 */
package com.learn.spring.data.jpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

/**
 * @author Nilam Patil
 *
 */
@SpringBootApplication
@EntityScan(basePackages = { "com.learn.spring.data.jpa" })
public class JpaApplication {
	public static void main(String[] args) {
		SpringApplication.run(JpaApplication.class, args);
	}
}
