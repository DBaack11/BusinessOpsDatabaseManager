/***************************************************************
 * Name : Customer.java
 * Author: Devin Baack 
 * Created : 05/5/2021
 * Course: CIS 152 - Data Structures 
 * Version: 10.15.7 
 * OS: macOS Catalina 
 * IDE: Eclipse 2020-12
 * Copyright : This is my own original work based on specifications 
 * issued by our instructor 
 * Description : This program represents a Customer POJO.
 * Academic Honesty: I attest that this is my original work. I have
 * not used unauthorized source code, either modified or unmodified. 
 * I have not given other fellow student(s) access to my program.
 ***************************************************************
 * 
 * 
 * 
 */

package model;

/**
 * @author Devin Baack - dfbaack
 * CIS 152 - Spring 2021
 * Apr 11, 2021
 */
public class Customer {
	private String firstName;
	private String lastName;
	private String phoneNum;
	private String email;
	
	public Customer() {
		super();
	}
	
	public Customer(String firstName, String lastName, String phoneNum, String email) {
		super();
		this.setFirstName(firstName);
		this.setLastName(lastName);
		this.setPhoneNum(phoneNum);
		this.setAddress(email);
	}
	
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getPhoneNum() {
		return phoneNum;
	}

	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}

	public String getEmail() {
		return email;
	}

	public void setAddress(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return this.getFirstName() + " " + this.getLastName() + " - " + this.getPhoneNum() + " - " + this.getEmail();
	}
	
}
