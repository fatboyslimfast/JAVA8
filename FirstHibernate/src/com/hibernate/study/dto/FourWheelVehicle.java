/**
 * 
 */
package com.hibernate.study.dto;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * @author Pete
 *
 */
@Entity
@DiscriminatorValue("Car")
public class FourWheelVehicle extends Vehicle {

	private String steeringWheel;

	public String getSteeringWheel() {
		return steeringWheel;
	}

	public void setSteeringWheel(String steeringWheel) {
		this.steeringWheel = steeringWheel;
	}

}
