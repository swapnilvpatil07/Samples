/**
 * 
 */
package com.samples.java._8;

import java.util.Date;

/**
 * @author Nilam Patil
 *
 */
public class Emplyee {
	final Date date;

	public Emplyee(Date date) {
		this.date = (Date) date.clone();
	}

	public Date getDate() throws CloneNotSupportedException {
		Date date = (Date) this.date.clone();
		return date;
	}

	public static void main(String[] args) throws CloneNotSupportedException {
		Date d1 = new Date();
		Emplyee e1 = new Emplyee(d1);
		System.out.println(e1.getDate());

		d1.setTime(1225687);
		System.out.println(e1.getDate());
	}
}
