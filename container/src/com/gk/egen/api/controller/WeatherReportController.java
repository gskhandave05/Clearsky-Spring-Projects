package com.gk.egen.api.controller;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.gk.egen.api.entity.WeatherReport;
import com.gk.egen.api.model.DailyAverageReport;
import com.gk.egen.api.model.HourlyAverageReport;
import com.gk.egen.api.service.WeatherReportService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * @author gauravkhandave
 *	Date : 08/01/2017
 *	Version : 1.0.0
 *	
 *	This is Weather Report Controller for mapping requests to REST end points.
 */

@RestController
@RequestMapping("weather-boot")
@Api(tags = "weather-boot")
public class WeatherReportController {

	@Autowired
	WeatherReportService service;

	@RequestMapping(method = RequestMethod.GET)
	@ApiOperation(value = "Find All cities", notes = "Returns a list of cities in the app")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success"),
			@ApiResponse(code = 500, message = "Internal Server Error"), })
	public Set<String> listAllCities() {
		return service.listCities();
	}

	@RequestMapping(method = RequestMethod.GET, value = "{city}")
	@ApiOperation(value = "Find latest weather report of given city", notes = "Returns a latest weather report by city if it exists in the app")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success"),
			@ApiResponse(code = 404, message = "Not Found"),
			@ApiResponse(code = 500, message = "Internal Server Error"), })
	public WeatherReport findOne(@PathVariable("city") String city) {
		return service.getLatestReport(city);
	}
	
	@CrossOrigin(origins="http://mocker.egen.io",allowCredentials="true",allowedHeaders="Access-Control-Allow-Origin,accept, origin,content-type, Access-Control-Request-Method",maxAge=4800)
	@RequestMapping(value="mock-weather",method=RequestMethod.POST)
	@ApiOperation(value = "Insert payload", notes = "Gets data from mocker.egen.io and stores it in database")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success"),
			@ApiResponse(code = 400, message = "Bad Request"),
			@ApiResponse(code = 500, message = "Internal Server Error"), })
	public String create(@RequestBody WeatherReport report){
			
		service.create(report);
          
		return "Success";
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "{city}/{property}")
	@ApiOperation(value = "Find latest weather property of given city", notes = "Returns a latest weather property of city if it exists in the app")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success"),
			@ApiResponse(code = 404, message = "Not Found"),
			@ApiResponse(code = 500, message = "Internal Server Error"), })
	public String getLatestWeatherPropertyOfCity(@PathVariable("city") String city,@PathVariable("property") String property){
		return service.getLatestWeatherProperty(city, property);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "hourly-avg/{city}")
	@ApiOperation(value = "Find hourly average weather of given city", notes = "Returns a hourly average weather of city if it exists in the app")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success"),
			@ApiResponse(code = 404, message = "Not Found"),
			@ApiResponse(code = 500, message = "Internal Server Error"), })
	public List<HourlyAverageReport> getHourlyAvgWeatherOfCity(@PathVariable("city") String city){
		return service.getHourlyAverageWeather(city);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "daily-avg/{city}")
	@ApiOperation(value = "Find daily average weather of given city", notes = "Returns a daily average weather of city if it exists in the app")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success"),
			@ApiResponse(code = 404, message = "Not Found"),
			@ApiResponse(code = 500, message = "Internal Server Error"), })
	public List<DailyAverageReport> getDailyAvgWeatherOfCity(@PathVariable("city") String city){
		return service.getDailyAverageWeather(city);
	}

}
