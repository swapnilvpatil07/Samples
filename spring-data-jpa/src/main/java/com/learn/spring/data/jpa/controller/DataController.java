/**
 * 
 */
package com.learn.spring.data.jpa.controller;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.javafaker.Faker;
import com.learn.spring.data.jpa.entity.Guardian;
import com.learn.spring.data.jpa.entity.Student;
import com.learn.spring.data.jpa.service.DataFakerService;
import com.learn.spring.data.jpa.service.StudentDataService;

/**
 * @author Nilam Patil
 *
 */
@RestController
@RequestMapping(path = "/api/data")
public class DataController {

	@Autowired
	private DataFakerService fakerService;

	@Autowired
	private StudentDataService studentDataService;

	@PutMapping(path = "/put/student/{count}")
	public ResponseEntity<List<Student>> putStudentData(@PathVariable int count) {
		Faker faker = fakerService.getFaker();

		List<Student> list = IntStream.rangeClosed(1, count)
				.mapToObj(no -> Student.builder().studentName(faker.name().fullName())
						.emailAddress(faker.internet().safeEmailAddress()).build())
				.peek(student -> student
						.setEmailAddress(Arrays.asList(student.getStudentName().replace(".", "").split(" ")).stream()
								.collect(Collectors.joining(".")).concat("@example.com")))
				.peek(student -> student.setGuardian(Guardian.builder().name(faker.name().fullName())
						.mobile(faker.phoneNumber().cellPhone()).email(faker.internet().emailAddress()).build()))
				.collect(Collectors.toList());

		List<Student> savedStudentList = studentDataService.saveListOfStudents(list);
		return new ResponseEntity<>(savedStudentList, HttpStatus.CREATED);
	}

	@DeleteMapping(path = "/delete/students")
	public ResponseEntity<String> deleteStudentData() {
		studentDataService.deleteAllStudents();
		return new ResponseEntity<String>("All students deleted!!!", HttpStatus.OK);
	}

}
