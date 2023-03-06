/**
 * 
 */
package com.learn.spring.data.jpa.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learn.spring.data.jpa.entity.Student;
import com.learn.spring.data.jpa.repository.StudentRepository;

/**
 * @author Nilam Patil
 *
 */
@Service
public class StudentDataService {
	@Autowired
	private StudentRepository studentRepository;

	/**
	 * 
	 * @return
	 */
	public List<Student> getAllStudentData() {
		return studentRepository.findAll();
	}

	/**
	 * 
	 * @param list
	 * @return
	 */
	@Transactional
	public List<Student> saveListOfStudents(List<Student> list) {
		return studentRepository.saveAll(list);
	}

	/**
	 * 
	 */
	@Transactional
	public void deleteAllStudents() {
		studentRepository.deleteAll();
	}
}
