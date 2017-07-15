/**
 * 
 */
package com.hibernate.study.dto;

import javax.persistence.Entity;

/**
 * @author Pete
 *
 */
@Entity
public class FourWheelVehicle3 extends Vehicle3 {

	private String steeringWheel;

	public String getSteeringWheel() {
		return steeringWheel;
	}

	public void setSteeringWheel(String steeringWheel) {
		this.steeringWheel = steeringWheel;
	}

}
