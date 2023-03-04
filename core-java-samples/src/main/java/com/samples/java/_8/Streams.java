/**
 * 
 */
package com.samples.java._8;

import java.util.AbstractMap;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.samples.java.beans.Employee;
import com.samples.java.util.DataService;

/**
 * @author Nilam Patil
 *
 */
public class Streams {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Map<String, List<Employee>> groupBy = groupBy(DataService.getEmpData(10));
		groupBy.forEach((key, value) -> System.out.println("Key: " + key + " Value: " + value));

		System.out.println("----------------------------------------------------------------------");

		Map<String, List<Employee>> sortBy = sortBy(DataService.getEmpData(10));
		sortBy.forEach((key, value) -> System.out.println("Key: " + key + " Value: " + value));

		System.out.println("----------------------------------------------------------------------");
		sortList(DataService.getEmpData(10)).forEach(System.out::println);

		System.out.println("----------------------------------------------------------------------");
		sortListByComparator(DataService.getEmpData(50)).forEach(System.out::println);

		System.out.println("----------------------------------------------------------------------");
		Map<String, Map<Integer, List<Employee>>> groupByMultiField = groupByMultiField(DataService.getEmpData(50));
		groupByMultiField.forEach((key, value) -> {
			System.out.println("Key: " + key);
			value.forEach((subKey, subValue) -> {
				System.out.println("Sub Key: " + subKey);
				subValue.forEach(val -> System.out.println("Emp: " + val.toString()));
			});
			System.out.println("----------------------------------------------------------------------");
		});

		System.out.println("----------------------------------------------------------------------");
		groupByNo(DataService.getRondomNos(20)).forEach((key, value) -> {
			System.out.println("Key: " + key + " Value: " + value);
		});
	}

	/**
	 * Group employee object by department
	 * 
	 * @param empList
	 * @return
	 */
	public static Map<String, List<Employee>> groupBy(List<Employee> empList) {
		return empList.stream().collect(Collectors.groupingBy(Employee::getDepartment));
	}

	/**
	 * 
	 * @param empList
	 * @return
	 */
	public static Map<String, Map<Integer, List<Employee>>> groupByMultiField(List<Employee> empList) {
		return empList.stream()
				.collect(Collectors.groupingBy(Employee::getDepartment, Collectors.groupingBy(Employee::getAge)));
	}

	/**
	 * sort employee map by key (department)
	 * 
	 * @param empList
	 * @return
	 */
	public static Map<String, List<Employee>> sortBy(List<Employee> empList) {
		return empList.stream().collect(Collectors.groupingBy(Employee::getDepartment)).entrySet().stream()
				.sorted(Map.Entry.comparingByKey()).collect(Collectors.toMap(entry -> entry.getKey(),
						entry -> entry.getValue(), (oldValue, newValue) -> oldValue, LinkedHashMap::new));
	}

	/**
	 * 
	 * @param empList
	 * @return
	 */
	public static List<Employee> sortList(List<Employee> empList) {
		return empList.stream().sorted((e1, e2) -> e1.getEmpNo().compareTo(e2.getEmpNo()))
				/* .sorted((e1, e2) -> e1.getEmpName().compareTo(e2.getEmpName())) */.collect(Collectors.toList());
	}

	/**
	 * Sort list by multiple fields. <br>
	 * Here employee list sorted by department and then employee name
	 * 
	 * @param empList
	 * @return
	 */
	public static List<Employee> sortListByComparator(List<Employee> empList) {
		return empList.stream()
				.sorted(Comparator.comparing(Employee::getDepartment).thenComparing(Employee::getEmpName))
				.collect(Collectors.toList());
	}

	/**
	 * 
	 * @param list
	 * @return
	 */
	public static Map<Integer, Integer> groupByNo(List<Integer> list) {
		return list.stream().collect(Collectors.groupingBy(Integer::intValue)).entrySet().stream()
				.map(entry -> new AbstractMap.SimpleEntry<>(entry.getKey(), entry.getValue().size()))
				.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
	}

	/**
	 * 
	 * @param list
	 * @return
	 */
	public static Map<Integer, List<Integer>> groupByNo1(List<Integer> list) {
		return list.stream().collect(Collectors.groupingBy(Integer::intValue));
	}

}
