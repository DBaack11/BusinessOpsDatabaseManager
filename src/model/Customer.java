/**
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
