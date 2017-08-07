package com.gk.egen.dockerapi.repository;

import java.util.List;

import com.gk.egen.dockerapi.entity.WeatherReport;
import com.gk.egen.dockerapi.model.DailyAverageReport;
import com.gk.egen.dockerapi.model.HourlyAverageReport;



/**
 * @author gauravkhandave
 *	Date : 08/01/2017
 *	Version : 1.0.0
 *	
 *	Interface for database operations
 */

public interface WeatherReportRepository {

	public List<WeatherReport> findAll();

	public WeatherReport findOne(String id);
	
	public WeatherReport create(WeatherReport weatherReport);

	public List<WeatherReport> findByCity(String city);
	
	public List<HourlyAverageReport> findHourlyAverageReportOfCity(String city);
	
	public List<DailyAverageReport> findDailyAverageReportOfCity(String city);
	
	public void delete(WeatherReport weatherReport);
	
	
}
