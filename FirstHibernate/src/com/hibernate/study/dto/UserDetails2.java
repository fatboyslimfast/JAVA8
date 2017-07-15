package com.hibernate.study.dto;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@Entity
@Table(name = "USER_DETAILS")
public class UserDetails2 {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "USER_ID")
	private int userId;

	private String firstName;
	private String lastName;

	@Temporal(TemporalType.DATE)
	private LocalDate joinedDate;

	@Transient // not persisted
	private String fullName;

	@Lob
	private String description;

	@ElementCollection(fetch = FetchType.EAGER)
	@JoinTable(name = "USER_ADDRESS", joinColumns = @JoinColumn(name = "USER_ID"))
	private Collection<Address> previousAddresses = new ArrayList<Address>();

	/**
	 * @return the joinedDate
	 */
	public LocalDate getJoinedDate() {
		return joinedDate;
	}

	/**
	 * @param joinedDate
	 *            the joinedDate to set
	 */
	public void setJoinedDate(LocalDate joinedDate) {
		this.joinedDate = joinedDate;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description
	 *            the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the userId
	 */
	public int getUserId() {
		return userId;
	}

	/**
	 * @return the fullName
	 */
	public String getFullName() {
		return fullName;
	}

	/**
	 * @param userId
	 *            the userId to set
	 */
	public void setUserId(int userId) {
		this.userId = userId;
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param firstName
	 *            the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @param lastName
	 *            the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return the previousAddresses
	 */
	public Collection<Address> getPreviousAddresses() {
		return previousAddresses;
	}

	/**
	 * @param previousAddresses
	 *            the previousAddresses to set
	 */
	public void setPreviousAddresses(Collection<Address> previousAddresses) {
		this.previousAddresses = previousAddresses;
	}

}
