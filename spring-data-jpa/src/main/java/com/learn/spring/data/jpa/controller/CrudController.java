/**
 * 
 */
package com.learn.spring.data.jpa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learn.spring.data.jpa.entity.Student;
import com.learn.spring.data.jpa.service.StudentDataService;

/**
 * @author Nilam Patil
 *
 */
@RestController
@RequestMapping(path = "/api/crud")
public class CrudController {

	@Autowired
	private StudentDataService studentDataService;

	@GetMapping(path = "/getAllStudentData")
	private ResponseEntity<List<Student>> getStudentData() {
		List<Student> data = studentDataService.getAllStudentData();
		return new ResponseEntity<>(data, HttpStatus.OK);
	}
}
