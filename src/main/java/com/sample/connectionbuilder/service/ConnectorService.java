package com.sample.connectionbuilder.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sample.connectionbuilder.model.ConnectionData;
import com.sample.connectionbuilder.model.FlightResponse;
import com.sample.connectionbuilder.model.flight_schedule;
import com.sample.connectionbuilder.repository.ConnectorRepository;

@Service
public class ConnectorService {

	@Autowired
	ConnectorRepository repository;

	public FlightResponse getList(String from, String to) throws ParseException {
		List<flight_schedule> flightFromBOM = new ArrayList<flight_schedule>();
		List<flight_schedule> flightToJFK = new ArrayList<flight_schedule>();
		List<ConnectionData> connectionList = new ArrayList<ConnectionData>();
		flightFromBOM = repository.getFlightsBetween(from.toUpperCase(), "DXB");
		flightToJFK = repository.getFlightsBetween("DXB", to.toUpperCase());

		for (flight_schedule flightsBOM : flightFromBOM) {
			Date arr_time = getFlightTime(flightsBOM.getArr_time());
			for (flight_schedule flightsJFK : flightToJFK) {
				Date dept_time = getFlightTime(flightsJFK.getDept_time());
				long difference_In_Time = dept_time.getTime() - arr_time.getTime();
				if (difference_In_Time < 0) {
					Calendar newTime = Calendar.getInstance();
					newTime.setTime(dept_time);
					newTime.add(Calendar.DATE, 1);
					dept_time = newTime.getTime();
					difference_In_Time = dept_time.getTime() - arr_time.getTime();
				}
				long difference_In_Hours = (difference_In_Time / (1000 * 60 * 60)) % 24;
				if (difference_In_Hours >= 2 && difference_In_Hours <= 8) {
					connectionList.add(getFlightModel(flightsBOM, flightsJFK));
				}
			}
		}
		FlightResponse response = new FlightResponse();
		response.setConnetionData(connectionList);
		return response;
	}

	private Date getFlightTime(String time) {
		Calendar cal = Calendar.getInstance();
		String[] timings = time.split(":");
		cal.set(Calendar.HOUR_OF_DAY, Integer.valueOf(timings[0]));
		cal.set(Calendar.MINUTE, Integer.valueOf(timings[1]));
		Date retrunTime = cal.getTime();
		return retrunTime;
	}

	private ConnectionData getFlightModel(flight_schedule flightsBOM, flight_schedule flightsJFK) {
		ConnectionData data = new ConnectionData();
		data.setOnwardFltNo(flightsBOM.getFlight_no());
		data.setOnwardDepArpt(flightsBOM.getDept_airport());
		data.setOnwardArrArpt(flightsBOM.getArr_airport());
		data.setOnwardDepTime(flightsBOM.getDept_time());
		data.setOnwardArrTime(flightsBOM.getArr_time());
		data.setConnFltNo(flightsJFK.getFlight_no());
		data.setConnDepArpt(flightsJFK.getDept_airport());
		data.setConnArrArpt(flightsJFK.getArr_airport());
		data.setConnDepTime(flightsJFK.getDept_time());
		data.setConnArrTime(flightsJFK.getArr_time());
		return data;
	}
}
