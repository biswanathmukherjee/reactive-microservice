/**
 * 
 */
package com.ibm.learn.reactive.microservice.models;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author 072817744
 *
 */
// Use of Lombok
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class CricketerDTO {

	private int id;
	private String firstName;
	private String lastName;
	private String role;
	private float battingAverage;
	private int wicketsTaken;
	private List<String> teams;
	
//	/**
//	 * @param firstName
//	 * @param lastName
//	 * @param role
//	 * @param battingAverage
//	 * @param wicketsTaken
//	 */
//	public Cricketer(String firstName, String lastName, String role, float battingAverage, int wicketsTaken) {
//		super();
//		this.firstName = firstName;
//		this.lastName = lastName;
//		this.role = role;
//		this.battingAverage = battingAverage;
//		this.wicketsTaken = wicketsTaken;
//	}
//	/**
//	 * @return the firstName
//	 */
//	public String getFirstName() {
//		return firstName;
//	}
//	/**
//	 * @param firstName the firstName to set
//	 */
//	public void setFirstName(String firstName) {
//		this.firstName = firstName;
//	}
//	/**
//	 * @return the lastName
//	 */
//	public String getLastName() {
//		return lastName;
//	}
//	/**
//	 * @param lastName the lastName to set
//	 */
//	public void setLastName(String lastName) {
//		this.lastName = lastName;
//	}
//	/**
//	 * @return the role
//	 */
//	public String getRole() {
//		return role;
//	}
//	/**
//	 * @param role the role to set
//	 */
//	public void setRole(String role) {
//		this.role = role;
//	}
//	/**
//	 * @return the battingAverage
//	 */
//	public float getBattingAverage() {
//		return battingAverage;
//	}
//	/**
//	 * @param battingAverage the battingAverage to set
//	 */
//	public void setBattingAverage(float battingAverage) {
//		this.battingAverage = battingAverage;
//	}
//	/**
//	 * @return the wicketsTaken
//	 */
//	public int getWicketsTaken() {
//		return wicketsTaken;
//	}
//	/**
//	 * @param wicketsTaken the wicketsTaken to set
//	 */
//	public void setWicketsTaken(int wicketsTaken) {
//		this.wicketsTaken = wicketsTaken;
//	}
//	@Override
//	public String toString() {
//		return "Cricketer [firstName=" + firstName + ", lastName=" + lastName + ", role=" + role + ", battingAverage="
//				+ battingAverage + ", wicketsTaken=" + wicketsTaken + "]";
//	}
//	

}
