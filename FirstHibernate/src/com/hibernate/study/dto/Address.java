/**
 * 
 */
package com.hibernate.study.dto;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * @author Pete
 *
 */

@Embeddable
public class Address {

	@Column(name = "ADDRESS_LINE_ONE_NAME")
	String addressLineOne;
	@Column(name = "STREET_NAME")
	String addressLineTwo;
	@Column(name = "STREET_NAME_TWO")
	String addressLineThree;
	@Column(name = "CITY_NAME")
	String addressLineFour;
	@Column(name = "COUNTRY_NAME")
	String addressLineFive;
	@Column(name = "PIN")
	String addressLineSix;

	/**
	 * @return the addressLineOne
	 */
	public String getAddressLineOne() {
		return addressLineOne;
	}

	/**
	 * @return the addressLineTwo
	 */
	public String getAddressLineTwo() {
		return addressLineTwo;
	}

	/**
	 * @return the addressLineThree
	 */
	public String getAddressLineThree() {
		return addressLineThree;
	}

	/**
	 * @return the addressLineFour
	 */
	public String getAddressLineFour() {
		return addressLineFour;
	}

	/**
	 * @return the addressLineFive
	 */
	public String getAddressLineFive() {
		return addressLineFive;
	}

	/**
	 * @return the addressLineSix
	 */
	public String getAddressLineSix() {
		return addressLineSix;
	}

	/**
	 * @param addressLineOne
	 *            the addressLineOne to set
	 */
	public void setAddressLineOne(String addressLineOne) {
		this.addressLineOne = addressLineOne;
	}

	/**
	 * @param addressLineTwo
	 *            the addressLineTwo to set
	 */
	public void setAddressLineTwo(String addressLineTwo) {
		this.addressLineTwo = addressLineTwo;
	}

	/**
	 * @param addressLineThree
	 *            the addressLineThree to set
	 */
	public void setAddressLineThree(String addressLineThree) {
		this.addressLineThree = addressLineThree;
	}

	/**
	 * @param addressLineFour
	 *            the addressLineFour to set
	 */
	public void setAddressLineFour(String addressLineFour) {
		this.addressLineFour = addressLineFour;
	}

	/**
	 * @param addressLineFive
	 *            the addressLineFive to set
	 */
	public void setAddressLineFive(String addressLineFive) {
		this.addressLineFive = addressLineFive;
	}

	/**
	 * @param addressLineSix
	 *            the addressLineSix to set
	 */
	public void setAddressLineSix(String addressLineSix) {
		this.addressLineSix = addressLineSix;
	}

}
