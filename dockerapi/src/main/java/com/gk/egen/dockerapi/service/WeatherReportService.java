package com.gk.egen.dockerapi.service;

import java.util.List;
import java.util.Set;

import com.gk.egen.dockerapi.entity.WeatherReport;
import com.gk.egen.dockerapi.model.DailyAverageReport;
import com.gk.egen.dockerapi.model.HourlyAverageReport;



/**
 * @author gauravkhandave
 *	Date : 08/01/2017
 *	Version : 1.0.0
 *	
 *	Interface for Service layer.
 */

public interface WeatherReportService {

	public Set<String> listCities();

	public WeatherReport getLatestReport(String city);

	public String getLatestWeatherProperty(String city, String property);

	public List<HourlyAverageReport> getHourlyAverageWeather(String city);

	public List<DailyAverageReport> getDailyAverageWeather(String city);
	
	public void create(WeatherReport report);
	
	public void delete(WeatherReport report);


}
