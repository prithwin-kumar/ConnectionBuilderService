package com.sample.connectionbuilder.repository;

import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

import com.sample.connectionbuilder.model.flight_schedule;

import java.util.List;

import org.springframework.data.jpa.repository.Query;

public interface ConnectorRepository extends Repository<flight_schedule, Long> {

	@Query("SELECT f FROM flight_schedule f")
	public List<flight_schedule> getFlights();

	@Query("SELECT f FROM flight_schedule f WHERE f.dept_airport = :deptAirport AND f.arr_airport = :arrAirport")
	public List<flight_schedule> getFlightsBetween(@Param("deptAirport") String from,
			@Param("arrAirport") String to);
}
