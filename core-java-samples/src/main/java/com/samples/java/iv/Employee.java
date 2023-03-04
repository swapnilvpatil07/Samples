/**
 * 
 */
package com.samples.java.iv;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Nilam Patil
 * 
 *         Immutable Class Example
 *
 */
public class Employee {
	final String empName;
	final Date joiningDate;
	final List<String> addresses;

	public Employee(String empName, Date joiningDate, List<String> addresses) {
		this.empName = empName;
		this.joiningDate = (Date) joiningDate.clone();
		this.addresses = addresses;

	}

	public Date getJoiningDate() throws CloneNotSupportedException {
		Date date = (Date) this.joiningDate.clone();
		return date;
	}

	public String getEmpName() {
		return empName;
	}

	public List<String> getAddresses() {
		return addresses.stream().collect(Collectors.toList());
	}

	public static void main(String[] args) throws CloneNotSupportedException {
		Date d1 = new Date();
		Employee e1 = new Employee("Swapnil", d1, new ArrayList<String>(Arrays.asList("Karad", "Satara", "Pune")));
		System.out.println(e1.getJoiningDate());
		System.out.println(e1.getAddresses());

		d1.setTime(1225687);
		List<String> add = e1.getAddresses();
		add.add("Mumbai");

		System.out.println(e1.getJoiningDate());
		System.out.println(e1.getAddresses());
	}
}
