/**
 * 
 */
package com.samples.java._8;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author Nilam Patil
 *
 */
public class Test {

	public static void main(String[] args) {
		// remove duplicate chars & how many duplicate chars

		List<Integer> intList = Arrays.asList(new Integer(97), new Integer(83), new Integer(85), new Integer(70),
				new Integer(78), new Integer(82));

		System.out.println(new Test().getThirdLargest(intList));

		removeDuplicateNgetCount("Swapnil Patil");
	}

	private static void removeDuplicateNgetCount(String string) {
		Map<Object, Long> charList = string.chars().mapToObj(c -> (char) c)
				.map(ch -> Character.toLowerCase(ch)).collect(Collectors.groupingBy(c -> c, Collectors.counting()));
		charList.forEach((key, value) -> {
			System.out.println(key + " " + value);
		});
	}

	public int getThirdLargest(List<Integer> intList) {

		return intList.stream().sorted().collect(Collectors.toList()).get(2);
	}
}
