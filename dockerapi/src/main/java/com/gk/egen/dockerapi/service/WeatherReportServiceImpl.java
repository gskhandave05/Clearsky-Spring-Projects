package com.gk.egen.dockerapi.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gk.egen.dockerapi.entity.WeatherReport;
import com.gk.egen.dockerapi.exceptionhandler.CustomException;
import com.gk.egen.dockerapi.model.DailyAverageReport;
import com.gk.egen.dockerapi.model.HourlyAverageReport;
import com.gk.egen.dockerapi.repository.WeatherReportRepository;



/**
 * @author gauravkhandave
 *	Date : 08/01/2017
 *	Version : 1.0.0
 *	
 *	WeatherReportService implementation to serve as per business logic.
 */

@Service
public class WeatherReportServiceImpl implements WeatherReportService {

	@Autowired
	WeatherReportRepository repository;

	@Override
	public Set<String> listCities() {

		List<WeatherReport> list = repository.findAll();
		if(list.isEmpty()){
			throw new CustomException("DB is empty");
		}
		Set<String> cities = new HashSet<String>();
		for (WeatherReport report : list) {
			cities.add(report.getCity());
		}
		return cities;
	}

	@Override
	public WeatherReport getLatestReport(String city) {
		List<WeatherReport> list = repository.findByCity(city);
		if(list.isEmpty()){
			throw new CustomException("No latest report found in DB for city :"+city);
		}

		return list.get(0);
	}

	@Override
	public String getLatestWeatherProperty(String city, String property) {
		List<WeatherReport> list = repository.findByCity(city);
		if(list.isEmpty()){
			throw new CustomException("No latest report found in DB for city :"+city);
		}
		WeatherReport latestReport = list.get(0);
		String result;
		switch (property.toLowerCase()) {
		case "city":
			result = latestReport.getCity();
			break;
		case "description":
			result = latestReport.getDescription();
			break;
		case "humidity":
			result = latestReport.getHumidity().toString();
			break;
		case "pressure":
			result = latestReport.getPressure().toString();
			break;
		case "temperature":
			result = latestReport.getTemperature().toString();
			break;
		case "wind":
			result = latestReport.getWind().toString();
			break;
		default:
			result = "Invalid Property";
			break;
		}
		return result;
	}

	@Override
	public List<HourlyAverageReport> getHourlyAverageWeather(String city) {
		List<HourlyAverageReport> list = repository.findHourlyAverageReportOfCity(city);
		if(list.isEmpty()){
			throw new CustomException("No report found in DB for city :"+city);
		}
		return list;
	}

	@Override
	public List<DailyAverageReport> getDailyAverageWeather(String city) {
		List<DailyAverageReport> list = repository.findDailyAverageReportOfCity(city);
		if(list.isEmpty()){
			throw new CustomException("No report found in DB for city :"+city);
		}
		return list;
	}

	@Override
	public void create(WeatherReport report) {
		repository.create(report);
	}


	@Override
	public void delete(WeatherReport report) {
		repository.delete(report);
	}

}
