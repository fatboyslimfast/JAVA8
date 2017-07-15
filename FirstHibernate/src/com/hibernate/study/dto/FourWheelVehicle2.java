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
public class FourWheelVehicle2 extends Vehicle2 {

	private String steeringWheel;

	public String getSteeringWheel() {
		return steeringWheel;
	}

	public void setSteeringWheel(String steeringWheel) {
		this.steeringWheel = steeringWheel;
	}

}
