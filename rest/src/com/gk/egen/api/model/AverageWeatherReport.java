package com.gk.egen.api.model;

/**
 * @author gauravkhandave
 *	Date : 08/01/2017
 *	Version : 1.0.0
 *	
 *	This class is a POJO for binding average weather results from database.
 */

public class AverageWeatherReport {

	private String city;
	private Long sumOfTemperatures;
	private Long rowcount;
	private Double avgTemp;

	public AverageWeatherReport(String city, Long sumOfTemperatures, Long rowcount, Double avgTemp) {
		this.city = city;
		this.sumOfTemperatures = sumOfTemperatures;
		this.rowcount = rowcount;
		this.avgTemp = avgTemp;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Long getSumOfTemperatures() {
		return sumOfTemperatures;
	}

	public void setSumOfTemperatures(Long sumOfTemperatures) {
		this.sumOfTemperatures = sumOfTemperatures;
	}

	public Long getrowCount() {
		return rowcount;
	}

	public void setrowCount(Long count) {
		this.rowcount = count;
	}

	public Double getAvgTemp() {
		return avgTemp;
	}

	public void setAvgTemp(Double avgTemp) {
		this.avgTemp = avgTemp;
	}

}
