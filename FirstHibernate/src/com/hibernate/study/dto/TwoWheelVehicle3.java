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
public class TwoWheelVehicle3 extends Vehicle3 {

	private String steeringHandle;

	public String getSteeringHandle() {
		return steeringHandle;
	}

	public void setSteeringHandle(String steeringHandle) {
		this.steeringHandle = steeringHandle;
	}

}
