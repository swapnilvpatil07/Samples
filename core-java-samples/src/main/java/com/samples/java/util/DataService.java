/**
 * 
 */
package com.samples.java.util;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import com.github.javafaker.Faker;
import com.samples.java.beans.Employee;

/**
 * @author Nilam Patil
 *
 */
public class DataService {

	/**
	 * 
	 * @param noOfRecords
	 * @return
	 */
	public static List<Employee> getEmpData(int noOfRecords) {
		Faker faker = new Faker();
		return IntStream.range(1, noOfRecords).boxed()
				.map(no -> new Employee(faker.name().fullName().toString(), no,
						faker.address().fullAddress().toString(), faker.commerce().department().toString(),
						faker.number().numberBetween(1, 10)))
				.collect(Collectors.toList());
	}

	/**
	 * 
	 * @param size
	 * @return
	 */
	public static List<Integer> getRondomNos(int size) {
		return new Random().ints(size, 1, 10).mapToObj(i -> i).collect(Collectors.toList());
	}
}
