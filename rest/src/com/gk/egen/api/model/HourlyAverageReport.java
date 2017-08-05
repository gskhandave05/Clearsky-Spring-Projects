package com.gk.egen.api.model;

/**
 * @author gauravkhandave
 *	Date : 08/01/2017
 *	Version : 1.0.0
 *	
 *	This class is a POJO for binding average weather results from database.
 */

public class HourlyAverageReport extends AverageWeatherReport{

	private Integer hour;
	
	public HourlyAverageReport(String city, Integer hour, Long sumOfTemperatures, Long rowcount, Double avgTemp) {
		super(city, sumOfTemperatures, rowcount, avgTemp);
		this.setHour(hour);
	}

	public Integer getHour() {
		return hour;
	}

	public void setHour(Integer hour) {
		this.hour = hour;
	}

}
