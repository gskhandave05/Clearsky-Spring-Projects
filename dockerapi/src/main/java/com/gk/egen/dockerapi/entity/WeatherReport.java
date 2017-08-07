package com.gk.egen.dockerapi.entity;

import java.sql.Timestamp;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

/**
 * @author gauravkhandave
 *	Date : 08/01/2017
 *	Version : 1.0.0
 *	
 *	This is WeatherReport Entity for ORM mapping.
 */

@Entity
public class WeatherReport{

	@Id
	private String id;
	private String city;
	private String description;
	private Integer humidity;
	private Integer pressure;
	private Integer temperature;
	@OneToOne(cascade = {CascadeType.ALL})
	private Wind wind;
	private Timestamp timestamp;

	public WeatherReport() {
		this.id = UUID.randomUUID().toString();
	}
	
	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getHumidity() {
		return humidity;
	}

	public void setHumidity(Integer humidity) {
		this.humidity = humidity;
	}

	public Integer getPressure() {
		return pressure;
	}

	public void setPressure(Integer pressure) {
		this.pressure = pressure;
	}

	public Integer getTemperature() {
		return temperature;
	}

	public void setTemperature(Integer temperature) {
		this.temperature = temperature;
	}

	public Wind getWind() {
		return wind;
	}

	public void setWind(Wind wind) {
		this.wind = wind;
	}

	public Timestamp getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Timestamp timestamp) {
		this.timestamp = timestamp;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "WeatherReport [id=" + id + ", city=" + city + ", description=" + description + ", humidity=" + humidity
				+ ", pressure=" + pressure + ", temperature=" + temperature + ", wind=" + wind + ", timestamp="
				+ timestamp + "]";
	}
	
	
}
