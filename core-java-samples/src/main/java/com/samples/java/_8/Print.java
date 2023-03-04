/**
 * 
 */
package com.samples.java._8;

import com.samples.java.iv.Employee;

/**
 * @author Nilam Patil
 *
 */
@FunctionalInterface
public interface Print {
	Boolean match(Employee e1, Employee e2);
}
