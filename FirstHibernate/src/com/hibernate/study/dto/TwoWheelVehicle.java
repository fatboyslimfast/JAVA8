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
@DiscriminatorValue("Bicycle")
public class TwoWheelVehicle extends Vehicle {

	private String steeringHandle;

	public String getSteeringHandle() {
		return steeringHandle;
	}

	public void setSteeringHandle(String steeringHandle) {
		this.steeringHandle = steeringHandle;
	}

}
