/**
 * 
 */
package com.samples.java.beans;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author Nilam Patil
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Employee {
	private String empName;
	private Integer empNo;
	private String address;
	private String department;
	private Integer age;
}
