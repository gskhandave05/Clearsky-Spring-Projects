package com.gk.egen.api.model;

/**
 * @author gauravkhandave
 *	Date : 08/01/2017
 *	Version : 1.0.0
 *	
 *	This class is a POJO for binding average weather results from database.
 */

public class DailyAverageReport extends AverageWeatherReport{

	private Integer day;
	
	public DailyAverageReport(String city, Integer day, Long sumOfTemperatures, Long rowcount, Double avgTemp) {
		super(city, sumOfTemperatures, rowcount, avgTemp);
		this.day=day;
	}

	public Integer getDay() {
		return day;
	}

	public void setDay(Integer day) {
		this.day = day;
	}

}
