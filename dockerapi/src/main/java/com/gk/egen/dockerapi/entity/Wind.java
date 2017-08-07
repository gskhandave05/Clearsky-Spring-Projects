package com.gk.egen.dockerapi.entity;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @author gauravkhandave
 *	Date : 08/01/2017
 *	Version : 1.0.0
 *	
 *	This is Wind Entity for ORM mapping.
 */

@Entity
public class Wind {

	@Id
	private String id;
	private Double speed;
	private Integer degree;
	
	public Wind() {
		this.id = UUID.randomUUID().toString();
	}

	public Double getSpeed() {
		return speed;
	}

	public void setSpeed(Double speed) {
		this.speed = speed;
	}

	public Integer getDegree() {
		return degree;
	}

	public void setDegree(Integer degree) {
		this.degree = degree;
	}

	@Override
	public String toString() {
		return "Wind [speed=" + speed + ", degree=" + degree + "]";
	}

	
}
