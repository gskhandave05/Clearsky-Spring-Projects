package com.gk.egen.dockerapi.repository;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.gk.egen.dockerapi.entity.WeatherReport;
import com.gk.egen.dockerapi.model.DailyAverageReport;
import com.gk.egen.dockerapi.model.HourlyAverageReport;



/**
 * @author gauravkhandave
 *	Date : 08/01/2017
 *	Version : 1.0.0
 *	
 *	Implementation of WeatherReportRepository to perform DB operations.
 */

@Repository
public class WeatherReportRepositoryImpl implements WeatherReportRepository,CrudRepository<WeatherReport,String> {

	@PersistenceContext
	EntityManager em;

	@Override
	public List<WeatherReport> findByCity(String city) {
		TypedQuery<WeatherReport> query = em.createQuery("SELECT u FROM WeatherReport u where u.city=:pCity ORDER BY u.timestamp", WeatherReport.class);
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

	@Override
	public long count() {
		return 0;
	}

	@Override
	public void delete(String arg0) {
		
	}

	@Override
	public void delete(Iterable<? extends WeatherReport> arg0) {
		
	}

	@Override
	public void deleteAll() {
		
	}

	@Override
	public boolean exists(String arg0) {
		return false;
	}

	@Override
	public Iterable<WeatherReport> findAll(Iterable<String> arg0) {
		return null;
	}

	@Override
	public <S extends WeatherReport> S save(S arg0) {
		return null;
	}

	@Override
	public <S extends WeatherReport> Iterable<S> save(Iterable<S> arg0) {
		return null;
	}

	@Override
	public List<WeatherReport> findAll() {
		TypedQuery<WeatherReport> query = em.createQuery("SELECT u FROM WeatherReport u ORDER BY u.city",WeatherReport.class);
		List<WeatherReport> list = query.getResultList();
		return list;
	}

	@Override
	public WeatherReport findOne(String id) {
		// TODO Auto-generated method stub
		return null;
	}

}
