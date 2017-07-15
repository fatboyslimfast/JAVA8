package com.hibernate.study.dto;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
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

import org.hibernate.annotations.CollectionId;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

@Entity
@Table(name = "USER_DETAILS")
public class UserDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "USER_ID")
	private int userId;

	private String firstName;
	private String lastName;

	/*
	 * @Embedded // optional
	 * 
	 * @AttributeOverrides({
	 * 
	 * @AttributeOverride(name = "addressLineOne", column = @Column(name =
	 * "HOME_ADDRESS_LINE_ONE_NAME")),
	 * 
	 * @AttributeOverride(name = "addressLineTwo", column = @Column(name =
	 * "HOME_STREET_NAME")),
	 * 
	 * @AttributeOverride(name = "addressLineThree", column = @Column(name =
	 * "HOME_STREET_NAME_TWO")),
	 * 
	 * @AttributeOverride(name = "addressLineFour", column = @Column(name =
	 * "HOME_CITY_NAME")),
	 * 
	 * @AttributeOverride(name = "addressLineFive", column = @Column(name =
	 * "HOME_COUNTRY_NAME")),
	 * 
	 * @AttributeOverride(name = "addressLineSix", column = @Column(name =
	 * "HOME_PIN")), }) private Address homeAddress;
	 * 
	 * @Embedded
	 * 
	 * @AttributeOverrides({
	 * 
	 * @AttributeOverride(name = "addressLineOne", column = @Column(name =
	 * "OFFICE_ADDRESS_LINE_ONE_NAME")),
	 * 
	 * @AttributeOverride(name = "addressLineTwo", column = @Column(name =
	 * "OFFICE_STREET_NAME")),
	 * 
	 * @AttributeOverride(name = "addressLineThree", column = @Column(name =
	 * "OFFICE_STREET_NAME_TWO")),
	 * 
	 * @AttributeOverride(name = "addressLineFour", column = @Column(name =
	 * "OFFICE_CITY_NAME")),
	 * 
	 * @AttributeOverride(name = "addressLineFive", column = @Column(name =
	 * "OFFICE_COUNTRY_NAME")),
	 * 
	 * @AttributeOverride(name = "addressLineSix", column = @Column(name =
	 * "OFFICE_PIN")), }) private Address officeAddress;
	 */

	@Temporal(TemporalType.DATE)
	private LocalDate joinedDate;

	@Transient // not persisted
	private String fullName;

	@Lob
	private String description;

	@ElementCollection
	@JoinTable(name = "USER_ADDRESS", joinColumns = @JoinColumn(name = "USER_ID"))
	@GenericGenerator(name = "hilo-gen", strategy = "hilo")
	@CollectionId(columns = { @Column(name = "ADDRESS_ID") }, generator = "hio-gen", type = @Type(type = "long"))
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
	public Set<Address> getPreviousAddresses() {
		return previousAddresses;
	}

	/**
	 * @param previousAddresses
	 *            the previousAddresses to set
	 */
	public void setPreviousAddresses(Set<Address> previousAddresses) {
		this.previousAddresses = previousAddresses;
	}

}
