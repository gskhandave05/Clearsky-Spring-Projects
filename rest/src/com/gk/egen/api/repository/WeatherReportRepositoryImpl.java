package com.gk.egen.api.repository;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import com.gk.egen.api.entity.WeatherReport;
import com.gk.egen.api.model.DailyAverageReport;
import com.gk.egen.api.model.HourlyAverageReport;

/**
 * @author gauravkhandave
 *	Date : 08/01/2017
 *	Version : 1.0.0
 *	
 *	Implementation of WeatherReportRepository to perform DB operations.
 */

@Repository
public class WeatherReportRepositoryImpl implements WeatherReportRepository {

	@PersistenceContext
	EntityManager em;

	@Value("20")
	private int batchSize;

	@Override
	public List<WeatherReport> findAll() {
		TypedQuery<WeatherReport> query = em.createNamedQuery("WeatherReport.findAll", WeatherReport.class);
		return query.getResultList();
	}

	@Override
	public WeatherReport findOne(String id) {
		return em.find(WeatherReport.class, id);
	}

	@Override
	public List<WeatherReport> findByCity(String city) {
		TypedQuery<WeatherReport> query = em.createNamedQuery("WeatherReport.findByCity", WeatherReport.class);
		query.setParameter("pCity", city);
		List<WeatherReport> result = query.getResultList();
		return result;
	}

	@Override
	@Transactional
	public WeatherReport create(WeatherReport weatherReport) {
		em.persist(weatherReport);
		return weatherReport;
	}

	@Override
	public WeatherReport update(WeatherReport weatherReport) {
		return em.merge(weatherReport);
	}

	@Override
	public void delete(WeatherReport weatherReport) {
		em.remove(weatherReport);
	}

	@Override
	public List<HourlyAverageReport> findHourlyAverageReportOfCity(String city) {
		Query query=em.createQuery("SELECT city,HOUR(timestamp) as hour, SUM(temperature) as sumOfTemperatures,count(*) as rowcount,Avg(temperature) as avgTemp FROM WeatherReport where city=:pCity GROUP BY HOUR(timestamp)");
		query.setParameter("pCity", city);
		List<Object[]> results = query.getResultList();
		List<HourlyAverageReport> reports = new ArrayList<>();
		for (Object[] result : results) {
			HourlyAverageReport report = new HourlyAverageReport(result[0].toString(),Integer.parseInt(result[1].toString()),Long.parseLong(result[2].toString()),Long.parseLong(result[3].toString()),Double.parseDouble(result[4].toString()));
			reports.add(report);
		}
		return reports;
	}

	@Override
	public List<DailyAverageReport> findDailyAverageReportOfCity(String city) {
		Query query=em.createQuery("SELECT city,DAY(timestamp) as day, SUM(temperature) as sumOfTemperatures,count(*) as rowcount,Avg(temperature) as avgTemp FROM WeatherReport where city=:pCity GROUP BY DAY(timestamp)");
		query.setParameter("pCity", city);
		List<Object[]> results = query.getResultList();
		List<DailyAverageReport> reports = new ArrayList<>();
		for (Object[] result : results) {
			DailyAverageReport report = new DailyAverageReport(result[0].toString(),Integer.parseInt(result[1].toString()),Long.parseLong(result[2].toString()),Long.parseLong(result[3].toString()),Double.parseDouble(result[4].toString()));
			reports.add(report);
		}
		return reports;
	}

}
