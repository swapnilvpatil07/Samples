/**
 * 
 */
package com.learn.spring.data.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.learn.spring.data.jpa.entity.Student;

/**
 * @author Nilam Patil
 * 
 *         We can define many methods as shown on the official page.
 * @see <a href=
 *      "https://docs.spring.io/spring-data/jpa/docs/1.5.0.RELEASE/reference/html/jpa.repositories.html">
 *      Official Page</a>
 *
 */
@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

}
